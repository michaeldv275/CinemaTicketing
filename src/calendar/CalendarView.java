/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mico
 */
public class CalendarView{
       /**** Swing Components ****/
    private JLabel monthLabel, yearLabel;
    private JButton btnPrev, btnNext,
                    btnAdd;
    private JFrame frmMain;
    private Container pane;
    private JScrollPane scrollCalendarTable;
    private JPanel calendarPanel;
    
    /**** Calendar Table Components ***/
    private CalendarModel calendarModel;  //different from CalendarModel class
    private JTable calendarTable;
    
    /**** Event Panel Components ***/
    private ArrayList<JPanel> eventPanels = new ArrayList();
    private ArrayList<Integer> rows = new ArrayList();
    private JPanel eventPanel = new JPanel();
    private JTextField textField = new JTextField();
    
    /**** List of Schedules ****/
    private ArrayList<Schedule> schedList = new ArrayList();
    
    
    public CalendarView()
    {
//        schedList.add(new Schedule(1, 1, 12, 1, 2015));
//        schedList.add(new Schedule(1, 2, 12, 1, 2015));
        
        frmMain = new JFrame ("Calendar Application");
        frmMain.setSize(660, 750);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monthLabel = new JLabel ("January");
        yearLabel = new JLabel ();
        btnPrev = new JButton ("<<");
        btnNext = new JButton (">>");
        btnAdd = new JButton ("Add Movie");
        calendarTable = new JTable();
        calendarModel = new CalendarModel(schedList);

        scrollCalendarTable = new JScrollPane(calendarTable);
        calendarPanel = new JPanel(null);

        calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));

        pane.add(calendarPanel);
        calendarPanel.add(monthLabel);
        calendarPanel.add(yearLabel);
        calendarPanel.add(btnAdd);
        calendarPanel.add(btnPrev);
        calendarPanel.add(btnNext);
        calendarPanel.add(scrollCalendarTable);

        calendarPanel.setBounds(0, 0, 640, 670);
        monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 200, 50);
        yearLabel.setBounds(350, 50, 100, 50);
        btnAdd.setBounds(20, 610, 100, 40);
        btnPrev.setBounds(20, 50, 100, 50);
        btnNext.setBounds(520, 50, 100, 50);
        scrollCalendarTable.setBounds(20, 100, 600, 500);

        frmMain.setResizable(false);
        frmMain.setVisible(true);

        calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

        calendarTable.getTableHeader().setResizingAllowed(false);
        calendarTable.getTableHeader().setReorderingAllowed(false);
        calendarTable.setColumnSelectionAllowed(true);
        calendarTable.setRowSelectionAllowed(true);
        calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        calendarTable.setRowHeight(76);
    }
    
    /* SETTERS */
    public JPanel setPanel(String name, String type, int row){  //remove String status
        eventPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        eventPanel.setBorder(BorderFactory.createEtchedBorder());
        textField.setPreferredSize(new Dimension(350, 25));
        
//        switch(type){
//            case "info": eventPanel.add(this.setText(name));
//                         eventPanel.setBackground(Color.CYAN);
//                         break;
//            case "meeting": textField.setPreferredSize(new Dimension(200, 25));
//                            eventPanel.setBackground(Color.YELLOW);
//                            eventPanel.add(this.setText(name));
//                            eventPanel.add(m1);
//                            eventPanel.add(m2);
//                            break;
//            case "task":    if(status == "not done"){
//                                eventPanel.add(this.setText(name));
//                                eventPanel.add(t1);
//                                t1.setText("Complete");
//                                t1.setBackground(Color.GREEN);
//                                eventPanel.setBackground(Color.RED);
//                            }
//                            else if(status == "done"){
//                                eventPanel.add(this.setText(name));
//                                eventPanel.add(t1);
//                                t1.setText("Undo");
//                                t1.setBackground(Color.RED);
//                                eventPanel.setBackground(Color.GREEN);
//                            }
//                            break;
//        }
        
        eventPanels.add(eventPanel);
        rows.add(row);
        return eventPanel;
    }

    public ArrayList<JPanel> getEventPanels() {
        return eventPanels;
    }
   public int getRowFromIndex(int i) {
        return rows.get(i);
    }
   
      public int getSize(){
        return rows.size();
    }
    
    public void clearEventPanels() {
        eventPanels.clear();
    }
    public void clearRows() {
        rows.clear();
    }
    public ArrayList<Integer> getRows() {
        return rows;
    }
    
    public void updateList(ArrayList<Schedule> schedList) {
        this.schedList = schedList;
    }
    
    public JTextField setText(String name){
        textField.setBorder(BorderFactory.createEtchedBorder());
        textField.setEditable(false);
        textField.setText(name);
        return textField;
    }
    
    public void setModel(){
        calendarTable.setModel(calendarModel);
    }
    public void setCalendarTable(int nod){
        calendarModel = new CalendarModel(schedList);
        calendarTable.setModel(calendarModel);
        calendarTable.getColumnModel().getColumn(0).setMaxWidth(40);
    }
    public void setRendererAndEditor(ArrayList<JPanel> eventPanels, ArrayList<Integer> rows){
        calendarTable.setDefaultRenderer(calendarTable.getColumnClass(1), new TableRenderer());
        calendarTable.setDefaultEditor(calendarTable.getColumnClass(1), new TableEditor());
    }
    
    public void setValueAt(Object obj, int row, int col){
        calendarModel.setValueAt(obj, row, col);
    }

    public void setBtnPrevEnable(boolean enable) {    
        btnPrev.setEnabled(enable);
    }
    
    public void setBtnNextEnable(boolean enable) {    
        btnNext.setEnabled(enable);
    }  
    
    public void setMonthLabel(String month){
        monthLabel.setText(month);
    }
    
    public void setYearLabel(String year){
        yearLabel.setText(year);
    }

    public void setBtnAdd(ActionListener a) {
        btnAdd.addActionListener(a);
    }

    public void setBtnPrev(ActionListener a) {
        btnPrev.addActionListener(a);
    }

    public void setBtnNext(ActionListener a) {
        btnNext.addActionListener(a);
    }


}
