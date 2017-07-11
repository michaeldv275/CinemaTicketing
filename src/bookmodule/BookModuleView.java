/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmodule;

import defmodule.AddSeatsController;
import defmodule.DefModuleView;
import defmodule.MovieListController;
import defmodule.MovieShowingController;
import defmodule.TheaterListController;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import udc.DBConnect;

/**
 *
 * @author Mico
 */
public class BookModuleView extends JFrame{
    private JTabbedPane jtp;
    private static BookModuleView bookView;
    private static DBConnect db;
    
    private BookModuleView() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setTitle("Booking Module");
        this.setSize(660, 720);
        
        this.setLayout(null);
        this.setLocation(325, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

        this.setResizable(false);
        this.setVisible(true);
    }
    private void init(){
        SelectionController select = new SelectionController();
    
        jtp = new JTabbedPane();

        jtp.addTab("Booking", select);

        
        this.setLayout(new GridLayout(1, 1));
        this.add(jtp);
        
    }
    public static BookModuleView getBookView() 
    {
        if (bookView == null)
            bookView = new BookModuleView();
        return bookView;
    }
    
//    public void setSeatsView(int theaterID){
//        jtp.setEnabledAt(0, false);
//        jtp.setEnabledAt(1, false);
//        jtp.setComponentAt(2, new AddSeatsController(theaterID));
//    }    
    
    public void setMovieList(){
        jtp.setComponentAt(0, new SelectionController());
    }
    
//    public void setTheaterLit(){
//        jtp.setComponentAt(2, new TheaterListController());
//    }
}
