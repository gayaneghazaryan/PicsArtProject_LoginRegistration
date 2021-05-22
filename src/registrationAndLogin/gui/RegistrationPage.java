package registrationAndLogin.gui;

import registrationAndLogin.exception.*;
import registrationAndLogin.service.RegistrationAndLoginService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage extends JFrame implements ActionListener {
    JLabel title;
    JPanel formPanel;
    JLabel fullName;
    JTextField fullNameField;
    JLabel username;
    JTextField usernameField;
    JLabel email;
    JTextField emailField;
    JLabel password;
    JPasswordField passwordField;
    JPanel buttonPanel;
    JButton registrationButton;
    JButton resetButton;

    public RegistrationPage() {
        setTitle("Registration Page");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(3,1,0,50));

        title = new JLabel();
        title.setText("Registration Form");
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);

        formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(0,100,0,100));
        formPanel.setLayout(new GridLayout(4,2,0,0));

        fullName = new JLabel();
        fullName.setText("Full Name");
        fullName.setHorizontalAlignment(JLabel.LEFT);

        username = new JLabel();
        username.setText("Username");
        username.setHorizontalAlignment(JLabel.LEFT);

        email = new JLabel();
        email.setText("Email Address");
        email.setHorizontalAlignment(JLabel.LEFT);

        password = new JLabel();
        password.setText("Password");
        password.setHorizontalAlignment(JLabel.LEFT);


        fullNameField = new JTextField();
        fullNameField.setPreferredSize(new Dimension(20,20));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(20,20));

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(20,20));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(20,20));


        formPanel.add(fullName);
        formPanel.add(fullNameField);
        formPanel.add(username);
        formPanel.add(usernameField);
        formPanel.add(email);
        formPanel.add(emailField);
        formPanel.add(password);
        formPanel.add(passwordField);


        add(formPanel);

        registrationButton = new JButton("Register");
        resetButton = new JButton("Reset");

        registrationButton.setFont(new Font("Arial",Font.PLAIN,12));
        resetButton.setFont(new Font("Arial",Font.PLAIN,12));

        registrationButton.addActionListener(this);
        resetButton.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
        buttonPanel.add(registrationButton);
        buttonPanel.add(resetButton);

        add(buttonPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(registrationButton.getActionCommand())) {
            String[] info = {fullNameField.getText(),usernameField.getText(),emailField.getText(),String.valueOf(passwordField.getPassword())};
            try{
                RegistrationAndLoginService.createUser(info);
                JOptionPane.showMessageDialog(this,"Registration has completed successfully!");
                dispose();
            } catch (ExistingUserException | InvalidUsernameException | InvalidFullNameException | InvalidPasswordException | InvalidEmailAddressException exception) {
                JOptionPane.showMessageDialog(this,exception.getMessage());
            }
        }

        if(e.getActionCommand().equals(resetButton.getActionCommand())) {
            fullNameField.setText(null);
            usernameField.setText(null);
            emailField.setText(null);
            passwordField.setText(null);
        }

    }
}
