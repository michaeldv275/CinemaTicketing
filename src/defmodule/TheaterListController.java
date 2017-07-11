/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class TheaterListController extends TheaterListView {
    private static DBConnect db;
    public TheaterListController() {
        setListView();
        setBtns();
    }
    public void setListView(){
        db = db.getDBConnect();
        clearList();
        try {
            Statement st = db.getCon().createStatement();
            String sqlGetMovies = "SELECT * from theater";
            ResultSet rs = st.executeQuery(sqlGetMovies);
            while(rs.next()){
                addList(rs.getString("theaterName"));
            }
        } catch (SQLException ex) {
        }
    }    
    
    public void setBtns () {
        setBtnAddTheater(new btnAddTheater_Action());
    }

    private class btnAddTheater_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           AddTheaterController addTheater = new AddTheaterController();
           
        }
    }
}