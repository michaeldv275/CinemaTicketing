/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Belle
 */
public class LoginView extends JFrame{
   
    private JPanel pnlLogin;
    private JLabel lblUser;
    private JTextField txtUser;
    private JLabel lblPass;
    private JPasswordField txtPass;
    private JButton btnLogin;
    private JButton btnReg;
    private JScrollPane spLogin;  

    public LoginView() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setTitle("Login Page");
        this.setSize(400, 360);
        
        this.setLayout(null);
        this.setLocation(325, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

        this.setResizable(false);
        this.setVisible(true);
    }
    
    private void init(){
        pnlLogin = new JPanel();
        lblUser = new JLabel("Username: ");
        txtUser = new JTextField();
        lblPass = new JLabel("Password: ");
        txtPass = new JPasswordField();
        btnLogin = new JButton("Login");
        btnReg = new JButton("Register");
        spLogin = new JScrollPane(pnlLogin);

        pnlLogin.add(lblUser);
        pnlLogin.add(txtUser);
        pnlLogin.add(lblPass);
        pnlLogin.add(txtPass);
        pnlLogin.add(btnLogin);
        pnlLogin.add(btnReg);
        
        //set position
        lblUser.setBounds(50, 110, 70, 10);
        txtUser.setBounds(150, 100, 200, 29);
        lblPass.setBounds(50, 140, 70, 10);
        txtPass.setBounds(150, 130, 200, 29);
        btnLogin.setBounds(45, 180, 150, 30);
        btnReg.setBounds(200, 180, 150, 30);
        
        pnlLogin.setLayout(null);
        this.setLayout(new GridLayout(0, 1));
        this.add(pnlLogin);
        
    }

    public String getTxtUser() {
        return txtUser.getText();
    }

    public String getTxtPass() {
        return new String(txtPass.getPassword());
    }
    
    public void setBtnLogin(ActionListener a){
        btnLogin.addActionListener(a);
    }
    public void setBtnReg(ActionListener a){
        btnReg.addActionListener(a);
    }
}
