/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udc;

import java.sql.*;
import login.LoginView;
import login.LoginController;
import signup.SignupView;
import defmodule.DefModuleView;

/**
 *
 * @author Belle
 */
public class UDC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        LoginView login = new LoginView();
        LoginController lc = new LoginController (login);
        //DefModuleView def = new DefModuleView();
        
    }
    
}
