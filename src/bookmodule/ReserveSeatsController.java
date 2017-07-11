package bookmodule;

import defmodule.DefModuleView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import udc.DBConnect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dorotheabachini
 */
public class ReserveSeatsController extends ReserveSeatsView{
    private int theaterID, ctr, seat, floor = 1;
    private static DefModuleView def;
    private static DBConnect db;
    
    public ReserveSeatsController(int theaterID){
        this.theaterID = theaterID;
        initializeSeats();
        setBtns();
    }
    
    public int checkSeatEnabled(int i, int j){
       
        String sqlSelectStatus = "SELECT seat_enabled FROM seat WHERE theaterID = '"+theaterID+"' AND floorNum = '1' AND row = '"+i+"' AND column = '"+j+"' ";
        int status = db.getInteger(sqlSelectStatus);
        return status;
   
    }
    
    public void setBtns(){
        db = db.getDBConnect();
        String sqlSelectNumOfFloors = "SELECT numOfFloors from theater WHERE theaterID = '"+theaterID+"' ";
        int numOfFloors = db.getInteger(sqlSelectNumOfFloors);
        ctr = numOfFloors;
        String sqlSelectNumofSeats = "SELECT SUM(seatID) from seat WHERE theaterID = '"+theaterID+"' AND floorNum = '" + floor +"' ";
        int numofseats = db.getInteger(sqlSelectNumOfFloors);
        seat = numofseats;
        
        // set combo box
        for(int i = 1; i <= numOfFloors; i++){
            setFloor(i);
        }

        
        setBtnReserve(new btnReserve_Action());
        setSeat(new seat_Action());
    }
     public void changeFloorNumber(){
         
         
     }

    private class btnChangeFloor_Action implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
           
    
        }
        
    }
    
    //Add the seats to the DB
    private class btnReserve_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton[][] grid = getSeats();
            String row = "";
            int col = 0;
            int ctr = 2;
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 10; j++) {
                    
                    if(grid[i][j].getBackground() == Color.GREEN) {
                       String sqlUpdateSeat = "UPDATE seat SET status = 'Reserved' WHERE theaterID = '"+theaterID+"' AND floorNum = '"+floor+"' AND row = '"+i+"' AND column = '"+j+"' ";
                    db.executeQuery(sqlUpdateSeat);
                        grid[i][j].setBackground(Color.RED);
                        ctr++;
                        
                        switch(i) {
                        case 0: row = "A";
                            break;
                        case 1: row = "B";
                            break;
                        case 2: row = "C";
                            break;
                        case 3: row = "D";
                            break;
                        case 4: row = "E";
                    }
                    col = j + 1;
                    System.out.println(row + col + " added");
                        
                    }
                    
                    
                }
            }
        }
    }
    
    //Change color for the seats(Green = seat, Gray = nothing)
    private class seat_Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int x = 0, y = 0;
            Object source = e.getSource();
            if (source instanceof JButton) {
                
                  
                
                
                if(((((JButton)source).getBackground() == Color.GREEN))) {
                    ((JButton)source).setBackground(Color.RED);
                    
                    
                }
                else {
                    ((JButton)source).setBackground(Color.GREEN);
                }
            }        
        }
    }
}
