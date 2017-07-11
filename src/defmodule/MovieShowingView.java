/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Belle
 */
public class MovieShowingView extends JPanel{
    private JButton btnSchedule;
    private JComboBox boxTheater;
    private JLabel lblChoose;
    
    public MovieShowingView(){
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
        lblChoose = new JLabel("Select Theater:");
        btnSchedule = new JButton("Check Schedule");
        boxTheater = new JComboBox();
        
        this.add(lblChoose);
        this.add(btnSchedule);
        this.add(boxTheater);    
        
        lblChoose.setFont(new Font("Tahoma", Font.BOLD, 14));  
        btnSchedule.setFont(new Font("Tahoma", Font.BOLD, 20));     
        lblChoose.setBounds(280, 210, 200, 40);
        boxTheater.setBounds(230, 250, 200, 40);
        btnSchedule.setBounds(180, 330, 300, 40);
        
        this.setLayout(null);        
    }

    public String getBoxTheater() {
        return boxTheater.getSelectedItem().toString();
    }
    public void setBtnSchedule(ActionListener a){
        btnSchedule.addActionListener(a);
    }
    
    public void setTheater(String theater){
        boxTheater.addItem(theater);
    }

}
