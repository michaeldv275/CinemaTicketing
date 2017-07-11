/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class AddSeatsController extends AddSeatsView{
    private int theaterID, ctr;
    private static DefModuleView def;
    private static DBConnect db;
    
    public AddSeatsController(int theaterID){
        this.theaterID = theaterID;
        setBtns();
    }
    
    public void setBtns(){
        db = db.getDBConnect();
        String sqlSelectNumOfFloors = "SELECT numOfFloors from theater WHERE theaterID = '"+theaterID+"' ";
        int numOfFloors = db.getInteger(sqlSelectNumOfFloors);
        ctr = numOfFloors;
        
        // set combo box
        for(int i = 1; i <= numOfFloors; i++){
            setFloor(i);
        }
        
        
        setBtnSave(new btnSave_Action());
        setSeat(new seat_Action());
    }
    
    //Add the seats to the DB
    private class btnSave_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton[][] grid = getSeats();
            String row = "";
            int col = 0;
            int ctr = 2;
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 10; j++) {
                    if(grid[i][j].getBackground() == Color.GREEN) {
                        String sqlInsertSeat = "INSERT INTO `seat`(seatID, row, col, theaterID, floorNum) VALUES (null, '"+i+"', '"+j+"', '"+theaterID+"', '"+getFloor()+"')";
                        db.executeQuery(sqlInsertSeat);
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
            Object source = e.getSource();
            if (source instanceof JButton) {
                if(((JButton)source).getBackground() == Color.GREEN) {
                    ((JButton)source).setBackground(Color.GRAY);
                }
                else {
                    ((JButton)source).setBackground(Color.GREEN);
                }
            }        
        }
    }
}
