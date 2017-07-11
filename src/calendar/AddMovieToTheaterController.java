/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import udc.DBConnect;

/**
 *
 * @author Mico
 */
public class AddMovieToTheaterController  extends AddMovieToTheaterView {
    public static DBConnect db;
    private int theaterID;
    
    public AddMovieToTheaterController(int theaterID){
        this.theaterID = theaterID;
        setBtns();
        setMovies();
    }

    public void setBtns(){
        setAdd(new Add_Action());
        setComboBoxMonth(new ComboBox_Action());
        setComboBoxYear(new ComboBox_Action()); 
    }
    
    public void setMovies(){
        db = db.getDBConnect();
        try {
            Statement st = db.getCon().createStatement();
            String sqlGetMovies = "SELECT * from movie";
            ResultSet rs = st.executeQuery(sqlGetMovies);
            while(rs.next()){
                setMovieList(rs.getString("movieName"));
            }
        } catch (SQLException ex) {
        }
    }

    
    private class ComboBox_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int numberOfDays = getNumberOfDays();
            refreshNumberOfDays(numberOfDays);            
        }
    }

    private class Add_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {   
            String sqlGetMovieID = "SELECT movieID from movie where movieName = '"+getBoxMovieList()+"'";
            int movieID = db.getInteger(sqlGetMovieID);
            
            Schedule addSched;
            addSched = new Schedule(theaterID, movieID, getBoxMonths(), getBoxDays(), getBoxYears());
            addSched.sqlAddSched();
            
            
        
                    
            disposeMainFrame();
            JOptionPane.showMessageDialog(null, "Successfully scheduled a movie!", "Information Message", JOptionPane.INFORMATION_MESSAGE);
        }
        
  
    }
    
}
