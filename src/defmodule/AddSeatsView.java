/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defmodule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import udc.DBConnect;

/**
 *
 * @author Belle
 */
public class AddSeatsView extends JFrame{
    private static DBConnect db;
    private DefaultTableModel model;
    private JTable table;
    private JLabel lblFloor, lblAdd;
    private JComboBox boxFloor;
    private JButton btnSave;
    private int theaterID;
    private JButton[][] grid;
    private JPanel gridPanel;
    private JPanel containerPanel;
    
    public AddSeatsView(){
        this.setTitle("Add Seats");
        this.setResizable(false);
        this.setLocation(150, 10);
        init();
        this.setVisible(true);
    }
    
    public void init(){
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5, 10));
        gridPanel.setPreferredSize(new Dimension(800, 600));
        containerPanel = new JPanel();
        
        model = new DefaultTableModel();
        table = new JTable(model);
        lblFloor = new JLabel("Floor: ");
        boxFloor = new JComboBox();
        btnSave = new JButton("Save");
        
        grid = new JButton[5][10];
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0 ; j < 10; j++) {
                grid[i][j] = new JButton("seat");
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setVisible(true);
                gridPanel.add(grid[i][j]);
            }
        }

        containerPanel.add(lblFloor);
        containerPanel.add(boxFloor);
        containerPanel.add(gridPanel);
        containerPanel.add(table);
        containerPanel.add(btnSave);
        
        this.add(containerPanel);
        
        this.getContentPane().add(containerPanel);
        this.pack();
        this.setVisible(true);
        
        lblFloor.setBounds(50, 200, 120, 20);
        boxFloor.setBounds(100, 195, 70, 30);        
        btnSave.setBounds(240, 400, 200, 30);
       
        //btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        this.setLayout(null);
    }
    
    public void setBtnSave(ActionListener a){
        btnSave.addActionListener(a);
    }
    
    public void setSeat(ActionListener a) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                grid[i][j].addActionListener(a);
            }
        }
    }
      
    public void setFloor(int floor){
        boxFloor.addItem(floor);
    }
    
    public JButton[][] getSeats() {
        return grid;
    }
    
    public void delFloor(int floor){
        boxFloor.removeItem(floor);
    }
    
    public int getFloor(){
        int floor = Integer.parseInt(boxFloor.getSelectedItem().toString());
        return floor;
    }

    
}

