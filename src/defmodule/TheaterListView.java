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
public class TheaterListView extends JPanel{
    private JButton btnAddTheater;
    private DefaultListModel mdlTheater;
    private JList listTheater;
    private JScrollPane jspTheater;
    private JLabel lblTheater;
    
    public TheaterListView(){
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
        mdlTheater = new DefaultListModel();
        btnAddTheater = new JButton("Add Theater");
        listTheater = new JList();
        lblTheater = new JLabel("List of Theaters");
        
        listTheater.setVisibleRowCount(10);
        listTheater.setFixedCellHeight(20);
        jspTheater = new JScrollPane(listTheater);
        
        this.add(btnAddTheater);
        this.add(jspTheater);
        this.add(lblTheater);
        btnAddTheater.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTheater.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTheater.setBounds(280, 10, 150, 20);
        jspTheater.setBounds(130, 50, 400, 470);         
        btnAddTheater.setBounds(240, 550, 200, 30);
        
        listTheater.setModel(mdlTheater);
        this.setLayout(null);
    }
    
    public void clearList(){
        mdlTheater.clear();
    }
    
    public void addList(String text){
        mdlTheater.addElement(text);
    }    
    public void setBtnAddTheater(ActionListener a){
        btnAddTheater.addActionListener(a);
    }
}
