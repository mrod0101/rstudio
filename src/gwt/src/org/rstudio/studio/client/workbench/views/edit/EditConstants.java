/*
 * EditConstants.java
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
package org.rstudio.studio.client.workbench.views.edit;

public interface EditConstants extends com.google.gwt.i18n.client.Messages {


    /**
     * Translated "Saving...".
     *
     * @return translated "Saving..."
     */
    @DefaultMessage("Saving...")
    @Key("savingProgressLabel")
    String savingProgressLabel();

    /**
     * Translated "Cancelling...".
     *
     * @return translated "Cancelling..."
     */
    @DefaultMessage("Cancelling...")
    @Key("cancellingProgressLabel")
    String cancellingProgressLabel();

}
