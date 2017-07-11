/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.sql.*;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class MovieList {
    public static DBConnect db;
    private int movieID;
    private  String title, desc, genre;
    
    public MovieList(String title){
       this.title = title;
       sqlGetMovie();
    }

    public void sqlGetMovie(){
        db = db.getDBConnect();

        String sqlGetMovie = "SELECT * from movie WHERE movieName = '"+title+"' ";

        movieID = db.getInteger(sqlGetMovie);
        desc = db.getResult(sqlGetMovie, "description");
        genre = db.getResult(sqlGetMovie, "genre");
    }

    public int getMovieID() {
        return movieID;
    }

    public String getDesc() {
        return desc;
    }

    public String getGenre() {
        return genre;
    }
}
