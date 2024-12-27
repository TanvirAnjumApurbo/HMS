package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {
    JTable table;
    JButton back, applyFilter;
    JComboBox<String> bedTypeFilter;
    JCheckBox availableFilter;

    Room() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 450);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel roomInfoLabel = new JLabel("Room Info");
        roomInfoLabel.setBounds(370, 0, 875, 40);
        roomInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        roomInfoLabel.setForeground(new Color(255, 255, 255));
        panel.add(roomInfoLabel);

        table = new JTable();
        table.setBackground(new Color(39, 40, 41));
        table.setForeground(new Color(255, 255, 255));
        table.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        table.setFont(new Font("Helvetica", Font.PLAIN, 15));

        // Hide the JTable header to keep only the manual heading
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);  // Add table to scroll pane
        scrollPane.setBounds(0, 70, 875, 380);  // Set bounds for scroll pane instead of table
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        panel.add(scrollPane);  // Add scroll pane to the panel

        // Initially load all rooms
        loadRoomData(null, false);

        // Manually added labels for the column headers
        JLabel roomNo = new JLabel("Room No");
        roomNo.setBounds(50, 40, 100, 30);
        roomNo.setFont(new Font("Helvetica", Font.PLAIN, 14));
        roomNo.setForeground(new Color(255, 255, 255));
        panel.add(roomNo);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(220, 40, 100, 30);
        availability.setFont(new Font("Helvetica", Font.PLAIN, 14));
        availability.setForeground(new Color(255, 255, 255));
        panel.add(availability);

        JLabel status = new JLabel("Status");
        status.setBounds(600, 40, 100, 30);
        status.setFont(new Font("Helvetica", Font.PLAIN, 14));
        status.setForeground(new Color(255, 255, 255));
        panel.add(status);

        JLabel price = new JLabel("Price");
        price.setBounds(400, 40, 100, 30);
        price.setFont(new Font("Helvetica", Font.PLAIN, 14));
        price.setForeground(new Color(255, 255, 255));
        panel.add(price);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(750, 40, 100, 30);
        bedType.setFont(new Font("Helvetica", Font.PLAIN, 14));
        bedType.setForeground(new Color(255, 255, 255));
        panel.add(bedType);

        // Filter Section
        JLabel filterLabel = new JLabel("Filter by Bed Type:");
        filterLabel.setBounds(50, 460, 120, 30);
        filterLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        filterLabel.setForeground(new Color(255, 255, 255));
        add(filterLabel);

        bedTypeFilter = new JComboBox<>(new String[]{"All", "Single", "Double", "Triple"});
        bedTypeFilter.setBounds(495, 463, 150, 30);
        bedTypeFilter.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        bedTypeFilter.setBackground(new Color(255, 255, 255));
        bedTypeFilter.setForeground(new Color(0, 0, 0));
        add(bedTypeFilter);

        availableFilter = new JCheckBox("Only Available");
        availableFilter.setBounds(380, 463, 110, 30);
        availableFilter.setBackground(new Color(255, 255, 255));
        availableFilter.setForeground(new Color(0, 0, 0));
        add(availableFilter);

        applyFilter = new JButton("Apply Filter");
        applyFilter.setBounds(650, 463, 130, 30);
        applyFilter.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        applyFilter.setBackground(new Color(255, 255, 255));
        applyFilter.setForeground(new Color(0, 0, 0));
        applyFilter.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(applyFilter);

        applyFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBedType = bedTypeFilter.getSelectedItem().toString();
                boolean onlyAvailable = availableFilter.isSelected();
                loadRoomData(selectedBedType, onlyAvailable);
            }
        });

        back = new JButton("Back");
        back.setBounds(784, 463, 95, 30);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setBackground(new Color(255, 255, 255));
        back.setForeground(new Color(0, 0, 0));
        back.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        setLayout(null);
        setUndecorated(true);
        setSize(885, 500);
        setLocation(400, 120);
        setVisible(true);
    }

    // Method to load data from the database with optional filters
    private void loadRoomData(String bedType, boolean onlyAvailable) {
        try {
            Con c = new Con();
            StringBuilder query = new StringBuilder("SELECT * FROM room WHERE 1=1");

            if (bedType != null && !bedType.equals("All")) {
                query.append(" AND bed_type = '").append(bedType).append("'");
            }

            if (onlyAvailable) {
                query.append(" AND availability = 'available'");
            }

            ResultSet rs = c.statement.executeQuery(query.toString());
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
