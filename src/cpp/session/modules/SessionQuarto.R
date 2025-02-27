#
# SessionQuarto.R
#
# Copyright (C) 2021 by RStudio, PBC
#
# Unless you have received this program directly from RStudio pursuant
# to the terms of a commercial license agreement with RStudio, then
# this program is licensed to you under the terms of version 3 of the
# GNU Affero General Public License. This program is distributed WITHOUT
# ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
# MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
# AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
#
#

.rs.addFunction("quarto.servePort", function() {
   if (requireNamespace("quarto", quietly = TRUE)) {
      if (!is.null(quarto:::quarto$serve_ps) && quarto:::quarto$serve_ps$is_alive()) {
         if (is.numeric(quarto:::quarto$serve_port)) {
            quarto:::quarto$serve_port
         } else {
            0
         }
      } else {
         0
      }
   } else {
      0
   }
})

.rs.addFunction("quarto.renderPreview", function(port) {
   utils::download.file(paste0("http://localhost:", port, "/quarto-render/"),
                        destfile = tempfile(),
                        quiet = TRUE,
                        cacheOK = FALSE)
})
