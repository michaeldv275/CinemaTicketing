/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import calendar.CalendarController;
import calendar.CalendarView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class MovieShowingController extends MovieShowingView {
    public static DBConnect db;
    public MovieShowingController(){
        setBtns();
    }
    
    public void setBtns () {
        db = db.getDBConnect();
        try {
            Statement st = db.getCon().createStatement();
            String sqlGetTheaters = "SELECT * from theater";
            ResultSet rs = st.executeQuery(sqlGetTheaters);
            while(rs.next()){
               setTheater(rs.getString("theaterName"));
            }
        } catch (SQLException ex) {
        }       

        setBtnSchedule(new btnSchedule_Action());
    }
    
    public int getTheaterID(){
        String theaterName = getBoxTheater();
        System.out.println(theaterName);
        int theaterID = 0;

        String sqlGetTheaterID = "SELECT theaterID from theater WHERE theaterName = '"+theaterName+"' ";
        theaterID = db.getInteger(sqlGetTheaterID);
        System.out.println(theaterID);
        
        return theaterID;
    }

    private class btnSchedule_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            CalendarController mycontroller = new CalendarController(new CalendarView(), getTheaterID());
        }
    }
}
