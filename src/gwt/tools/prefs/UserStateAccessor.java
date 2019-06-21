/* UserStateAccessor.java
 *
 * Copyright (C) 2009-19 by RStudio, Inc.
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
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsArray;
import org.rstudio.core.client.JsArrayUtil;


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
   
%STATE%   

   public int userLayer()
   {
      return LAYER_USER;
   }

   public int projectLayer()
   {
      // There's currently no project-specific state here
      return LAYER_USER;
   }

   public static final int LAYER_DEFAULT = 0;
   public static final int LAYER_USER    = 1;
}
