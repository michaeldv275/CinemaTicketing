/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Belle
 */
public class AddTheaterView extends JFrame{
    private JLabel lblName, lblFloor, lblPrice, lblPhp;
    private JTextField txtName, txtFloor, txtPrice;
    private JButton btnAddTheater;
    
    public AddTheaterView(){
         try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
         
        this.setTitle("Add Theater");
        this.setSize(450, 250);
        this.setLocation(350, 200);
        init();
        this.setVisible(true);
    }
    
    public void init(){
       lblName = new JLabel("Name: ");
       lblFloor = new JLabel("Number of Floors: ");
       lblPrice = new JLabel("Price: ");
       lblPhp= new JLabel("Php");
       txtName = new JTextField();
       txtFloor = new JTextField();
       txtPrice = new JTextField();
       btnAddTheater = new JButton("Proceed");
       
       this.add(lblName);
       this.add(lblFloor);
       this.add(lblPrice);
       this.add(lblPhp);
       this.add(txtName);
       this.add(txtFloor);
       this.add(txtPrice);
       this.add(btnAddTheater);
       
       lblName.setBounds(20, 10, 100, 20);
       lblFloor.setBounds(20, 60, 120, 20);
       lblPrice.setBounds(20, 110, 100, 20);
       lblPhp.setBounds(140, 110, 30, 20);
       
       txtName.setBounds(140, 10, 250, 30);   
       txtFloor.setBounds(140, 55, 70, 30);
       txtPrice.setBounds(170, 105, 70, 30);
       btnAddTheater.setBounds(140, 160, 200, 30);
       
       btnAddTheater.setFont(new Font("Tahoma", Font.BOLD, 14));
       this.setLayout(null);
    }
    
    public void setBtnAddTheater(ActionListener a){
        btnAddTheater.addActionListener(a);
    }
    
    // getters
    public String getTheaterName(){
        return txtName.getText();
    }
    public int getFloor(){
        return Integer.parseInt(txtFloor.getText());
    }
    public int getPrice(){
        return Integer.parseInt(txtPrice.getText());
    }
    
    public void disposeFrame(){
        this.dispose();
    }
}
