/*
 * main-window.js
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

const { BrowserWindow, session } = require('electron');
const path = require('path');
const { DesktopCallback } = require('./desktop-callback');
const MenuCallback = require('./menu-callback');

// corresponds to DesktopMainWindow.cpp/hpp
module.exports = class MainWindow {
  constructor(url, isRemoteDesktop) {
    this.url = url;
    this.isRemoteDesktop = isRemoteDesktop;
    this.sessionLauncher_ = null;
    this.sessionProcess_ = null;
    this.window = null;
    this.desktopCallback = new DesktopCallback(this, this, isRemoteDesktop);
    this.menuCallback = new MenuCallback(this);
    this.quitConfirmed = false;
    this.workbenchInitialized_ = false;
  }

  set sessionLauncher(value) {
    this.sessionLauncher_ = value;
  }

  get sessionLauncher() {
    return this.sessionLauncher_;
  }

  set sessionProcess(value) {
    this.sessionProcess_ = value;
  }

  get sessionProcess() {
    return this.sessionProcess_;
  }

  load(url) {

    // show the window
    this.window = new BrowserWindow({
      width: 1400,
      height: 1024,
      // https://github.com/electron/electron/blob/master/docs/faq.md#the-font-looks-blurry-what-is-this-and-what-can-i-do
      backgroundColor: '#fff', 
      webPreferences: {
        enableRemoteModule: false,
        nodeIntegration: false,
        contextIsolation: true,
        preload: path.join(__dirname, '../renderer/preload.js'),
      },
    });

    // pass along the shared secret with every request
    const filter = {
      urls: [`${url}/*`]
    };
    session.defaultSession.webRequest.onBeforeSendHeaders(filter, (details, callback) => {
      details.requestHeaders['X-Shared-Secret'] = process.env.RS_SHARED_SECRET;
      callback({ requestHeaders: details.requestHeaders});
    });

    this.window.loadURL(url);
  }

  quit() {
    // RCommandEvaluator::setMainWindow(nullptr);
    this.quitConfirmed = true;
    this.window.close();
  }

  invokeCommand(cmdId) {
    this.window.webContents.executeJavaScript(`window.desktopHooks.invokeCommand("${cmdId}")`)
      .catch(() => {
        console.error(`Error: failed to execute desktopHooks.invokeCommand("${cmdId}")`);
      });
  }

  onWorkbenchInitialized() {
    this.workbenchInitialized_ = true;
    this.window.webContents.executeJavaScript('window.desktopHooks.getActiveProjectDir()')
      .then(projectDir => {
        if (projectDir.length > 0) {
          this.window.setTitle(`${projectDir} - RStudio`);
        } else {
          this.window.setTitle('RStudio');
        }
      })
      .catch(() => {
        console.error('Error: failed to execute desktopHooks.getActiveProjectDir()');
      });
  }

  collectPendingQuitRequest() {
    return this.desktopCallback.collectPendingQuitRequest();
  }

  get workbenchInitialized() {
    return this.workbenchInitialized_;
  }
};
