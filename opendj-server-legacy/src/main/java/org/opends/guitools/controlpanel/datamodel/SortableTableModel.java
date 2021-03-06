/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2008-2010 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */

package org.opends.guitools.controlpanel.datamodel;


import static com.forgerock.opendj.cli.Utils.wrapText;

import javax.swing.table.AbstractTableModel;

import org.opends.guitools.controlpanel.ui.ColorAndFontConstants;
import org.opends.guitools.controlpanel.util.Utilities;
import org.forgerock.i18n.LocalizableMessage;
import org.opends.server.util.ServerConstants;

/** A generic interface that must implement table models that are sortable. */
public abstract class SortableTableModel extends AbstractTableModel
{
  private static final long serialVersionUID = 123129879083L;

  /**
   * Returns whether the sort is ascending or descending.
   * @return <CODE>true</CODE> if the sort is ascending and <CODE>false</CODE>
   * otherwise.
   */
  public abstract boolean isSortAscending();

  /**
   * Sets whether to sort ascending of descending.
   * @param sortAscending whether to sort ascending or descending.
   */
  public abstract void setSortAscending(boolean sortAscending);

  /**
   * Returns the column index used to sort.
   * @return the column index used to sort.
   */
  public abstract int getSortColumn();

  /**
   * Sets the column index used to sort.
   * @param sortColumn column index used to sort..
   */
  public abstract void setSortColumn(int sortColumn);

  /**
   * Updates the table model contents and sorts its contents depending on the
   * sort options set by the user.
   */
  public abstract void forceResort();


  /**
   * Returns the header wrapped with the default line width.
   * @param msg the header message value (with no HTML formatting).
   * @return the header wrapped with the default line width.
   */
  protected String getHeader(LocalizableMessage msg)
  {
    return getHeader(msg, 15);
  }

  /**
   * Returns the header wrapped with a certain line width.
   * @param msg the header message value (with no HTML formatting).
   * @param wrap the maximum line width before wrapping.
   * @return the header wrapped with the specified line width.
   */
  protected String getHeader(LocalizableMessage msg, int wrap)
  {
    String text = msg.toString();
    String wrappedText = wrapText(text, wrap);
    wrappedText = wrappedText.replaceAll(ServerConstants.EOL, "<br>");
    return "<html>"+Utilities.applyFont(wrappedText,
        ColorAndFontConstants.headerFont);
  }
}
