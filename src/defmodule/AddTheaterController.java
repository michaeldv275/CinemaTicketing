/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import udc.DBConnect;


/**
 *
 * @author Belle
 */
public class AddTheaterController extends AddTheaterView{
    private static DefModuleView defView;
    private static DBConnect db;
    public AddTheaterController() {
        setBtns();
    }
    
    public void setBtns () {
        setBtnAddTheater(new btnAddTheater_Action());
    }

    private class btnAddTheater_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            db = db.getDBConnect();
            defView = defView.getDefView();

            String error = "";
            AddTheater add = new AddTheater(getTheaterName(), getFloor(), getPrice());
            
            if(add.getResult() != 0)
                error = error.concat('\n' + "- Theater name already exists");
            if(add.checkName())
                error = error.concat('\n' + "- Add theater name");
            if(add.checkFloor())
                error = error.concat('\n' + "- Add number of floors");
            if(add.checkPrice())
                error = error.concat('\n' + "- Add price");
            
            
            if(add.authenticate()) {
                // insert new theater
                add.sqlAdd();

                defView.setMovieList();
                disposeFrame();
                JOptionPane.showMessageDialog(null, "Successfully added a theater!", "Information Message", JOptionPane.INFORMATION_MESSAGE);
                AddSeatsController addSeats = new AddSeatsController(add.getTheaterID());
            }
            else
                JOptionPane.showMessageDialog(null, error, "Error Message", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
