/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udc;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Belle
 */
public class LoginModel {
    private static DBConnect db;
    public boolean checkUsername(String username){
        db = db.getDBConnect();
        boolean checker = false;
        String sqlUserChecker = "SELECT * from user WHERE username = '" +username+"' ";
            
            
            try{
                Statement st = db.getCon().createStatement();
                ResultSet rs = st.executeQuery(sqlUserChecker);
                
                if(rs.next()){
                    checker = true;
                } 
                
            } catch(Exception a){
                a.printStackTrace();
            }  
        return checker;
    }
    public boolean checkPassword(String username, String password){
        DBConnect db = new DBConnect();
        boolean checker = false;
        String sqlUserChecker = "SELECT * from user WHERE username = '" +username+"' ";
            
            
            try{
                Statement st = db.getCon().createStatement();
                ResultSet rs = st.executeQuery(sqlUserChecker);
                
                if(rs.next()){
                    if(rs.getString("password").matches(password))
                        checker = true;
                } 
                
            } catch(Exception a){
                a.printStackTrace();
            }  
        return checker;
    }
        
    public String checkType(String username){
        DBConnect db = new DBConnect();
        String type = null;
        String sqlUserChecker = "SELECT type from user WHERE username = '" +username+"' ";
            
            
            try{
                Statement st = db.getCon().createStatement();
                ResultSet rs = st.executeQuery(sqlUserChecker);
                
                if(rs.next())
                    type = rs.getString("type");   
                
            } catch(Exception a){
                a.printStackTrace();
            }  
        return type;
    }
    
    
}
