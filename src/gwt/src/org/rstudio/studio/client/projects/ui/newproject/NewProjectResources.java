/*
 * NewProjectResources.java
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
package org.rstudio.studio.client.projects.ui.newproject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;


public interface NewProjectResources extends ClientBundle
{
   NewProjectResources INSTANCE = GWT.create(NewProjectResources.class);
   @Source("newProjectDirectoryIcon_2x.png")
   ImageResource newProjectDirectoryIcon2x();

   @Source("newProjectDirectoryIconLarge_2x.png")
   ImageResource newProjectDirectoryIconLarge2x();

   @Source("packageIcon_2x.png")
   ImageResource packageIcon2x();

   @Source("packageIconLarge_2x.png")
   ImageResource packageIconLarge2x();

   @Source("shinyAppIcon_2x.png")
   ImageResource shinyAppIcon2x();

   @Source("shinyAppIconLarge_2x.png")
   ImageResource shinyAppIconLarge2x();

   @Source("existingDirectoryIcon_2x.png")
   ImageResource existingDirectoryIcon2x();

   @Source("existingDirectoryIconLarge_2x.png")
   ImageResource existingDirectoryIconLarge2x();

   @Source("projectFromRepositoryIcon_2x.png")
   ImageResource projectFromRepositoryIcon2x();

   @Source("projectFromRepositoryIconLarge_2x.png")
   ImageResource projectFromRepositoryIconLarge2x();

   @Source("gitIcon_2x.png")
   ImageResource gitIcon2x();

   @Source("gitIconLarge_2x.png")
   ImageResource gitIconLarge2x();

   @Source("svnIcon_2x.png")
   ImageResource svnIcon2x();

   @Source("svnIconLarge_2x.png")
   ImageResource svnIconLarge2x();
   
   @Source("quartoIcon_2x.png")
   ImageResource quartoIcon2x();

   @Source("quartoIconLarge_2x.png")
   ImageResource quartoIconLarge2x();
   
   @Source("quartoBookIcon_2x.png")
   ImageResource quartoBookIcon2x();

   @Source("quartoBookIconLarge_2x.png")
   ImageResource quartoBookIconLarge2x();
   
   @Source("quartoWebsiteIcon_2x.png")
   ImageResource quartoWebsiteIcon2x();

   @Source("quartoWebsiteIconLarge_2x.png")
   ImageResource quartoWebsiteIconLarge2x();
   
   @Source("quartoBlogIcon_2x.png")
   ImageResource quartoBlogIcon2x();

   @Source("quartoBlogIconLarge_2x.png")
   ImageResource quartoBlogIconLarge2x();

   @Source("plumberAppIcon_2x.png")
   ImageResource plumberAppIcon2x();

   interface Styles extends CssResource
   {
      String wizardWidget();
      String wizardMainColumn();
      String wizardTextEntryLabel();
      String wizardSpacer();
      String vcsSelectorDesktop();
      String wizardCheckbox();
      String vcsNotInstalledWidget();
      String vcsHelpLink();
      String newProjectDirectoryName();
      String codeFilesListButton();
      String codeFilesListBox();
      String invalidPkgName();
      String quartoProjectTypeSelect();
      String quartoEngineSelect();
      String quartoVenvPackages();
   }

   @Source("NewProjectWizard.css")
   Styles styles();
}
