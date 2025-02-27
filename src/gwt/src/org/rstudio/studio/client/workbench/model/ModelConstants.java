/*
 * ModelConstants.java
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
package org.rstudio.studio.client.workbench.model;

public interface ModelConstants extends com.google.gwt.i18n.client.Messages {

    /**
     * Translated "Create Session".
     *
     * @return translated "Create Session"
     */
    @DefaultMessage("Create Session")
    @Key("createSessionCaption")
    String createSessionCaption();

    /**
     * Translated "Could not allocate a new session.".
     *
     * @return translated "Could not allocate a new session."
     */
    @DefaultMessage("Could not allocate a new session.")
    @Key("createSessionMessage")
    String createSessionMessage();

    /**
     * Translated "Presentation".
     *
     * @return translated "Presentation"
     */
    @DefaultMessage("Presentation")
    @Key("presentationCaption")
    String presentationCaption();

}
