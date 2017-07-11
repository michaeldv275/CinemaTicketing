/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UltimateDesignChallenge;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEADING;

/**
 *
 * @author Angel
 */
public class LoginView {

    private JFrame frmMain;
    private Container pane;
    private JPanel loginPanel, signupPanel;
    private JLabel hiLabel, loginLabel, unLabel, pwLabel;
    private JLabel signupLabel, userTypeLabel, nameLabel, newUNLabel, newPWLabel, confirmPWLabel;
    private JButton btnLogIn, btnSignUp;
   
    private JTextField unTextField = new JTextField();
    private JPasswordField pwTextField = new JPasswordField();
    
    private JTextField nameTextField = new JTextField();
    private JTextField newUNTextField = new JTextField();
    private JPasswordField newPWTextField = new JPasswordField();
    private JPasswordField confirmPWTextField = new JPasswordField();
    private String[] userTypeString = {"Administrator", "Customer"};
    private JComboBox userType = new JComboBox(userTypeString);
    
    public LoginView() {
        
        frmMain = new JFrame ("Movie Seat Booking System");
        frmMain.setSize(500, 600);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setResizable(false);
        frmMain.setVisible(true);

        hiLabel = new JLabel ("Movie Seat Booking System");
        
        // LOGIN DETAILS
        loginLabel = new JLabel ("Enter username and password:");
        unLabel = new JLabel ("Username:");
        pwLabel = new JLabel ("Password:");
        btnLogIn = new JButton ("Log In");
        
        loginPanel = new JPanel(null);
        loginPanel.setBorder(BorderFactory.createTitledBorder("Log In"));
        pane.add(loginPanel);
        
        loginPanel.add(loginLabel);
        loginPanel.add(unLabel);
        loginPanel.add(unTextField);
        loginPanel.add(pwLabel);
        loginPanel.add(pwTextField);
        loginPanel.add(btnLogIn);
        
        loginPanel.setBounds(85, 30, 300, 180);
        
        unLabel.setBounds(20, 40, 80, 25);
        unTextField.setBounds(110, 40, 160, 25);
        
        pwLabel.setBounds(20, 70, 80, 25);
        pwTextField.setBounds(110, 70, 160, 25);
        
        btnLogIn.setBounds(120, 120, 80, 25);
        
        // SIGN UP DETAILS
        signupLabel = new JLabel ("Fill out the form:");
        userTypeLabel = new JLabel ("User Type:");
        nameLabel = new JLabel ("Name:");
        newUNLabel = new JLabel ("Username:");
        newPWLabel = new JLabel ("Password:");
        confirmPWLabel = new JLabel ("Confirm password:");
        btnSignUp = new JButton ("Register");
       
        signupPanel = new JPanel(null);
        signupPanel.setBorder(BorderFactory.createTitledBorder("Sign Up"));
        pane.add(signupPanel);
        
        signupPanel.add(signupLabel);
        signupPanel.add(userTypeLabel);
        signupPanel.add(userType);
        signupPanel.add(nameLabel);
        signupPanel.add(nameTextField);
        signupPanel.add(newUNLabel);
        signupPanel.add(newUNTextField);
        signupPanel.add(newPWLabel);
        signupPanel.add(newPWTextField);
        signupPanel.add(confirmPWLabel);
        signupPanel.add(confirmPWTextField);
        signupPanel.add(btnSignUp);
        
        signupPanel.setBounds(30, 240, 400, 300);
        
        userTypeLabel.setBounds(20, 40, 120, 25);
        userType.setBounds(150, 40, 160, 25);
        
        nameLabel.setBounds(20, 70, 120, 25);
        nameTextField.setBounds(150, 70, 200, 25);
        
        newUNLabel.setBounds(20, 100, 120, 25);
        newUNTextField.setBounds(150, 100, 160, 25);
        
        newPWLabel.setBounds(20, 130, 120, 25);
        newPWTextField.setBounds(150, 130, 160, 25);
        
        confirmPWLabel.setBounds(20, 160, 120, 25);
        confirmPWTextField.setBounds(150, 160, 160, 25);
        
        btnSignUp.setBounds(130, 220, 130, 25);
    }
   
}
