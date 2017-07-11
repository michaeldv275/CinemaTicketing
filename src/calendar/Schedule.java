/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Calendar;
import udc.DBConnect;

/**
 *
 * @author Mico
 */
public class Schedule {
    public static DBConnect db;
    private int month, day, year, theaterID, movieID, schedID;

    public Schedule(int theaterID, int movieID, int month, int day, int year){
        this.theaterID = theaterID;
        this.movieID = movieID;
        this.month = month;
        this.day = day;
        this.year = year;
        db = db.getDBConnect();
    }
    
    public void sqlAddSched(){
        String sqlInsertUser = "INSERT INTO `movieshowing`(schedID, movieID, theaterID, month, day, year) VALUES(null, '"+movieID+"', '"+theaterID+"', '"+month+"', '"+day+"', '"+year+"')";
        db.executeQuery(sqlInsertUser);
    }
    
    public int getTheaterID() {
        return theaterID;
    }

    public int getMovieID() {
        return movieID;
    }

}
