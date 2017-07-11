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
public class AddTheater {
    public static DBConnect db;
    private String theaterName;
    private int numOfFloors, price, theaterID, result;
    private boolean checker;
    
    public AddTheater(String theaterName, int numOfFloors, int price){
        this.theaterName = theaterName;
        this.numOfFloors = numOfFloors;
        this.price = price;
        db = db.getDBConnect();        
    }
    
    public void sqlAdd(){
        String sqlInsertTheater = "INSERT INTO `theater`(theaterID, theaterName, numOfFloors, price) VALUES (null, '"+theaterName+"', '"+numOfFloors+"', '"+price+"')";
        db.executeQuery(sqlInsertTheater);
        theaterID = db.getInteger("SELECT max(theaterID) from theater");
    }
    
    public boolean checkName(){
        checker = false;
        if(!(theaterName.isEmpty()))
            checker = true;
        return checker;
        
    }
    
    public boolean checkFloor(){
        checker = false;
        if(numOfFloors > 0)
            checker = true;
        return checker;
    }
    
    public boolean checkPrice(){
        checker = false;
        if(price > 0)
            checker = true;
        return checker;
    }
    
    public boolean checkDuplicate(){      
        checker = false;
        String sqlCountTheater = "SELECT COUNT(*) from theater WHERE theaterName = '"+theaterName+"' ";
        result = db.getInteger(sqlCountTheater);  
        
        if(result == 0)
            checker = true;
        
        return checker;
                    
    }
    
    public boolean authenticate(){
        checker = false;       
        
        if(this.checkDuplicate() && this.checkName() && this.checkFloor() && this.checkPrice()) 
            checker = true;
        
        return checker;
    }
    
    public int getTheaterID() {
        return theaterID;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public int getPrice() {
        return price;
    }

    public int getResult() {
        return result;
    }


}
