/*
 * ClipboardActionEvent.java
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
package org.rstudio.studio.client.application.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ClipboardActionEvent extends GwtEvent<ClipboardActionEvent.Handler>
{
   public static class Data extends JavaScriptObject
   {
      public enum Type
      {
         SET
      }
      
      protected Data()
      {
      }
      
      public final Type getType()
      {
         String type = getTypeImpl();
         return Type.valueOf(type.toUpperCase());
      }

      public final native String getTypeImpl() /*-{ return this["type"] || ""; }-*/;
      public final native String getText()     /*-{ return this["text"] || ""; }-*/;
   }

   public ClipboardActionEvent(Data data)
   {
      data_ = data;
   }

   public Data getData()
   {
      return data_;
   }

   private final Data data_;

   // Boilerplate ----

   public interface Handler extends EventHandler
   {
      void onClipboardAction(ClipboardActionEvent event);
   }

   @Override
   public Type<Handler> getAssociatedType()
   {
      return TYPE;
   }

   @Override
   protected void dispatch(Handler handler)
   {
      handler.onClipboardAction(this);
   }

   public static final Type<Handler> TYPE = new Type<Handler>();
}

