/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Belle
 */
public class SignupView extends JFrame{
   
    private JPanel pnlSignup;
    private JLabel lblType, lblFirst, lblLast, lblUser, lblPass, lblConfirm;
    private JTextField txtFirst, txtLast, txtUser;
    private JPasswordField txtPass, txtConfirm;
    private JComboBox boxType;
    private JButton btnSignup, btnBack;
    private JScrollPane spSignup;
    private String[] userType;

    public SignupView() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setTitle("Signup Page");
        this.setSize(400, 360);
        
        this.setLayout(null);
        this.setLocation(325, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

        this.setResizable(false);
        this.setVisible(true);
    }
    
    private void init(){
        userType = new String[] {"Admin", "User"};
        pnlSignup = new JPanel();
        boxType = new JComboBox(userType);
        lblType = new JLabel("User Type: ");
        lblFirst = new JLabel("Given Name: ");
        lblLast = new JLabel("Last Name: ");
        lblUser = new JLabel("Username: ");       
        lblPass = new JLabel("Password: ");
        lblConfirm = new JLabel("Confirm: ");        
        txtFirst = new JTextField();
        txtLast = new JTextField();
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        txtConfirm = new JPasswordField();    
        btnSignup = new JButton("Signup");
        btnBack = new JButton("Back");
        spSignup = new JScrollPane(pnlSignup);

        pnlSignup.add(lblType);
        pnlSignup.add(lblFirst);
        pnlSignup.add(lblLast);
        pnlSignup.add(lblUser);
        pnlSignup.add(lblPass);
        pnlSignup.add(lblConfirm);
        pnlSignup.add(txtFirst);
        pnlSignup.add(txtLast);
        pnlSignup.add(txtUser);
        pnlSignup.add(txtPass);
        pnlSignup.add(txtConfirm);
        pnlSignup.add(boxType);
        pnlSignup.add(btnSignup);
        pnlSignup.add(btnBack);
        
        //set position
        lblType.setBounds(50, 45, 70, 17);
        boxType.setBounds(150, 40, 200, 29);
        lblFirst.setBounds(50, 80, 100, 10);
        txtFirst.setBounds(150, 70, 200, 29);
        lblLast.setBounds(50, 110, 100, 10);        
        txtLast.setBounds(150, 100, 200, 29);
        lblUser.setBounds(50, 140, 100, 10);
        txtUser.setBounds(150, 130, 200, 29);
        lblPass.setBounds(50, 170, 100, 10);
        txtPass.setBounds(150, 160, 200, 29);
        lblConfirm.setBounds(50, 200, 100, 10);
        txtConfirm.setBounds(150, 190, 200, 29);
        btnSignup.setBounds(45, 240, 150, 30);
        btnBack.setBounds(200, 240, 150, 30);
        
        pnlSignup.setLayout(null);
        this.setLayout(new GridLayout(0, 1));
        this.add(pnlSignup);   
    }
    
    public void setBtnSignup(ActionListener a){
        btnSignup.addActionListener(a);
    }
    public void setBtnBack(ActionListener a){
        btnBack.addActionListener(a);
    }    
    
    // GETTERS
    public String getUser(){
        return txtUser.getText();
    }
    public String getFirst(){
        return txtFirst.getText();
    }
    public String getLast(){
        return txtLast.getText();
    }
    public String getPass(){
        return new String(txtPass.getPassword());
    }    
    public String getConfirm(){
        return new String(txtConfirm.getPassword());
    }
    public String getUserType(){
        return boxType.getSelectedItem().toString();
    }
}
