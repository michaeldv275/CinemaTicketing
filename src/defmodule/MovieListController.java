/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class MovieListController extends MovieListView {
    private static DBConnect db;
    public MovieListController() {
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
        setBtnAddMovie(new btnAddMovie_Action());
        setBtnDisplay(new btnDisplay_Action());
    }
    
    private class btnDisplay_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(!getSelectedMovie().isEmpty()){
                MovieList list = new MovieList(getSelectedMovie());
                displayImage(list.getMovieID(), getSelectedMovie(), list.getDesc(), list.getGenre());
            }
        }
    }
    private class btnAddMovie_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           AddMovieController addMovie = new AddMovieController();
           
        }
    }
}
