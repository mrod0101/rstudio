/*
 * CompilePdfOutputPresenter.java
 *
 * Copyright (C) 2021 by RStudio, PBC
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.workbench.views.output.compilepdf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.inject.Inject;

import org.rstudio.core.client.CodeNavigationTarget;
import org.rstudio.core.client.CommandUtil;
import org.rstudio.core.client.command.CommandBinder;
import org.rstudio.core.client.command.Handler;
import org.rstudio.core.client.events.*;
import org.rstudio.core.client.files.FileSystemItem;
import org.rstudio.core.client.widget.MessageDialog;
import org.rstudio.core.client.widget.Operation;
import org.rstudio.studio.client.application.events.EventBus;
import org.rstudio.studio.client.common.DelayedProgressRequestCallback;
import org.rstudio.studio.client.common.GlobalDisplay;
import org.rstudio.studio.client.common.compile.CompileOutput;
import org.rstudio.studio.client.common.compilepdf.events.CompilePdfCompletedEvent;
import org.rstudio.studio.client.common.compilepdf.events.CompilePdfErrorsEvent;
import org.rstudio.studio.client.common.compilepdf.events.CompilePdfOutputEvent;
import org.rstudio.studio.client.common.compilepdf.events.CompilePdfStartedEvent;
import org.rstudio.studio.client.common.compilepdf.model.CompilePdfServerOperations;
import org.rstudio.studio.client.common.compilepdf.model.CompilePdfState;
import org.rstudio.studio.client.common.filetypes.FileTypeRegistry;
import org.rstudio.studio.client.common.synctex.model.SourceLocation;
import org.rstudio.studio.client.server.VoidServerRequestCallback;
import org.rstudio.studio.client.workbench.commands.Commands;
import org.rstudio.studio.client.workbench.views.BusyPresenter;
import org.rstudio.studio.client.workbench.views.console.events.ConsoleActivateEvent;
import org.rstudio.studio.client.workbench.views.output.OutputConstants;
import org.rstudio.studio.client.workbench.views.output.common.CompileOutputPaneDisplay;
import org.rstudio.studio.client.workbench.views.output.common.CompileOutputPaneFactory;
import org.rstudio.studio.client.workbench.views.output.compilepdf.events.CompilePdfEvent;


public class CompilePdfOutputPresenter extends BusyPresenter
   implements CompilePdfEvent.Handler,
              CompilePdfStartedEvent.Handler,
              CompilePdfOutputEvent.Handler,
              CompilePdfErrorsEvent.Handler,
              CompilePdfCompletedEvent.Handler
{
   public interface Binder extends CommandBinder<Commands, CompilePdfOutputPresenter> {}

   @Inject
   public CompilePdfOutputPresenter(CompileOutputPaneFactory outputFactory,
                                    Binder binder,
                                    GlobalDisplay globalDisplay,
                                    CompilePdfServerOperations server,
                                    FileTypeRegistry fileTypeRegistry,
                                    Commands commands,
                                    EventBus events)
   {
      super(outputFactory.create("Compile PDF",
                                 constants_.viewLogTitle()));
      binder.bind(commands, this);
      view_ = (CompileOutputPaneDisplay) getView();
      globalDisplay_ = globalDisplay;
      server_ = server;
      fileTypeRegistry_ = fileTypeRegistry;
      events_ = events;
      commands_ = commands;

      view_.stopButton().addClickHandler(event ->
      {
         terminateCompilePdf(null);
      });

      view_.showLogButton().addClickHandler(event ->
      {
         FileSystemItem logFile = FileSystemItem.createFile(
                     targetFile_.getParentPath().completePath(
                                         targetFile_.getStem() + ".log"));
         fileTypeRegistry_.editFile(logFile);
      });

      view_.errorList().addSelectionCommitHandler(
         (SelectionCommitEvent<CodeNavigationTarget> event) ->
      {
         CodeNavigationTarget target = event.getSelectedItem();
         FileSystemItem fsi = FileSystemItem.createFile(target.getFile());
         fileTypeRegistry_.editFile(fsi, target.getPosition());
      });
   }

   public void initialize(CompilePdfState compilePdfState)
   {
      view_.ensureVisible(false);

      view_.clearAll();

      compileStarted(compilePdfState.getTargetFile());

      view_.showOutput(CompileOutput.create(CompileOutput.kNormal,
                                            compilePdfState.getOutput()),
                                            false);

      if (compilePdfState.getErrors().length() > 0)
         view_.showErrors(compilePdfState.getErrors());

      if (!compilePdfState.isRunning())
         view_.compileCompleted();

      view_.scrollToBottom();
   }

   public void confirmClose(Command onConfirmed)
   {
      // wrap the onConfirmed in another command which notifies the server
      // that we've closed the tab
      final Command confirmedCommand = CommandUtil.join(onConfirmed,
                                                        new Command() {
         @Override
         public void execute()
         {
            server_.compilePdfClosed(new VoidServerRequestCallback());
         }
      });

      server_.isCompilePdfRunning(
        new DelayedProgressRequestCallback<Boolean>(constants_.closingCompilePDFProgressMessage()) {
         @Override
         public void onSuccess(Boolean isRunning)
         {
            if (isRunning)
            {
               confirmTerminateRunningCompile(constants_.closeCompilePDF(),
                                              confirmedCommand);
            }
            else
            {
               confirmedCommand.execute();
            }
         }
      });

   }

   @Override
   public void onCompilePdf(CompilePdfEvent event)
   {
      // switch back to the console after compile unless the compile pdf
      // tab was already visible
      switchToConsoleOnSuccessfulCompile_ = !view_.isEffectivelyVisible();

      // activate the compile pdf tab
      view_.ensureVisible(true);

      // run the compile
      compilePdf(event.getTargetFile(),
                 event.getEncoding(),
                 event.getSourceLocation(),
                 event.getCompletedAction());
   }

   @Override
   public void onCompilePdfOutput(CompilePdfOutputEvent event)
   {
      view_.showOutput(event.getOutput(), true);
   }

   @Override
   public void onCompilePdfErrors(CompilePdfErrorsEvent event)
   {
      view_.showErrors(event.getErrors());
   }

   @Override
   public void onCompilePdfStarted(CompilePdfStartedEvent event)
   {
      compileStarted(event.getTargetFile());
   }

   @Override
   public void onCompilePdfCompleted(CompilePdfCompletedEvent event)
   {
      view_.compileCompleted();
      setIsBusy(false);

      if (event.getResult().getSucceeded() &&
          switchToConsoleOnSuccessfulCompile_)
      {
         events_.fireEvent(new ConsoleActivateEvent(false));
      }
      else if (!event.getResult().getSucceeded())
      {
         view_.ensureVisible(true);
      }
   }

   @Override
   public void onSelected()
   {
      super.onSelected();
      Scheduler.get().scheduleDeferred(new Command()
      {
         @Override
         public void execute()
         {
            view_.scrollToBottom();
         }
      });
   }

   @Handler
   public void onActivateCompilePDF()
   {
      // Ensure that console pane is not minimized
      commands_.activateConsolePane().execute();
      view_.bringToFront();
   }

   private void compileStarted(String targetFile)
   {
      targetFile_ = FileSystemItem.createFile(targetFile);
      view_.compileStarted(targetFile);
   }

   private void compilePdf(FileSystemItem targetFile,
                           String encoding,
                           SourceLocation sourceLocation,
                           String completedAction)
   {
      // attempt to start a compilation (this might not actually work
      // if there is already a compile running)
      server_.compilePdf(
            targetFile,
            encoding,
            sourceLocation,
            completedAction,
            new DelayedProgressRequestCallback<Boolean>(constants_.compilingPDFProgressMessage())
            {
               @Override
               protected void onSuccess(Boolean started)
               {
                  setIsBusy(started);
               }
         });
   }

   private void confirmTerminateRunningCompile(String operation,
                                               final Command onTerminated)
   {
      globalDisplay_.showYesNoMessage(
         MessageDialog.WARNING,
         constants_.stopRunningCompilesCaption(),
         constants_.stopPDFCompilationRunningMessage(operation),
         new Operation() {
            @Override
            public void execute()
            {
               terminateCompilePdf(onTerminated);
            }},
            false);
   }


   private void terminateCompilePdf(final Command onTerminated)
   {
      server_.terminateCompilePdf(new DelayedProgressRequestCallback<Boolean>(
                                    constants_.terminatingPDFCompilationCaption()) {
         @Override
         protected void onSuccess(Boolean wasTerminated)
         {
            if (wasTerminated)
            {
               if (onTerminated != null)
                  onTerminated.execute();
               setIsBusy(false);
            }
            else
            {
               globalDisplay_.showErrorMessage(
                    "Compile PDF",
                    constants_.unableToTerminatePDFCompilationMessage());
            }
         }
      });
   }

   private FileSystemItem targetFile_ = null;
   private final CompileOutputPaneDisplay view_;
   private final GlobalDisplay globalDisplay_;
   private final CompilePdfServerOperations server_;
   private final FileTypeRegistry fileTypeRegistry_;
   private final EventBus events_;
   private final Commands commands_;

   private boolean switchToConsoleOnSuccessfulCompile_;
   private static final OutputConstants constants_ = GWT.create(OutputConstants.class);
}
