/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UltimateDesignChallenge;

import javax.swing.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Angel
 */
public class TableEditor extends AbstractCellEditor implements TableCellEditor {
    
    private ArrayList<JPanel> panels;
    private ArrayList<Integer> rows;
    private int row;
    private int column;
    
    public TableEditor(ArrayList<JPanel> panels, ArrayList<Integer> rows) {
        this.panels = panels;
        this.rows = rows;
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.row = row;
        this.column = column;
        
        for (int i = 0; i < panels.size(); i++) {
            if(rows.get(i) == row && column == 1)
            return panels.get(i);
        }
        
        return (Component) value;
  }
  

    @Override
    public Object getCellEditorValue() {
          for (int i = 0; i < panels.size(); i++) {
            if(rows.get(i) == row && column == 1)
            return panels.get(i);
        }
         return null;
    }
}
