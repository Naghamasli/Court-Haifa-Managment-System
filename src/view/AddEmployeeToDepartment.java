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
import model.Verdict;
import control.Court;

import javax.swing.JComboBox;

public class AddEmployeeToDepartment extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addEmployeeToDepartmentlb;
	private JButton addBtn;
	private JButton clearBtn;
	private JComboBox departmentBox;
	private JLabel employee;
	private JComboBox employeeBox;
	
	public AddEmployeeToDepartment() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addEmployeeToDepartmentlb = new JLabel("Add Employee to Department");
		addEmployeeToDepartmentlb.setHorizontalAlignment(SwingConstants.CENTER);
		addEmployeeToDepartmentlb.setBounds(178, 27, 317, 34);
		addEmployeeToDepartmentlb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addEmployeeToDepartmentlb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addEmployeeToDepartmentlb);
		
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
		
		employee = new JLabel("Employee");
		employee.setHorizontalAlignment(SwingConstants.LEFT);
		employee.setForeground(new Color(17, 80, 136));
		employee.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		employee.setBounds(134, 101, 194, 28);
		getContentPane().add(employee);
		
		employeeBox = new JComboBox();
		employeeBox.setBounds(383, 106, 136, 22);
		getContentPane().add(employeeBox);
		for(int id : Court.getInstance().getAllEmployees().keySet()) {
		    	employeeBox.addItem(id);
	    }
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
	                  	Department d = null;
	                	if(departmentBox.getSelectedItem() != null) {
	                    	d = Court.getInstance().getRealDepartment((int) departmentBox.getSelectedItem());
	                	}
	                	Employee emp = null;
	                	if(employeeBox.getSelectedItem() != null) {
	                		emp = Court.getInstance().getRealEmployee((int)employeeBox.getSelectedItem());
	                	}
	                	 
	                	Court.getInstance().addEmployeeToDepartment(d, emp);
	                    JOptionPane.showMessageDialog(null, "Employee "+ emp.getLastName() +" added to department "+d.getNumber()+" successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

 
            }
            
        });

        
	}
}
