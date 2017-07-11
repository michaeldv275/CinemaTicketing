/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import defmodule.AddSeatsController;
import defmodule.DefModuleView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import udc.DBConnect;
/**
 *
 * @author Mico
 */
public class CalendarModel extends AbstractTableModel{  //different from calendarModel (its a defaultTableModel in swing.Table) in CalendarView class

    private ArrayList<Schedule> schedList = new ArrayList();
     
    public CalendarModel(ArrayList feeds) {
        this.schedList = feeds;
    }
    
    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 0) {
            return Integer.class;
        }
        else
            return Schedule.class;
    }
    public int getColumnCount() { return 2; }
    public String getColumnName(int columnIndex) { 
        if(columnIndex == 0) {
            return "Day";
        }
        else
            return "Movie Name";
    }
    public int getRowCount() { return (schedList == null) ? 0 : schedList.size(); }
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return rowIndex+1;
        else
            return (schedList == null) ? null : schedList.get(rowIndex); }
    public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }

    
}
