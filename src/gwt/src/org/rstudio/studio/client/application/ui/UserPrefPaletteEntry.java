/*
 * UserPrefPaletteEntry.java
 *
 * Copyright (C) 2020 by RStudio, PBC
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
package org.rstudio.studio.client.application.ui;

import org.rstudio.studio.client.workbench.prefs.model.UserPrefDefinition;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class UserPrefPaletteEntry extends CommandPaletteEntry
{
   public UserPrefPaletteEntry(String id, UserPrefDefinition pref)
   {
      super();
      pref_ = pref;
      id_ = id;
      initialize();
   }

   @Override
   public String getLabel()
   {
      return pref_.getTitle();
   }

   @Override
   public void invoke()
   {
      
   }

   @Override
   public String getId()
   {
      return id_;
   }

   @Override
   public String getContext()
   {
      return new String("Settings");
   }

   @Override
   public boolean enabled()
   {
      return true;
   }

   @Override
   public Widget getInvoker()
   {
      Label label = new Label();
      label.setText("NYI");
      return label;
   }

   private final UserPrefDefinition pref_;
   private final String id_;
}