package com.fontainebleau;

import javax.swing.*;

public class Splash extends JFrame {

    Splash() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/splash2.gif"));
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 858, 650);
        add(label); // add the label to the frame


        setLayout(null); // set the layout to null from default border layout
        setLocation(250, 25); // set the location of the frame for middle of the screen
        setSize(858, 650);
        setUndecorated(true); // remove the title bar
        setVisible(true); // make the frame visible

        try {
            Thread.sleep(5000); // sleep for 5 seconds
            new Login(); // open the login frame
            setVisible(false); // close the frame
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
