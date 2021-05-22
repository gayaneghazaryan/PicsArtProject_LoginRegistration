package registrationAndLogin.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener {
    JLabel label;
    JPanel panel;
    JButton registrationButton;
    JButton loginButton;

    public MainPage() {
        setTitle("Main Page");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(2,1,0,100));

        label = new JLabel();
        label.setText("Welcome to the app");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        registrationButton = new JButton("Registration");
        loginButton = new JButton("Login");

        registrationButton.setFont(new Font("Arial",Font.PLAIN,12));
        loginButton.setFont(new Font("Arial",Font.PLAIN,12));

        registrationButton.addActionListener(this);
        loginButton.addActionListener(this);

        panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));

        panel.add(registrationButton);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(registrationButton.getActionCommand()))
            new RegistrationPage();
        if(e.getActionCommand().equals(loginButton.getActionCommand()))
            new LoginPage();
    }
}
