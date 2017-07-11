/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmodule;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author Belle
 */
public class ImageListCellRenderer implements ListCellRenderer {

  public Component getListCellRendererComponent(JList jlist, Object value, int cellIndex, boolean isSelected, boolean cellHasFocus) {
    if (value instanceof JPanel)
    {
      Component component = (Component) value;
      component.setForeground (Color.white);
      component.setBackground (isSelected ? UIManager.getColor("Table.focusCellForeground") : Color.white);
      return component;
    }
    else
        return new JLabel("");
    
  }
}    

