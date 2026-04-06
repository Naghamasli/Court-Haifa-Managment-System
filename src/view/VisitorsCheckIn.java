package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.Court;
import model.Judge;

public class VisitorsCheckIn extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel department;
    private JTextField nameField;
    private JComboBox departmentBox;
    private JButton checkInButton;
    private JLabel judge;
    private JComboBox judgeBox;
    private JButton back;

    public VisitorsCheckIn() {
        super();
        setBounds(100, 100, 680, 400);
        getContentPane().setBackground(new Color(207, 207, 201));
        getContentPane().setLayout(null);


        // Title
        titleLabel = new JLabel("Visitor Check-In");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(165, 20, 317, 34);
        titleLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 64, 128));
        getContentPane().add(titleLabel);

        // Name Label
        nameLabel = new JLabel("Visitor Name:");
        nameLabel.setBounds(32, 80, 133, 18);
        nameLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        nameLabel.setForeground(new Color(17, 80, 136));
        getContentPane().add(nameLabel);

        // Name Field
        nameField = new JTextField();
        nameField.setBounds(199, 80, 180, 22);
        getContentPane().add(nameField);

        // Visiting Label
        department = new JLabel("AllDepartments");
        department.setBounds(32, 128, 133, 22);
        department.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        department.setForeground(new Color(17, 80, 136));
        getContentPane().add(department);

        // Visiting ComboBox
        departmentBox = new JComboBox<>();
        departmentBox.setBounds(199, 130, 180, 22);
        getContentPane().add(departmentBox);
        departmentBox.addItem("None");
        System.out.println("Departments: " + Court.getInstance().getAllDepartments().keySet());
        for(Integer i: Court.getInstance().getAllDepartments().keySet()) {
        	  departmentBox.addItem(i);
        }



        // Check-In Button
        checkInButton = new JButton("Check In");
        checkInButton.setBounds(493, 310, 120, 30);
        checkInButton.setForeground(new Color(12, 3, 114));
        checkInButton.setBackground(new Color(192, 192, 192));
        getContentPane().add(checkInButton);
        
        judge = new JLabel("AllJudges");
        judge.setForeground(new Color(17, 80, 136));
        judge.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        judge.setBounds(32, 166, 133, 22);
        getContentPane().add(judge);
        
        judgeBox = new JComboBox<String>();
        judgeBox.setBounds(199, 168, 180, 22);
        getContentPane().add(judgeBox);
        judgeBox.addItem("None");
        for(int id : Court.getInstance().getAllLawyers().keySet()) {
 			if(Court.getInstance().getRealLawyer(id) instanceof Judge)
 				  judgeBox.addItem(id);
 	    }
        
        back = new JButton("Back");
        back.setForeground(new Color(12, 3, 114));
        back.setBackground(Color.LIGHT_GRAY);
        back.setBounds(26, 310, 120, 30);
        getContentPane().add(back);
        back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoUserNeeded ad = new NoUserNeeded();
				ad.setVisible(true);
				dispose();			 }
		});
 

        // Action Listener for Check-In
        checkInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String visitorName = nameField.getText().trim();
                String department= "None";
                String judge = "None";
                if(!departmentBox.getSelectedItem().equals("None")) {
                    department = ""+Court.getInstance().getRealDepartment((int)departmentBox.getSelectedItem()).getNumber();

                }
                if(!judgeBox.getSelectedItem().equals("None")) {
                    judge = ""+Court.getInstance().getRealJudge((int)judgeBox.getSelectedItem()).getId();
                }

                if (visitorName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a visitor name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Court.getInstance().addVisitor(visitorName, department, judge);

                JOptionPane.showMessageDialog(null, "Visitor " + visitorName + " checked in succefully"  , "Success", JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                SerializationHelp.saveCourt(Court.getInstance());
            }
        });
    }
}
