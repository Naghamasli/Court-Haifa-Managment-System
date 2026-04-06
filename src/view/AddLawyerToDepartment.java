package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Exceptions.CourtRoomAlreadyExistsExp;
import Exceptions.FieldsAreNotFullExp;
import Exceptions.FutureDateException;
import Exceptions.IdCannotBeNullExp;
import Exceptions.ObjectAlreadyExistsException;
import model.Appeal;
import model.Case;
import model.Courtroom;
//import Exceptions.DepartmentAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Department;
import model.Document;
import model.Employee;
import model.Judge;
import model.Lawyer;
import model.Verdict;
import control.Court;

import javax.swing.JComboBox;

public class AddLawyerToDepartment extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addLawyerToDepartmentlb;
	private JButton addBtn;
	private JButton clearBtn;
	private JComboBox departmentBox;
	private JLabel lawyer;
	private JComboBox lawyerBox;
	
	public AddLawyerToDepartment() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addLawyerToDepartmentlb = new JLabel("Add Lawyer to Department");
		addLawyerToDepartmentlb.setHorizontalAlignment(SwingConstants.CENTER);
		addLawyerToDepartmentlb.setBounds(178, 27, 317, 34);
		addLawyerToDepartmentlb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addLawyerToDepartmentlb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addLawyerToDepartmentlb);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(513, 438, 89, 23);
		addBtn.setForeground(new Color(12, 3, 114));
	    addBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(addBtn);
		
		
		JLabel department = new JLabel("Department");
		department.setHorizontalAlignment(SwingConstants.LEFT);
		department.setForeground(new Color(17, 80, 136));
		department.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		department.setBounds(134, 146, 194, 28);
		getContentPane().add(department);
		
		departmentBox = new JComboBox();
		departmentBox.setBounds(383, 151, 136, 22);
		getContentPane().add(departmentBox);
		for(Integer id : Court.getInstance().getAllDepartments().keySet()) {
		       departmentBox.addItem(id);
	    }
		
		lawyer = new JLabel("Lawyer");
		lawyer.setHorizontalAlignment(SwingConstants.LEFT);
		lawyer.setForeground(new Color(17, 80, 136));
		lawyer.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lawyer.setBounds(134, 101, 194, 28);
		getContentPane().add(lawyer);
		
		lawyerBox = new JComboBox();
		lawyerBox.setBounds(383, 106, 136, 22);
		getContentPane().add(lawyerBox);
		for(int id : Court.getInstance().getAllLawyers().keySet()) {
		    	lawyerBox.addItem(id);
	    }
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
	                  	Department d = null;
	                	if(departmentBox.getSelectedItem() != null) {
	                    	d = Court.getInstance().getRealDepartment((int) departmentBox.getSelectedItem());
	                	}
	                	Lawyer emp = null;
	                	if(lawyerBox.getSelectedItem() != null) {
	                		emp = Court.getInstance().getRealLawyer((int)lawyerBox.getSelectedItem());
	                	}
	                	 
	                	Court.getInstance().addLawyerToDepartment(d, emp);
	                    JOptionPane.showMessageDialog(null, "Lawyer "+ emp.getFirstName() +" added to department "+d.getNumber()+" successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

 
            }
            
        });

        
	}
}
