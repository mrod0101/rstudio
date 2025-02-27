/* UserStateAccessor.java
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
 
/* DO NOT HAND-EDIT! This file is automatically generated from the formal user state schema
 * JSON. To add a preference, add it to "user-state-schema.json", then run "generate-prefs.R" to
 * rebuild this file.
 */

package org.rstudio.studio.client.workbench.prefs.model;

import org.rstudio.core.client.js.JsObject;
import org.rstudio.studio.client.workbench.model.SessionInfo;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Accessor class for user state.
 */ 
public class UserStateAccessor extends Prefs
{
   public UserStateAccessor(SessionInfo sessionInfo, 
                            JsArray<PrefLayer> stateLayers)
   {
      super(stateLayers);
   }
   
   /**
    * A unique identifier representing the user and machine.
    */
   public PrefValue<String> contextId()
   {
      return string(
         "context_id",
         "", 
         "A unique identifier representing the user and machine.", 
         "");
   }

   /**
    * Whether we have automatically created an .Rprofile for this user.
    */
   public PrefValue<Boolean> autoCreatedProfile()
   {
      return bool(
         "auto_created_profile",
         "", 
         "Whether we have automatically created an .Rprofile for this user.", 
         false);
   }

   /**
    * The color theme to apply.
    */
   public PrefValue<Theme> theme()
   {
      return object(
         "theme",
         "", 
         "The color theme to apply.", 
         null);
   }

   public static class Theme extends JavaScriptObject
   {
      protected Theme() {} 

      public final native String getName() /*-{
         return this && this.name || "Textmate (default)";
      }-*/;

      public final native String getUrl() /*-{
         return this && this.url || "theme/default/textmate.rstheme";
      }-*/;

      public final native boolean getIsDark() /*-{
         return this && this.isDark || false;
      }-*/;

   }

   /**
    * The directory path under which to place new projects by default. Shadows a uipref.
    */
   public PrefValue<String> defaultProjectLocation()
   {
      return string(
         "default_project_location",
         "", 
         "The directory path under which to place new projects by default. Shadows a uipref.", 
         "");
   }

   /**
    * Whether to clear hidden objects along with visible objects when clearing the workspace. Set automatically to remember last action.
    */
   public PrefValue<Boolean> clearHidden()
   {
      return bool(
         "clear_hidden",
         "", 
         "Whether to clear hidden objects along with visible objects when clearing the workspace. Set automatically to remember last action.", 
         true);
   }

   /**
    * The most recently used plot export options.
    */
   public PrefValue<ExportPlotOptions> exportPlotOptions()
   {
      return object(
         "export_plot_options",
         "", 
         "The most recently used plot export options.", 
         null);
   }

   public static class ExportPlotOptions extends JavaScriptObject
   {
      protected ExportPlotOptions() {} 

      public final native int getWidth() /*-{
         return this && this.width || 550;
      }-*/;

      public final native int getHeight() /*-{
         return this && this.height || 450;
      }-*/;

      public final native String getFormat() /*-{
         return this && this.format || "PNG";
      }-*/;

      public final native boolean getKeepRatio() /*-{
         return this && this.keepRatio || false;
      }-*/;

      public final native boolean getViewAfterSave() /*-{
         return this && this.viewAfterSave || false;
      }-*/;

      public final native boolean getCopyAsMetafile() /*-{
         return this && this.copyAsMetafile || false;
      }-*/;

   }

   /**
    * The most recently used viewer export options.
    */
   public PrefValue<ExportViewerOptions> exportViewerOptions()
   {
      return object(
         "export_viewer_options",
         "", 
         "The most recently used viewer export options.", 
         null);
   }

   public static class ExportViewerOptions extends JavaScriptObject
   {
      protected ExportViewerOptions() {} 

      public final native int getWidth() /*-{
         return this && this.width || 0;
      }-*/;

      public final native int getHeight() /*-{
         return this && this.height || 0;
      }-*/;

      public final native String getFormat() /*-{
         return this && this.format || "";
      }-*/;

      public final native boolean getKeepRatio() /*-{
         return this && this.keepRatio || false;
      }-*/;

      public final native boolean getViewAfterSave() /*-{
         return this && this.viewAfterSave || false;
      }-*/;

      public final native boolean getCopyAsMetafile() /*-{
         return this && this.copyAsMetafile || false;
      }-*/;

   }

   /**
    * The most recently used options for saving a plot as a PDF.
    */
   public PrefValue<SavePlotAsPdfOptions> savePlotAsPdfOptions()
   {
      return object(
         "save_plot_as_pdf_options",
         "", 
         "The most recently used options for saving a plot as a PDF.", 
         null);
   }

   public static class SavePlotAsPdfOptions extends JavaScriptObject
   {
      protected SavePlotAsPdfOptions() {} 

      public final native int getWidth() /*-{
         return this && this.width || 0;
      }-*/;

      public final native int getHeight() /*-{
         return this && this.height || 0;
      }-*/;

      public final native boolean getPortrait() /*-{
         return this && this.portrait || false;
      }-*/;

      public final native boolean getCairoPdf() /*-{
         return this && this.cairo_pdf || false;
      }-*/;

      public final native boolean getViewAfterSave() /*-{
         return this && this.viewAfterSave || false;
      }-*/;

   }

   /**
    * Most recently used settings for compiling a notebook from an R script.
    */
   public PrefValue<CompileRNotebookPrefs> compileRNotebookPrefs()
   {
      return object(
         "compile_r_notebook_prefs",
         "", 
         "Most recently used settings for compiling a notebook from an R script.", 
         null);
   }

   public static class CompileRNotebookPrefs extends JavaScriptObject
   {
      protected CompileRNotebookPrefs() {} 

      public final native String getAuthor() /*-{
         return this && this.author || "";
      }-*/;

      public final native String getType() /*-{
         return this && this.type || "";
      }-*/;

   }

   /**
    * Most recently used settings for compiling a notebook using R Markdown.
    */
   public PrefValue<CompileRMarkdownNotebookPrefs> compileRMarkdownNotebookPrefs()
   {
      return object(
         "compile_r_markdown_notebook_prefs",
         "", 
         "Most recently used settings for compiling a notebook using R Markdown.", 
         null);
   }

   public static class CompileRMarkdownNotebookPrefs extends JavaScriptObject
   {
      protected CompileRMarkdownNotebookPrefs() {} 

      public final native String getFormat() /*-{
         return this && this.format || "html_document";
      }-*/;

   }

   /**
    * Whether to show UI for publishing content.
    */
   public PrefValue<Boolean> showPublishUi()
   {
      return bool(
         "show_publish_ui",
         "", 
         "Whether to show UI for publishing content.", 
         true);
   }

   /**
    * Whether to show UI for publishing content to RStudio Connect.
    */
   public PrefValue<Boolean> enableRsconnectPublishUi()
   {
      return bool(
         "enable_rsconnect_publish_ui",
         "", 
         "Whether to show UI for publishing content to RStudio Connect.", 
         true);
   }

   /**
    * The default (last) account used for publishing
    */
   public PrefValue<PublishAccount> publishAccount()
   {
      return object(
         "publish_account",
         "", 
         "The default (last) account used for publishing", 
         null);
   }

   public static class PublishAccount extends JavaScriptObject
   {
      protected PublishAccount() {} 

      public final native String getName() /*-{
         return this && this.name || "";
      }-*/;

      public final native String getServer() /*-{
         return this && this.server || "";
      }-*/;

   }

   /**
    * The preferred width, in pixels, of the document outline pane.
    */
   public PrefValue<Integer> documentOutlineWidth()
   {
      return integer(
         "document_outline_width",
         "", 
         "The preferred width, in pixels, of the document outline pane.", 
         110);
   }

   /**
    * How to create new connections to data sources.
    */
   public PrefValue<String> connectVia()
   {
      return enumeration(
         "connect_via",
         "", 
         "How to create new connections to data sources.", 
         new String[] {
            CONNECT_VIA_CONNECT_R_CONSOLE,
            CONNECT_VIA_CONNECT_NEW_R_SCRIPT,
            CONNECT_VIA_CONNECT_NEW_R_NOTEBOOK,
            CONNECT_VIA_CONNECT_COPY_TO_CLIPBOARD
         },
         "connect-r-console");
   }

   public final static String CONNECT_VIA_CONNECT_R_CONSOLE = "connect-r-console";
   public final static String CONNECT_VIA_CONNECT_NEW_R_SCRIPT = "connect-new-r-script";
   public final static String CONNECT_VIA_CONNECT_NEW_R_NOTEBOOK = "connect-new-r-notebook";
   public final static String CONNECT_VIA_CONNECT_COPY_TO_CLIPBOARD = "connect-copy-to-clipboard";

   /**
    * The kind of handler to invoke when errors occur.
    */
   public PrefValue<String> errorHandlerType()
   {
      return enumeration(
         "error_handler_type",
         "", 
         "The kind of handler to invoke when errors occur.", 
         new String[] {
            ERROR_HANDLER_TYPE_MESSAGE,
            ERROR_HANDLER_TYPE_TRACEBACK,
            ERROR_HANDLER_TYPE_BREAK,
            ERROR_HANDLER_TYPE_NOTEBOOK,
            ERROR_HANDLER_TYPE_CUSTOM
         },
         "traceback");
   }

   public final static String ERROR_HANDLER_TYPE_MESSAGE = "message";
   public final static String ERROR_HANDLER_TYPE_TRACEBACK = "traceback";
   public final static String ERROR_HANDLER_TYPE_BREAK = "break";
   public final static String ERROR_HANDLER_TYPE_NOTEBOOK = "notebook";
   public final static String ERROR_HANDLER_TYPE_CUSTOM = "custom";

   /**
    * Whether or not the MinGW compiler with GCC 4.9 is used.
    */
   public PrefValue<Boolean> usingMingwGcc49()
   {
      return bool(
         "using_mingw_gcc49",
         "", 
         "Whether or not the MinGW compiler with GCC 4.9 is used.", 
         false);
   }

   /**
    * Whether or not the use of Visual Mode has been confirmed.
    */
   public PrefValue<Boolean> visualModeConfirmed()
   {
      return bool(
         "visual_mode_confirmed",
         "", 
         "Whether or not the use of Visual Mode has been confirmed.", 
         false);
   }

   /**
    * The default type for new bibliographies.
    */
   public PrefValue<String> bibliographyDefaultType()
   {
      return enumeration(
         "bibliography_default_type",
         "", 
         "The default type for new bibliographies.", 
         new String[] {
            BIBLIOGRAPHY_DEFAULT_TYPE_BIB,
            BIBLIOGRAPHY_DEFAULT_TYPE_YAML,
            BIBLIOGRAPHY_DEFAULT_TYPE_JSON
         },
         "bib");
   }

   public final static String BIBLIOGRAPHY_DEFAULT_TYPE_BIB = "bib";
   public final static String BIBLIOGRAPHY_DEFAULT_TYPE_YAML = "yaml";
   public final static String BIBLIOGRAPHY_DEFAULT_TYPE_JSON = "json";

   /**
    * The default style for inserting citations.
    */
   public PrefValue<Boolean> citationDefaultInText()
   {
      return bool(
         "citation_default_in_text",
         "", 
         "The default style for inserting citations.", 
         false);
   }

   /**
    * Zotero connection type (local or web)
    */
   public PrefValue<String> zoteroConnectionType()
   {
      return enumeration(
         "zotero_connection_type",
         "Zotero connection type", 
         "Zotero connection type (local or web)", 
         new String[] {
            ZOTERO_CONNECTION_TYPE_AUTO,
            ZOTERO_CONNECTION_TYPE_NONE,
            ZOTERO_CONNECTION_TYPE_LOCAL,
            ZOTERO_CONNECTION_TYPE_WEB
         },
         "auto");
   }

   public final static String ZOTERO_CONNECTION_TYPE_AUTO = "auto";
   public final static String ZOTERO_CONNECTION_TYPE_NONE = "none";
   public final static String ZOTERO_CONNECTION_TYPE_LOCAL = "local";
   public final static String ZOTERO_CONNECTION_TYPE_WEB = "web";

   /**
    * Whether to use Better BibTeX when suggesting citation keys and writing citations to BibTeX bibliographies
    */
   public PrefValue<Boolean> zoteroUseBetterBibtex()
   {
      return bool(
         "zotero_use_better_bibtex",
         "Use Better BibTeX for citation keys and BibTeX export", 
         "Whether to use Better BibTeX when suggesting citation keys and writing citations to BibTeX bibliographies", 
         false);
   }

   /**
    * Key for making Zotero API calls
    */
   public PrefValue<String> zoteroApiKey()
   {
      return string(
         "zotero_api_key",
         "Zotero API Key", 
         "Key for making Zotero API calls", 
         "");
   }

   /**
    * Directory containing Zotero data files
    */
   public PrefValue<String> zoteroDataDir()
   {
      return string(
         "zotero_data_dir",
         "Zotero Data Directory", 
         "Directory containing Zotero data files", 
         "");
   }

   /**
    * Sync source editor to Quarto website preview navigation.
    */
   public PrefValue<Boolean> quartoWebsiteSyncEditor()
   {
      return bool(
         "quarto_website_sync_editor",
         "Quarto Website Sync Editor", 
         "Sync source editor to Quarto website preview navigation.", 
         false);
   }

   /**
    * Build Quarto editor tools (yaml.js) on the fly when requested.
    */
   public PrefValue<Boolean> quartoBuildEditorTools()
   {
      return bool(
         "quarto_build_editor_tools",
         "Build Quarto Editor Tools", 
         "Build Quarto editor tools (yaml.js) on the fly when requested.", 
         false);
   }

   public void syncPrefs(String layer, JsObject source)
   {
      if (source.hasKey("context_id"))
         contextId().setValue(layer, source.getString("context_id"));
      if (source.hasKey("auto_created_profile"))
         autoCreatedProfile().setValue(layer, source.getBool("auto_created_profile"));
      if (source.hasKey("theme"))
         theme().setValue(layer, source.getObject("theme"));
      if (source.hasKey("default_project_location"))
         defaultProjectLocation().setValue(layer, source.getString("default_project_location"));
      if (source.hasKey("clear_hidden"))
         clearHidden().setValue(layer, source.getBool("clear_hidden"));
      if (source.hasKey("export_plot_options"))
         exportPlotOptions().setValue(layer, source.getObject("export_plot_options"));
      if (source.hasKey("export_viewer_options"))
         exportViewerOptions().setValue(layer, source.getObject("export_viewer_options"));
      if (source.hasKey("save_plot_as_pdf_options"))
         savePlotAsPdfOptions().setValue(layer, source.getObject("save_plot_as_pdf_options"));
      if (source.hasKey("compile_r_notebook_prefs"))
         compileRNotebookPrefs().setValue(layer, source.getObject("compile_r_notebook_prefs"));
      if (source.hasKey("compile_r_markdown_notebook_prefs"))
         compileRMarkdownNotebookPrefs().setValue(layer, source.getObject("compile_r_markdown_notebook_prefs"));
      if (source.hasKey("show_publish_ui"))
         showPublishUi().setValue(layer, source.getBool("show_publish_ui"));
      if (source.hasKey("enable_rsconnect_publish_ui"))
         enableRsconnectPublishUi().setValue(layer, source.getBool("enable_rsconnect_publish_ui"));
      if (source.hasKey("publish_account"))
         publishAccount().setValue(layer, source.getObject("publish_account"));
      if (source.hasKey("document_outline_width"))
         documentOutlineWidth().setValue(layer, source.getInteger("document_outline_width"));
      if (source.hasKey("connect_via"))
         connectVia().setValue(layer, source.getString("connect_via"));
      if (source.hasKey("error_handler_type"))
         errorHandlerType().setValue(layer, source.getString("error_handler_type"));
      if (source.hasKey("using_mingw_gcc49"))
         usingMingwGcc49().setValue(layer, source.getBool("using_mingw_gcc49"));
      if (source.hasKey("visual_mode_confirmed"))
         visualModeConfirmed().setValue(layer, source.getBool("visual_mode_confirmed"));
      if (source.hasKey("bibliography_default_type"))
         bibliographyDefaultType().setValue(layer, source.getString("bibliography_default_type"));
      if (source.hasKey("citation_default_in_text"))
         citationDefaultInText().setValue(layer, source.getBool("citation_default_in_text"));
      if (source.hasKey("zotero_connection_type"))
         zoteroConnectionType().setValue(layer, source.getString("zotero_connection_type"));
      if (source.hasKey("zotero_use_better_bibtex"))
         zoteroUseBetterBibtex().setValue(layer, source.getBool("zotero_use_better_bibtex"));
      if (source.hasKey("zotero_api_key"))
         zoteroApiKey().setValue(layer, source.getString("zotero_api_key"));
      if (source.hasKey("zotero_data_dir"))
         zoteroDataDir().setValue(layer, source.getString("zotero_data_dir"));
      if (source.hasKey("quarto_website_sync_editor"))
         quartoWebsiteSyncEditor().setValue(layer, source.getBool("quarto_website_sync_editor"));
      if (source.hasKey("quarto_build_editor_tools"))
         quartoBuildEditorTools().setValue(layer, source.getBool("quarto_build_editor_tools"));
   }
   public List<PrefValue<?>> allPrefs()
   {
      ArrayList<PrefValue<?>> prefs = new ArrayList<PrefValue<?>>();
      prefs.add(contextId());
      prefs.add(autoCreatedProfile());
      prefs.add(theme());
      prefs.add(defaultProjectLocation());
      prefs.add(clearHidden());
      prefs.add(exportPlotOptions());
      prefs.add(exportViewerOptions());
      prefs.add(savePlotAsPdfOptions());
      prefs.add(compileRNotebookPrefs());
      prefs.add(compileRMarkdownNotebookPrefs());
      prefs.add(showPublishUi());
      prefs.add(enableRsconnectPublishUi());
      prefs.add(publishAccount());
      prefs.add(documentOutlineWidth());
      prefs.add(connectVia());
      prefs.add(errorHandlerType());
      prefs.add(usingMingwGcc49());
      prefs.add(visualModeConfirmed());
      prefs.add(bibliographyDefaultType());
      prefs.add(citationDefaultInText());
      prefs.add(zoteroConnectionType());
      prefs.add(zoteroUseBetterBibtex());
      prefs.add(zoteroApiKey());
      prefs.add(zoteroDataDir());
      prefs.add(quartoWebsiteSyncEditor());
      prefs.add(quartoBuildEditorTools());
      return prefs;
   }
   

   public int userLayer()
   {
      return LAYER_USER;
   }

   public int projectLayer()
   {
      // There's currently no project-specific state here
      return LAYER_USER;
   }

   public static final int LAYER_DEFAULT  = 0;
   public static final int LAYER_COMPUTED = 1;
   public static final int LAYER_USER     = 2;
}
