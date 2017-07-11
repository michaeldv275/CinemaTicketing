/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmodule;

import calendar.CalendarController;
import calendar.CalendarView;
import defmodule.AddMovieController;
import defmodule.AddMovieController;
import defmodule.MovieList;
import defmodule.MovieList;
import defmodule.MovieShowingController;
import static defmodule.MovieShowingController.db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import udc.DBConnect;

/**
 *
 * @author Mico
 */
public class SelectionController extends SelectionView {

    private static DBConnect db;
    public SelectionController() {
        setListView();
        setBtns();
        
    }
    
    public void setListView(){
        db = db.getDBConnect();
        clearList();
        try {
            Statement st = db.getCon().createStatement();
            String sqlGetMovies = "SELECT * from movie";
            ResultSet rs = st.executeQuery(sqlGetMovies);
            while(rs.next()){
                addList(rs.getString("movieName"));
            }
        } catch (SQLException ex) {
        }
    }

    
    public void setBtns () {
//        setBtnAddMovie(new btnAddMovie_Action());
        setBtnDisplay(new btnDisplay_Action());
        
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
    
    private class btnDisplay_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(!getSelectedMovie().isEmpty()){
                MovieList list = new MovieList(getSelectedMovie());
                displayImage(list.getMovieID(), getSelectedMovie(), list.getDesc(), list.getGenre());
            }
        }
    }
    
//    private class btnAddMovie_Action implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//           AddMovieController addMovie = new AddMovieController();
//           
//        }
//    }
    
    public int getTheaterID(){
        String theaterName = getBoxTheater();
        System.out.println(theaterName);
        int theaterID = 0;

        String sqlGetTheaterID = "SELECT theaterID from theater WHERE theaterName = '"+theaterName+"' ";
        theaterID = db.getInteger(sqlGetTheaterID);
        System.out.println(theaterID);
        
        return theaterID;
    }
    
//    public int getMovieID(){
//        
//    }

    private class btnSchedule_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ReserveSeatsController controller = new ReserveSeatsController(getTheaterID());  //kailangan rin bang  ipasa yung getMovieID?
        }
    }
}
