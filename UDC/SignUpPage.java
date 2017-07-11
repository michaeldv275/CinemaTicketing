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
public class SignUpPage {

    private JFrame frmMain;
    private Container pane;
    private JPanel signupPanel;
    private JLabel signupLabel, userTypeLabel, nameLabel, newUNLabel, newPWLabel, confirmPWLabel;
    private JButton btnSignUp;
    private JTextField nameTextField = new JTextField();
    private JTextField newUNTextField = new JTextField();
    private JPasswordField newPWTextField = new JPasswordField();
    private JPasswordField confirmPWTextField = new JPasswordField();
    private String[] userTypeString = {"Administrator", "Customer"};
    private JComboBox userType = new JComboBox(userTypeString);
    
    public SignUpPage() {
        
        frmMain = new JFrame ("Sign Up");
        frmMain.setSize(500, 400);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setResizable(false);
        frmMain.setVisible(true);

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
        
        signupPanel.setBounds(25, 50, 420, 280);
        
        userTypeLabel.setBounds(20, 40, 80, 25);
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
