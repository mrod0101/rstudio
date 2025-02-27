/*
 * PanmirrorUIChunks.java
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
package org.rstudio.studio.client.panmirror.ui;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsType;

@JsType
public class PanmirrorUIChunks
{
   public CreateChunkEditor createChunkEditor;
   public SetChunksExpanded setChunksExpanded;

   @JsFunction
   public interface CreateChunkEditor
   {
      PanmirrorUIChunkEditor create(String type, Element element, int position, JsArrayString classes,
                                    PanmirrorUIChunkCallbacks callbacks);
   }

   @JsFunction
   public interface SetChunksExpanded
   {
      void setExpanded(boolean expanded);
   }
}
