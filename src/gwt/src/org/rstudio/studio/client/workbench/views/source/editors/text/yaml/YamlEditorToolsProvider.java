/*
 * YamlEditorToolsProvider.java
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

package org.rstudio.studio.client.workbench.views.source.editors.text.yaml;

import org.rstudio.core.client.CommandWithArg;

import elemental2.core.JsObject;

public interface YamlEditorToolsProvider
{ 
   boolean isActive(String path, String extendedType);  
   void getCompletions(YamlEditorContext context, CommandWithArg<JsObject> results);
   void getLint(YamlEditorContext context, CommandWithArg<JsObject> results);
}

