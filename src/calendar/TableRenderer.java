/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mico
 */
public class TableRenderer extends DefaultTableCellRenderer
{ 
    TableCellComponent tableComponent;
    
    public TableRenderer() {
        tableComponent = new TableCellComponent();
    }
    
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
        Schedule e = (Schedule)value;
        
        tableComponent.updateData(e, selected, table);

        if(column == 0){
            setBackground(Color.CYAN);
            setHorizontalAlignment(JLabel.CENTER);
        }
        else 
            setBackground(Color.WHITE);
        
         
        setBorder(null);
        setForeground(Color.black);
        
        return tableComponent;  
    }
   
        
}
