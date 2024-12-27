package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton reception, admin;

    Dashboard() {
        super("Fontainebleau Dashboard");

        // Create the reception button
        reception = new JButton("Reception");
        reception.setBounds(425, 550, 140, 30);
        reception.setFont(new Font("Segoe UI", Font.BOLD, 15));
        reception.setBackground(new Color(248, 221, 184));
        reception.setForeground(new Color(0, 0, 0));
        reception.setBorder(BorderFactory.createLineBorder(new Color(222, 149, 54, 255), 3));
        reception.addActionListener(this);
        add(reception);

        // Create the admin button
        admin = new JButton("Admin");
        admin.setBounds(793, 550, 140, 30);
        admin.setFont(new Font("Segoe UI", Font.BOLD, 15));
        admin.setBackground(new Color(248, 221, 184));
        admin.setForeground(new Color(0, 0, 0));
        admin.setBorder(BorderFactory.createLineBorder(new Color(222, 149, 54, 255), 3));
        admin.addActionListener(this);
        add(admin);

        // Set the layout and window properties
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1950, 1090);
        setVisible(true);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, getWidth(), getHeight());
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reception) {
            new Reception();
            setVisible(false);
        } else {
            new AdminLogin();
            setVisible(false);

        }
    }


    public static void main(String[] args) {
        new Dashboard();
    }
}
