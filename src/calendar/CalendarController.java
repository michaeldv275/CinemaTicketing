/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.*;
import udc.DBConnect;

/**
 *
 * @author Mico
 */
public class CalendarController{
    private CalendarView calendarView;
    private int month, year, nod, som, i, theaterID;
    private GregorianCalendar cal = new GregorianCalendar();
    private static DBConnect db;
    ArrayList<Schedule> schedList = new ArrayList();
    
    public CalendarController(CalendarView calendarView, int theaterID){
        this.calendarView = calendarView;
        month = cal.get(GregorianCalendar.MONTH);
        year = cal.get(GregorianCalendar.YEAR);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        db = db.getDBConnect();
        
        this.theaterID = theaterID;
        setController();
           
        refreshCalendar();
    }
    
    public void setController(){
        calendarView.setBtnPrev(new btnPrev_Action());
        calendarView.setBtnNext(new btnNext_Action());
        calendarView.setBtnAdd(new btnAdd_Action());
    }
   
    public void update() {
        int actualMonth = month + 1;
        String sqlInsertUser = "SELECT * FROM movieshowing WHERE month = '"+actualMonth+"' and year = '"+year+"' and theaterID = '"+theaterID+"'";
        
        try {
        Statement st = (Statement) db.getCon().createStatement();
        ResultSet rs = st.executeQuery(sqlInsertUser);
        
        while(rs.next()) {
            schedList.set(rs.getInt("day") - 1, new Schedule(rs.getInt("theaterID"), rs.getInt("movieID"), rs.getInt("month"), rs.getInt("day"), rs.getInt("year")));
        }
        } catch(SQLException ex) {
            
        }
    }
    
    public void refreshCalendar()
    {
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
      
        calendarView.setBtnPrevEnable(true);
        calendarView.setBtnNextEnable(true);
        calendarView.updateList(schedList);
        
        if (month == 0 && year <= year-10)
            calendarView.setBtnPrevEnable(false);
        if (month == 11 && year >= year+100)
            calendarView.setBtnNextEnable(false);

        calendarView.setMonthLabel(months[month] + " " + year);
        
        cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        
        schedList.clear();
        for(i = 0; i < nod; i++) {
            schedList.add(i, new Schedule(theaterID, 0, month + 1, i, year));
        }
        update();
        calendarView.updateList(schedList);
        
        // set cells to nod
        calendarView.setCalendarTable(nod);
        
        // remove contents
        for (i = 0; i < nod; i++) {
            calendarView.setValueAt(null, i, 0);
            calendarView.setValueAt(null, i, 1);
        }
        // set label for days
//        for (int day = 1; day <= nod; day++) {
//            int row = day-1;
//            for (int ctr = 0; ctr < calendarModel.getSize(); ctr++) { //searches for the events for this month and year
//                
//                    
//                if (calendarModel.getChecker(ctr, month, day, year)) {
//                    System.out.println(calendarModel.getChecker(ctr, month, day, year));
//                    String name = calendarModel.getTheaterName(ctr);
//                    String type = calendarModel.getMovieName(ctr);
////                    String status = calendarModel.getStatusFromIndex(ctr);
//                    
//                    calendarView.setValueAt(calendarView.setPanel(name, type, row), row, 1); 
//                    System.out.println(row);
//                }  
//                
//            }
//            calendarView.setValueAt(day, row, 0);
//            
//        }
        
        calendarView.setRendererAndEditor(calendarView.getEventPanels(), calendarView.getRows());
       
    }
    

    private class btnPrev_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if (month == 0){
                month = 11;
                year -= 1;
            }
            else {
                month -= 1;
            }
            calendarView.clearEventPanels();
            calendarView.clearRows();
            refreshCalendar();
        }
    }
    private class btnNext_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (month == 11) {
                month = 0;
                year += 1;
            }
            else {
                month += 1;
            }
            calendarView.clearRows();
            calendarView.clearEventPanels();
            refreshCalendar();
        }
    }
    private class btnAdd_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddMovieToTheaterController addMovie = new AddMovieToTheaterController(theaterID);
            refreshCalendar();
            
        }
        
    }

   
}
