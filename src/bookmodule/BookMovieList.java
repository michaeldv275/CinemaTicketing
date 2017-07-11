/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmodule;

import udc.DBConnect;

/**
 *
 * @author Mico
 */
public class BookMovieList {
    public static DBConnect db;
    private int movieID;
    private  String title, desc, genre;
    
    public BookMovieList(String title){
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
