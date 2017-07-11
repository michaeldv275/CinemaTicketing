/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import bookmodule.BookModuleView;
import bookmodule.SelectionController;
import bookmodule.SelectionView;
import udc.LoginModel;
import signup.SignupView;
import signup.SignupController;
import defmodule.DefModuleView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Belle
 */
public class LoginController {

    private LoginView frame;
    
    public LoginController(LoginView frame) {
        this.frame = frame;
        setBtns();
    }
    
    public void setBtns () {
        frame.setBtnLogin(new btnLogin_Action());
        frame.setBtnReg(new btnReg_Action());
    }


    private class btnLogin_Action implements ActionListener {
        DefModuleView def;
        BookModuleView sel;
        
        public void actionPerformed(ActionEvent e) {
           LoginModel login = new LoginModel();
           String username = frame.getTxtUser();
           String password = frame.getTxtPass();
           String type = "";
           
           if(login.checkUsername(username)){
                if(login.checkPassword(username, password)){
                    type = login.checkType(username);
                    
                    if(type.matches("Admin")) {
                        frame.dispose();
                        def = DefModuleView.getDefView();
                    }
                    else{
                        frame.dispose();
                        sel = BookModuleView.getBookView();
                    }
                    
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Incorrect Password", "Error Message", JOptionPane.WARNING_MESSAGE);
                }
           }
           else {
               JOptionPane.showMessageDialog(frame, "Username doesn't exist", "Error Message", JOptionPane.WARNING_MESSAGE);
           }
               
               
        }
    }

    private class btnReg_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            SignupView sv = new SignupView();
            SignupController sc = new SignupController(sv);
        }
    }
    
}