 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Belle
 */
public class AddMovieView extends JFrame{
    private JLabel lblTitle, lblDesc, lblGenre, lblPoster, lblURL;
    private JTextField txtTitle;
    private JTextArea txtDesc;
    private JComboBox boxGenre;
    private JButton btnPoster, btnAddMovie;
    private JFileChooser chooser;
    private JScrollPane jspTextArea;
    private File file;
    private BufferedImage stream;
    private String[] monthString; 
    private String fileLoc;
    
    public AddMovieView(){
         try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setTitle("Add Movie");
        this.setSize(450, 300);
        this.setLocation(325, 120);
        this.setResizable(false);
        init();
        this.setVisible(true);
    }
    
    public void init(){
       lblTitle = new JLabel("Title: ");
       lblDesc = new JLabel("Description: ");
       lblGenre = new JLabel("Genre: ");
       lblPoster = new JLabel("Movie Poster: ");
       txtTitle = new JTextField();
       txtDesc = new JTextArea(5,5);
       lblURL = new JLabel();
       jspTextArea = new JScrollPane(txtDesc);
       monthString = new String[]{"Action", "Adventure", "Animation", "Comedy", "Crime", "Documentary", "Drama", "Fantasy", "Horror/Thriller", "Musical", "Romance", "Sci-Fi"};
       boxGenre = new JComboBox(monthString);
       btnPoster = new JButton("Choose file");
       btnAddMovie = new JButton("SAVE");
       chooser = new JFileChooser();

       this.add(lblTitle);
       this.add(lblDesc);
       this.add(lblGenre);
       this.add(lblPoster);
       this.add(txtTitle);
       this.add(jspTextArea);
       this.add(boxGenre);
       this.add(btnPoster);
       this.add(lblURL);
       this.add(btnAddMovie);
       
       lblTitle.setBounds(20, 10, 100, 20);
       lblDesc.setBounds(20, 60, 100, 20);
       lblGenre.setBounds(20, 160, 100, 20);
       lblPoster.setBounds(20, 210, 100, 20);
       
       txtTitle.setBounds(100, 10, 300, 30);
       jspTextArea.setBounds(100, 60, 300, 80);
       boxGenre.setBounds(100, 155, 150, 30);
       btnPoster.setBounds(100, 205, 100, 28);
       lblURL.setBounds(220, 205, 200, 28);
       btnAddMovie.setBounds(130, 240, 200, 30);
       
       txtDesc.setWrapStyleWord(true);
       txtDesc.setLineWrap(true);
       btnAddMovie.setFont(new Font("Tahoma", Font.BOLD, 14));
       this.setLayout(null);
       
       btnPoster.addActionListener(new btnPoster_Action());
    }
    
    public void setBtnAddMovie(ActionListener a){
        btnAddMovie.addActionListener(a);
    }
    
    public void setBtnPoster(ActionListener a){
        btnPoster.addActionListener(a);
    }   
    // getters
    public String getTitle(){
        return txtTitle.getText();
    }
    public String getDesc(){
        return txtDesc.getText();
    }
    public String getGenre(){
        return boxGenre.getSelectedItem().toString();
    }
    public BufferedImage getStream(){
        return stream;
    }
    
    public void disposeFrame(){
        this.dispose();
    }
    
    // image button
    private class btnPoster_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           chooser.setMultiSelectionEnabled(false);
           int option = chooser.showOpenDialog(null);
           
           if (option == JFileChooser.APPROVE_OPTION) {
               try {
                    fileLoc = chooser.getSelectedFile().getAbsolutePath();
                    file = new File(fileLoc);
                    stream = ImageIO.read(file);
                    lblURL.setText(chooser.getName(file));
               } catch (IOException ex) {
               }
           }
           else 
              stream = null;
        }
    }
}
