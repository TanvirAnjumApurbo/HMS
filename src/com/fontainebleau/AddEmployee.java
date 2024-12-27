package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameF, ageF, salaryF, phoneF, NIDF, emailF;
    JRadioButton genderM, genderF;
    JComboBox jobF;
    JButton add, back;

    AddEmployee() {
        // Create a panel for form fields (scrollable)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(39, 40, 41));
        formPanel.setPreferredSize(new Dimension(850, 500));

        // Scroll Pane for formPanel
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(5, 5, 875, 430);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        // Add form fields to formPanel
        JLabel label = new JLabel("Add Employee");
        label.setBounds(350, 10, 200, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(new Color(255, 255, 255));
        formPanel.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 70, 100, 30);
        name.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        name.setForeground(new Color(255, 255, 255));
        formPanel.add(name);

        nameF = new JTextField();
        nameF.setBounds(200, 70, 150, 30);
        nameF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nameF.setBackground(new Color(105, 105, 105));
        nameF.setForeground(new Color(255, 255, 255));
        formPanel.add(nameF);

        JLabel age = new JLabel("Age");
        age.setBounds(50, 120, 100, 30);
        age.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        age.setForeground(new Color(255, 255, 255));
        formPanel.add(age);

        ageF = new JTextField();
        ageF.setBounds(200, 120, 150, 30);
        ageF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        ageF.setBackground(new Color(105, 105, 105));
        ageF.setForeground(new Color(255, 255, 255));
        formPanel.add(ageF);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 170, 100, 30);
        gender.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        gender.setForeground(new Color(255, 255, 255));
        formPanel.add(gender);

        genderM = new JRadioButton("Male");
        genderM.setBounds(200, 170, 70, 30);
        genderM.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        genderM.setBackground(new Color(39, 40, 41));
        genderM.setForeground(new Color(255, 255, 255));
        formPanel.add(genderM);

        genderF = new JRadioButton("Female");
        genderF.setBounds(280, 170, 70, 30);
        genderF.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        genderF.setBackground(new Color(39, 40, 41));
        genderF.setForeground(new Color(255, 255, 255));
        formPanel.add(genderF);

        JLabel job = new JLabel("Job");
        job.setBounds(50, 220, 100, 30);
        job.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        job.setForeground(new Color(255, 255, 255));
        formPanel.add(job);

        jobF = new JComboBox(new String[]{"Manager", "Receptionist", "Housekeeping", "Kitchen Staff", "Room Service", "Accountant", "Chef", "Cleaner"});
        jobF.setSelectedIndex(-1);
        jobF.setBounds(200, 220, 150, 30);
        jobF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jobF.setBackground(new Color(105, 105, 105));
        jobF.setForeground(new Color(255, 255, 255));
        formPanel.add(jobF);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(50, 270, 100, 30);
        salary.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        salary.setForeground(new Color(255, 255, 255));
        formPanel.add(salary);

        salaryF = new JTextField();
        salaryF.setBounds(200, 270, 150, 30);
        salaryF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        salaryF.setBackground(new Color(105, 105, 105));
        salaryF.setForeground(new Color(255, 255, 255));
        formPanel.add(salaryF);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 320, 100, 30);
        phone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        phone.setForeground(new Color(255, 255, 255));
        formPanel.add(phone);

        phoneF = new JTextField();
        phoneF.setBounds(200, 320, 150, 30);
        phoneF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        phoneF.setBackground(new Color(105, 105, 105));
        phoneF.setForeground(new Color(255, 255, 255));
        formPanel.add(phoneF);

        JLabel NID = new JLabel("NID");
        NID.setBounds(50, 370, 100, 30);
        NID.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        NID.setForeground(new Color(255, 255, 255));
        formPanel.add(NID);

        NIDF = new JTextField();
        NIDF.setBounds(200, 370, 150, 30);
        NIDF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        NIDF.setBackground(new Color(105, 105, 105));
        NIDF.setForeground(new Color(255, 255, 255));
        formPanel.add(NIDF);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 420, 100, 30);
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        emailLabel.setForeground(new Color(255, 255, 255));
        formPanel.add(emailLabel);

        emailF = new JTextField();  // Change here
        emailF.setBounds(200, 420, 150, 30);
        emailF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        emailF.setBackground(new Color(105, 105, 105));
        emailF.setForeground(new Color(255, 255, 255));
        formPanel.add(emailF);

        // Add and Back buttons (fixed at the bottom)
        add = new JButton("Add");
        add.setBounds(450, 450, 100, 30);
        add.setFont(new Font("Segoe UI", Font.BOLD, 15));
        add.setBackground(new Color(39, 40, 41));
        add.setForeground(new Color(255, 255, 255));
        add.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(350, 450, 100, 30);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setBackground(new Color(39, 40, 41));
        back.setForeground(new Color(255, 255, 255));
        back.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        back.addActionListener(this);
        add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employee1.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label1 = new JLabel(i2);
        label1.setBounds(530, 120, 200, 200);
        formPanel.add(label1);

        // Main panel setup
        setLayout(null);
        setUndecorated(true);
        setSize(885, 500);
        setLocation(250, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = nameF.getText();
            String age = ageF.getText();
            String salary = salaryF.getText();
            String phone = phoneF.getText();
            String NID = NIDF.getText();
            String email = emailF.getText();
            String job = (String) jobF.getSelectedItem();
            String gender = null;
            if (genderM.isSelected()) {
                gender = "Male";
            } else if (genderF.isSelected()) {
                gender = "Female";
            }

            try {
                Con c = new Con();
                String str = "INSERT INTO employees (name, age, gender, job, salary, phone, nid, email) VALUES ('"
                        + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '"
                        + phone + "', '" + NID + "', '" + email + "')";
                c.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == back) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}