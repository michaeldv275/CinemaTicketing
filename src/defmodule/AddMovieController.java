/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import udc.DBConnect;


/**
 *
 * @author Belle
 */
public class AddMovieController extends AddMovieView{
    private static DBConnect db;
    private static DefModuleView def;
    public AddMovieController() {
        setBtns();
    }
    
    public void setBtns () {
        setBtnAddMovie(new btnAddMovie_Action());
    }

    private class btnAddMovie_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            db = db.getDBConnect();
            def = def.getDefView();
            
            String error = "";
            AddMovie add = new AddMovie(getTitle(), getDesc(), getGenre());
            BufferedImage stream = getStream();

            // displaying of error
            if(add.getResult() != 0)
                error = error.concat('\n' + "- Movie already exists");
            if(!add.checkTitle())
                error = error.concat('\n' + "- Add title");
            if(!add.checkDesc())
                error = error.concat('\n' + "- Add description");
            if(stream == null)
                error = error.concat('\n' + "- Add an image file");
            
            
            if(add.authenticate() && (stream != null)) {
                // insert movie to db
                add.sqlAddMovie();

                // write image to directory
                try{
                    File f = new File("posters\\" + add.getMovieID() + ".jpg");  //output file path
                    ImageIO.write(stream, "jpg", f);
                }catch(IOException io){
                }
                
                // update list
                def.setMovieList();
                disposeFrame();
                JOptionPane.showMessageDialog(null, "Successfully added a movie!", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, error, "Error Message", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
