/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmodule;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Mico
 */


public class SelectionView extends JPanel  {
   private DefaultListModel mdlMovie;
    private JButton btnDisplay; //remove btnAddMovie
    private JList listMovie;
    private JScrollPane jspMovie;
    private JLabel lblMovie, lblImage, lblTitle, lblDesc, lblGenre;
    private JPanel pnlDisplay;
    private ImageIcon image;
    
    private JComboBox boxTheater;
    private JButton btnSchedule;
    
    public SelectionView(){
         try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
         
        this.setSize(660, 720);
        init();        
    }

    public void init(){
        pnlDisplay = new JPanel();
        mdlMovie = new DefaultListModel();
//        btnAddMovie = new JButton("Select Seats");
        btnDisplay = new JButton(">>");
        lblMovie = new JLabel("List of Movies and Theaters");
        listMovie = new JList();
        lblTitle = new JLabel();
        lblDesc = new JLabel();
        lblGenre = new JLabel();
        
        boxTheater = new JComboBox();
        btnSchedule = new JButton("Start Booking");
        
        listMovie.setVisibleRowCount(10);
        listMovie.setFixedCellHeight(20);
        listMovie.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jspMovie = new JScrollPane(listMovie);
        
        this.add(pnlDisplay);
//        this.add(btnAddMovie);
        this.add(btnDisplay);
        this.add(lblMovie);        
        this.add(jspMovie);
        
        this.add(btnSchedule);
        this.add(boxTheater);  
        boxTheater.setBounds(260, 480, 200, 40);
        btnSchedule.setFont(new Font("Tahoma", Font.BOLD, 20)); 
        btnSchedule.setBounds(260, 550, 200, 30);
        
        pnlDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
//        btnAddMovie.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMovie.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMovie.setBounds(280, 10, 200, 20);  
        jspMovie.setBounds(10, 50, 300, 400);       
//        btnAddMovie.setBounds(240, 550, 200, 30);
        btnDisplay.setBounds(310, 230, 70, 40);
        pnlDisplay.setBounds(380, 50, 255, 390);

        listMovie.setModel(mdlMovie);
        this.setLayout(null);
    }
    
    public void setBtnDisplay(ActionListener a){
        btnDisplay.addActionListener(a);
    }    
    
//    public void setBtnAddMovie(ActionListener a){
//        btnAddMovie.addActionListener(a);
//    }
    
    public void clearList(){
        mdlMovie.clear();
    }
    
    public void addList(String text){
        mdlMovie.addElement(text);
    }
    
    public String getSelectedMovie(){
        if(!listMovie.isSelectionEmpty())
            return listMovie.getSelectedValue().toString();
        return "";
    }
    
    public void displayImage(int movieID, String title, String desc, String genre){
        pnlDisplay.removeAll();
        pnlDisplay.updateUI();
        pnlDisplay.setLayout(new BoxLayout(pnlDisplay, BoxLayout.Y_AXIS));
        
        image = new ImageIcon(new ImageIcon("posters\\" + movieID + ".jpg").getImage().getScaledInstance(252, 320, Image.SCALE_DEFAULT));
        
        lblImage = new JLabel(image);

        lblTitle.setText("Title: " + title);
        lblGenre.setText("Genre: " + genre);
        lblDesc.setText("Description: " + desc);
        
        pnlDisplay.add(lblImage);       
        pnlDisplay.add(lblTitle);   
        pnlDisplay.add(lblGenre);   
        pnlDisplay.add(lblDesc);
     
    }   
    
    public String getBoxTheater() {
        return boxTheater.getSelectedItem().toString();
    }
    
//    public String getMovieSelected(){
//        return 
//    }
    
    public void setBtnSchedule(ActionListener a){
        btnSchedule.addActionListener(a);
    }
    

    public void setTheater(String theater){
        boxTheater.addItem(theater);
    }
}