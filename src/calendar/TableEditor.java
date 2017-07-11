/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Mico
 */
public class TableEditor  extends AbstractCellEditor implements TableCellEditor {

    TableCellComponent tableComponent;
    
    public TableEditor() {

        tableComponent = new TableCellComponent();
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        
        Schedule e = (Schedule)value;
        tableComponent.updateData(e, true, table);
    
        return tableComponent;
  }
  

    @Override
    public Object getCellEditorValue() {
         return null;
    }
}
