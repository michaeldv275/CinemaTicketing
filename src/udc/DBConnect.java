/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Belle
 */
public class DBConnect {
    
   private Connection test;
   private static DBConnect db;
    
   private Connection connect(){
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/udc";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "";
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, pass);
        if (con == null) {
            System.out.println("Connection cannot be established");
        }
        return con;
    } catch (Exception e) {
        System.out.println(e);
    }
    return null;
   }
   
    public static DBConnect getDBConnect() 
    {
        if (db == null)
            db = new DBConnect();
        return db;
    }

    public void executeQuery(String query){
        try{
            test = this.getCon();
            Statement stmt = test.createStatement();
            stmt.executeUpdate(query);
            test.close();
        } catch(SQLException ex){
        }                
    }
    
    public String getResult(String query, String columnName) {
        ResultSet rs = null;
        String result = "";
        try{
            test = this.getCon();
            Statement stmt = test.createStatement();
            rs = stmt.executeQuery(query);
            
            while(rs.next())
                result = rs.getString(columnName);
            
            test.close();
        } catch(SQLException ex){
        }   

        return result;
    }
    
    public int getInteger(String query) {
        ResultSet rs = null;
        int result = 0;
        try{
            test = this.getCon();
            Statement stmt = test.createStatement();
            rs = stmt.executeQuery(query);
            
            while(rs.next())
                result = rs.getInt(1);
            
            test.close();
        } catch(SQLException ex){
        }   

        return result;
    }
    
    public Connection getCon() throws SQLException{
        return test=this.connect();
    }
}
