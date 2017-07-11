/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UltimateDesignChallenge;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Angel
 */
public class TableRenderer extends DefaultTableCellRenderer
{   
    private ArrayList<JPanel> panels;
    private ArrayList<Integer> rows;
    
    public TableRenderer(ArrayList<JPanel> panels, ArrayList<Integer> rows) {
        this.panels = panels;
        this.rows = rows;
    }
    
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        if(column == 0){
            setBackground(Color.CYAN);
            setHorizontalAlignment(JLabel.CENTER);
        }
        else 
            setBackground(Color.WHITE);
        
       
        for (int i = 0; i < panels.size(); i++) {
            if(rows.get(i) == row && column == 1)
            return panels.get(i);
        }   
         
        setBorder(null);
        setForeground(Color.black);
        
        return this;  
    }
   
        
}

