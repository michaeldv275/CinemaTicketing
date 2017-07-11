/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmodule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import udc.DBConnect;

/**
 *
 * @author dorotheabachini
 */
public class ReserveSeatsView extends JFrame{
    private static DBConnect db;
    private DefaultTableModel model;
    private JTable table;
    private JLabel lblFloor, lblAdd;
    private JComboBox boxFloor;
    private JButton btnReserve;
    private int theaterID;
    private JButton[][] grid;
    private JPanel gridPanel;
    private JPanel containerPanel;
    private int seatNumber;
    private ReserveSeatsController cont;
     
    
    public ReserveSeatsView(){
        this.setTitle("Reserve Seats");
//        this.setSize(450, 300);
        this.setLocation(325, 120);
        init();
        this.setVisible(true);
    }
    
    
    public void setController(ReserveSeatsController c){
        this.cont = c;
    }
    
    public void init(){
        seatNumber = 0;
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5, 10));
        gridPanel.setPreferredSize(new Dimension(800, 600));
        containerPanel = new JPanel();
        
        model = new DefaultTableModel();
        table = new JTable(model);
        lblAdd = new JLabel("Add Seats per Floor");
        lblFloor = new JLabel("Floor: ");
        boxFloor = new JComboBox();
        btnReserve = new JButton("Reserve Seats");
        
        grid = new JButton[5][10];
        
        
        /*
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0 ; j < 10; j++) {
                seatNumber++;
                grid[i][j] = new JButton();
                grid[i][j].setBackground(Color.WHITE);
                grid[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/greenChair.png")));
                grid[i][j].setText(String.valueOf(seatNumber));
                grid[i][j].setHorizontalTextPosition(JButton.CENTER);
                grid[i][j].setVerticalTextPosition(JButton.CENTER);
                grid[i][j].setVisible(true);
                gridPanel.add(grid[i][j]);
            }
        }
                
                */
        
        containerPanel.add(lblAdd);
        containerPanel.add(lblFloor);
        containerPanel.add(boxFloor);
        containerPanel.add(gridPanel);
        containerPanel.add(table);
        containerPanel.add(btnReserve);
        
        this.add(containerPanel);
        
        this.getContentPane().add(containerPanel);
        this.pack();
        this.setVisible(true);
        
        lblAdd.setFont(new Font("Papyrus", Font.PLAIN, 20));
        lblAdd.setBounds(200, 100, 350, 30);
        lblFloor.setBounds(270, 200, 120, 20);
        boxFloor.setBounds(340, 195, 70, 30);        
        btnReserve.setBounds(240, 400, 200, 30);
       
        btnReserve.setBackground(Color.BLUE);
        
        this.setLayout(null);
    }
    
    public void setBtnReserve(ActionListener a){
        btnReserve.addActionListener(a);
    }
    
    public void setSeat(ActionListener a) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                grid[i][j].addActionListener(a);
            }
        }
    }
    
    public void clearGrid(){
        gridPanel.removeAll();
        
    }
    
    public void initializeSeats(){
        int i, j;
        for(i = 0; i < 5; i++) {
                for(j = 0 ; j < 10; j++) {
                    grid[i][j] = new JButton();
                    grid[i][j].setBackground(Color.GREEN);
                    grid[i][j].setText("seat");
                    
                    gridPanel.add(grid[i][j]);
                    if(cont.checkSeatEnabled(i,j) == 1)
                        grid[i][j].setVisible(true);
                    else if(cont.checkSeatEnabled(i,j) == 0)
                        grid[i][j].setVisible(false);
                }
        }
        
    }
    
    public void changeFloor(ActionListener a){
        boxFloor.addActionListener(a);
        
    }
      
    public void setFloor(int floor){
        boxFloor.addItem(floor);
    }
    
    public JButton[][] getSeats() {
        return grid;
    }
    
    public int getFloor(){
        int floor = Integer.parseInt(boxFloor.getSelectedItem().toString());
        return floor;
    }
    
    public void setInitialFloor(){
        boxFloor.setSelectedItem(1);
        
    }
    
   

    
}

