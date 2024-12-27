package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameF, ageF, carNameF, carNumberF, locationF;
    JRadioButton genderM, genderF;
    JComboBox availabilityF;
    JButton add, back;

    AddDriver() {

        // Create a panel for form fields (scrollable)
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 490);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel label = new JLabel("Add Driver");
        label.setBounds(350, 10, 200, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(new Color(255, 255, 255));
        panel.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 70, 100, 30);
        name.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        name.setForeground(new Color(255, 255, 255));
        panel.add(name);

        nameF = new JTextField();
        nameF.setBounds(200, 70, 150, 30);
        nameF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nameF.setBackground(new Color(105, 105, 105));
        nameF.setForeground(new Color(255, 255, 255));
        panel.add(nameF);

        JLabel age = new JLabel("Age");
        age.setBounds(50, 120, 100, 30);
        age.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        age.setForeground(new Color(255, 255, 255));
        panel.add(age);

        ageF = new JTextField();
        ageF.setBounds(200, 120, 150, 30);
        ageF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        ageF.setBackground(new Color(105, 105, 105));
        ageF.setForeground(new Color(255, 255, 255));
        panel.add(ageF);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 170, 100, 30);
        gender.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        gender.setForeground(new Color(255, 255, 255));
        panel.add(gender);

        genderM = new JRadioButton("Male");
        genderM.setBounds(200, 170, 70, 30);
        genderM.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        genderM.setBackground(new Color(39, 40, 41));
        genderM.setForeground(new Color(255, 255, 255));
        panel.add(genderM);

        genderF = new JRadioButton("Female");
        genderF.setBounds(280, 170, 70, 30);
        genderF.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        genderF.setBackground(new Color(39, 40, 41));
        genderF.setForeground(new Color(255, 255, 255));
        panel.add(genderF);

        JLabel carName = new JLabel("Car Name");
        carName.setBounds(50, 220, 100, 30);
        carName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        carName.setForeground(new Color(255, 255, 255));
        panel.add(carName);

        carNameF = new JTextField();
        carNameF.setBounds(200, 220, 150, 30);
        carNameF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        carNameF.setBackground(new Color(105, 105, 105));
        carNameF.setForeground(new Color(255, 255, 255));
        panel.add(carNameF);

        JLabel carNumber = new JLabel("Car Number");
        carNumber.setBounds(50, 270, 100, 30);
        carNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        carNumber.setForeground(new Color(255, 255, 255));
        panel.add(carNumber);

        carNumberF = new JTextField();
        carNumberF.setBounds(200, 270, 150, 30);
        carNumberF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        carNumberF.setBackground(new Color(105, 105, 105));
        carNumberF.setForeground(new Color(255, 255, 255));
        panel.add(carNumberF);

        JLabel availability = new JLabel("Available");
        availability.setBounds(50, 320, 100, 30);
        availability.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        availability.setForeground(new Color(255, 255, 255));
        panel.add(availability);

        availabilityF = new JComboBox(new String[]{"Yes", "No"});
        availabilityF.setSelectedIndex(-1);
        availabilityF.setBounds(200, 320, 150, 30);
        availabilityF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        availabilityF.setBackground(new Color(105, 105, 105));
        availabilityF.setForeground(new Color(255, 255, 255));
        panel.add(availabilityF);

        JLabel location = new JLabel("Location");
        location.setBounds(50, 370, 100, 30);
        location.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        location.setForeground(new Color(255, 255, 255));
        panel.add(location);

        locationF = new JTextField();
        locationF.setBounds(200, 370, 150, 30);
        locationF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        locationF.setBackground(new Color(105, 105, 105));
        locationF.setForeground(new Color(255, 255, 255));
        panel.add(locationF);

        add = new JButton("Add");
        add.setBounds(200, 420, 100, 30);
        add.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        add.setBackground(new Color(39, 40, 41));
        add.setForeground(new Color(255, 255, 255));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(90, 420, 100, 30);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setBackground(new Color(39, 40, 41));
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/driver1.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label1 = new JLabel(i2);
        label1.setBounds(530, 120, 230, 230);
        panel.add(label1);

        setLayout(null);
        setUndecorated(true);
        setSize(885, 500);
        setLocation(250, 120);
        setVisible(true);
    }

    @Override
    // override actionPerformed method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = nameF.getText();
            String age = ageF.getText();
            String gender = null;
            if (genderM.isSelected()) {
                gender = "Male";
            } else if (genderF.isSelected()) {
                gender = "Female";
            }
            String carName = carNameF.getText();
            String carNumber = carNumberF.getText();
            String available = (String) availabilityF.getSelectedItem();
            String location = locationF.getText();

            try {
                Con c = new Con();
                String str = "INSERT INTO drivers (name, age, gender, car_name, car_number, available, location) VALUES ('" + name + "', '" + age + "', '" + gender + "', '" + carName + "', '" + carNumber + "', '" + available + "', '" + location + "')";
                c.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}