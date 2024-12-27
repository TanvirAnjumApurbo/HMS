package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener {


    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1, button2;

    AdminLogin() {
        super("Admin Login");
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 70, 100, 30);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label1.setForeground(new Color(255, 255, 255));
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 120, 100, 30);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label2.setForeground(new Color(255, 255, 255));
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150, 70, 150, 30);
        textField1.setForeground(new Color(255, 255, 255));
        setFont(new Font("Segoe UI", Font.PLAIN, 15));
        textField1.setBackground(new Color(105, 105, 105));
        add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 120, 150, 30);
        passwordField1.setForeground(new Color(255, 255, 255));
        passwordField1.setBackground(new Color(105, 105, 105));
        add(passwordField1);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        //Image i1= icon.getImage().getScaledInstance(255, 300, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(icon);
        label.setBounds(315, 0, 255, 300);
        add(label);

        button1 = new JButton("Login");
        button1.setBounds(40, 180, 120, 30);
        button1.setFont(new Font("Serif", Font.BOLD, 15));
        button1.setBackground(new Color(39, 40, 41));
        button1.setForeground(new Color(255, 255, 255));
        button1.addActionListener(this); // when click on button1, it will call actionPerformed method
        add(button1);

        button2 = new JButton("Cancel");
        button2.setBounds(180, 180, 120, 30);
        button2.setFont(new Font("Serif", Font.BOLD, 15));
        button2.setBackground(new Color(39, 40, 41));
        button2.setForeground(new Color(255, 255, 255));
        button2.addActionListener(this);
        add(button2);

        getContentPane().setBackground(new Color(39, 40, 41));
        setLayout(null);
        setLocation(400, 220);
        setSize(600, 315);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            try {
                Con c = new Con();
                String user = textField1.getText();
                String password = passwordField1.getText();

                String query = "SELECT * FROM admin_login WHERE user_name='" + user + "' AND password='" + password + "'";

                ResultSet rs = c.statement.executeQuery(query);
                if (rs.next()) {
                    new Admin();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }
}
