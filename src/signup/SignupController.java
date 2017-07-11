/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import udc.LoginModel;
import udc.DBConnect;
import login.LoginController;
import login.LoginView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Belle
 */
public class SignupController {

    private SignupView frame;
    private static DBConnect db;
    
    public SignupController(SignupView frame) {
        this.frame = frame;
        setBtns();
    }
    
    public void setBtns () {
        frame.setBtnSignup(new btnSignup_Action());
        frame.setBtnBack(new btnBack_Action());
    }


    private class btnSignup_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            db = db.getDBConnect();
            LoginModel login = new LoginModel();
            
            String username = frame.getUser();
            String firstname = frame.getFirst();
            String lastname = frame.getLast();
            String password = frame.getPass();
            String confirmpw = frame.getConfirm();
            String type = frame.getUserType();
            boolean usernameExists = false;
            String error = "";
            
            if(login.checkUsername(username))
                error = error.concat("- Username already exists");
            
            if(!(firstname.matches("[A-Z][a-zA-Z]*")) )
                error = error.concat('\n' + "- Invalid given name format");
            if(!(lastname.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")))
                error = error.concat('\n' + "- Invalid last name format");
            if(!(password.matches(confirmpw)))
                error = error.concat('\n' + "- Password mismatch");
                    
            
            if((usernameExists == false) && (firstname.matches("[A-Z][a-zA-Z]*")) && 
               (lastname.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) && (password.matches(confirmpw))) {
                
                String sqlInsertUser = "INSERT INTO `user`(userID, username, firstname, lastname, password, type) VALUES(null, '"+username+"', '"+firstname+"', '"+lastname+"', '"+password+"', '"+type+"')";
                db.executeQuery(sqlInsertUser);
                JOptionPane.showMessageDialog(frame, "Successfully registered!", "Error Message", JOptionPane.WARNING_MESSAGE);
            }
            else 
                JOptionPane.showMessageDialog(frame, error, "Error Message", JOptionPane.WARNING_MESSAGE);
            
        }
    }

    private class btnBack_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            LoginView lv = new LoginView();
            LoginController lc = new LoginController(lv);
        }
    }
    
}