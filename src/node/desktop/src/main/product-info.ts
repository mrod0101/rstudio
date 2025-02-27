/*
 * product-info.ts
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

export interface ProductInfo {
  RSTUDIO_VERSION: string;
  RSTUDIO_BUILD_DATE: string;
  RSTUDIO_COPYRIGHT_YEAR: string;
  RSTUDIO_VERSION_PATCH: number;
  RSTUDIO_R_MAJOR_VERSION_REQUIRED: number;
  RSTUDIO_R_MINOR_VERSION_REQUIRED: number;
  RSTUDIO_R_PATCH_VERSION_REQUIRED: number;
  RSTUDIO_PACKAGE_OS: string;
  RSTUDIO_GIT_COMMIT: string;
  RSTUDIO_RELEASE_NAME: string;
}

export function productInfo(): ProductInfo {
  // TODO: probably need to generate this via cmake?
  return {
    RSTUDIO_VERSION: '99.9.9',
    RSTUDIO_BUILD_DATE: '2021-07-06',
    RSTUDIO_COPYRIGHT_YEAR: '2021',
    RSTUDIO_VERSION_PATCH: 9,
    RSTUDIO_R_MAJOR_VERSION_REQUIRED: 3,
    RSTUDIO_R_MINOR_VERSION_REQUIRED: 0,
    RSTUDIO_R_PATCH_VERSION_REQUIRED: 1,
    RSTUDIO_PACKAGE_OS: 'Unknown OS',
    RSTUDIO_GIT_COMMIT: '6a2652d1273439fa3615c8608f38591016cd490b',
    RSTUDIO_RELEASE_NAME: 'Prairie Trillium',
  };
}
