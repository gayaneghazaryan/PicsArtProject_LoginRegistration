package registrationAndLogin.gui;

import registrationAndLogin.exception.InvalidLoginException;
import registrationAndLogin.exception.NotExistingUserException;
import registrationAndLogin.service.RegistrationAndLoginService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {
    JLabel title;
    JPanel loginPanel;
    JLabel username;
    JTextField usernameField;
    JLabel password;
    JPasswordField passwordField;
    JPanel buttonPanel;
    JButton loginButton;
    JButton resetButton;

    public LoginPage() {
        setTitle("Login Page");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(3,1,0,50));

        title = new JLabel();
        title.setText("Login");
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);

        loginPanel = new JPanel();
        loginPanel.setBorder(new EmptyBorder(0,100,0,100));
        loginPanel.setLayout(new GridLayout(2,2,0,0));

        username = new JLabel();
        username.setText("Username");
        username.setHorizontalAlignment(JLabel.LEFT);

        password = new JLabel();
        password.setText("Password");
        password.setHorizontalAlignment(JLabel.LEFT);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(20,20));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(20,20));

        loginPanel.add(username);
        loginPanel.add(usernameField);
        loginPanel.add(password);
        loginPanel.add(passwordField);

        add(loginPanel);

        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");

        loginButton.setFont(new Font("Arial",Font.PLAIN,12));
        resetButton.setFont(new Font("Arial",Font.PLAIN,12));

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);

        add(buttonPanel);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(loginButton.getActionCommand())) {
            try{
                if(RegistrationAndLoginService.isValidLogin(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                    JOptionPane.showMessageDialog(this,"Login has completed successfully.");
                    dispose();
                }
            } catch (InvalidLoginException | NotExistingUserException exception) {
                JOptionPane.showMessageDialog(this,exception.getMessage());
            }
        }
        if(e.getActionCommand().equals(resetButton.getActionCommand())) {
            usernameField.setText(null);
            passwordField.setText(null);
        }
    }
}
