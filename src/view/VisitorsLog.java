package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.Court;

public class VisitorsLog extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTable visitorTable;
    private DefaultTableModel tableModel;

    public VisitorsLog() {
        super("Visitor Log", false, true, false, true);
        setBounds(100, 100, 680, 400);
        getContentPane().setBackground(new Color(207, 207, 201));
        getContentPane().setLayout(null);

        // Create table model
        tableModel = new DefaultTableModel(new String[]{"Visitor Name", "Department", "Judge"}, 0);
        visitorTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(visitorTable);
        scrollPane.setBounds(20, 50, 640, 300);
        getContentPane().add(scrollPane);

        // Load visitor log from ArrayList
        loadVisitorLog();
    }

    private void loadVisitorLog() {
        tableModel.setRowCount(0); // Clear table
        for (String[] row : Court.getInstance().getVisitorLog()) {
            tableModel.addRow(row); // Load from ArrayList
        }
    }
}

