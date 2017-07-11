/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class AddMovie{
    public static DBConnect db;
    private String title, desc, genre, error;
    private boolean checker;
    private int movieID, result;
    
    public AddMovie(String title, String desc, String genre){
        this.title = title;
        this.desc = desc;
        this.genre = genre;
    }
    
    public boolean checkTitle(){
        checker = false;
        if(!(title.isEmpty()))
            checker = true;
        return checker;
        
    }
    public boolean checkDesc(){
        checker = false;
        if(!(desc.isEmpty()))
            checker = true;
        return checker;
    }
    public boolean checkDuplicate(){
        db = db.getDBConnect();
        
        checker = false;
        String sqlCountMovie = "SELECT COUNT(*) from movie WHERE movieName = '"+title+"' ";
        result = db.getInteger(sqlCountMovie);  
        
        if(result == 0)
            checker = true;
        
        return checker;
                    
    }
    
    public boolean authenticate(){
        checker = false;       
        
        if(this.checkDuplicate() && this.checkTitle() && this.checkDesc()) 
            checker = true;
        
        return checker;
    }
    
    public void sqlAddMovie(){

        String sqlInsertMovie = "INSERT INTO `movie`(movieID, movieName, description, genre) VALUES (null, '"+title+"', '"+desc+"', '"+genre+"')";
        db.executeQuery(sqlInsertMovie);
        movieID = db.getInteger("SELECT max(movieID) from movie");
    }
    
    // GETTERS
    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getGenre() {
        return genre;
    }

    public int getMovieID() {
        return movieID;
    }   
    public int getResult() {
        this.checkDuplicate();
        return result;
    }  
}
