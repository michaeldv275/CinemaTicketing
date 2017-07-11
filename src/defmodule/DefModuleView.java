/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.GridLayout;
import javax.swing.*;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class DefModuleView extends JFrame{
    private JTabbedPane jtp;
    private static DefModuleView defView;
    private static DBConnect db;
    
    private DefModuleView() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setTitle("Definitions Module");
        this.setSize(660, 720);
        
        this.setLayout(null);
        this.setLocation(325, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

        this.setResizable(false);
        this.setVisible(true);
    }
    private void init(){
        MovieListController addMovie = new MovieListController();
        TheaterListController addTheater = new TheaterListController();
        MovieShowingController schedule = new MovieShowingController();
        
        jtp = new JTabbedPane();

        jtp.addTab("Movie Showing Schedules", schedule);
        jtp.addTab("Add Movie", addMovie);
        jtp.addTab("Add Theater", addTheater);
        
        this.setLayout(new GridLayout(1, 1));
        this.add(jtp);
        
    }
    public static DefModuleView getDefView() 
    {
        if (defView == null)
            defView = new DefModuleView();
        return defView;
    }
    
    public void setSeatsView(int theaterID){
        jtp.setEnabledAt(0, false);
        jtp.setEnabledAt(1, false);
        jtp.setComponentAt(2, new AddSeatsController(theaterID));
    }    
    
    public void setMovieList(){
        jtp.setComponentAt(1, new MovieListController());
    }
    
    public void setTheaterLit(){
        jtp.setComponentAt(2, new TheaterListController());
    }
    
}
