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
//import Exceptions.caseAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Document;
import model.Employee;
import model.Lawyer;
import model.Lawyer;
import model.Verdict;
import model.Case;
import control.Court;

import javax.swing.JComboBox;

public class AddLawyerToCase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addLawyerToCase;
	private JButton addBtn;
	private JButton clearBtn;
	private JComboBox caseBox;
	private JLabel lawyer;
	private JComboBox lawyerBox;
	
	public AddLawyerToCase() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addLawyerToCase = new JLabel("Add lawyer to Case");
		addLawyerToCase.setHorizontalAlignment(SwingConstants.CENTER);
		addLawyerToCase.setBounds(178, 27, 317, 34);
		addLawyerToCase.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addLawyerToCase.setForeground(new Color(0, 64, 128));
		getContentPane().add(addLawyerToCase);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(513, 438, 89, 23);
		addBtn.setForeground(new Color(12, 3, 114));
	    addBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(addBtn);
		
		
		JLabel caseL = new JLabel("Case");
		caseL.setHorizontalAlignment(SwingConstants.LEFT);
		caseL.setForeground(new Color(17, 80, 136));
		caseL.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseL.setBounds(134, 146, 194, 28);
		getContentPane().add(caseL);
		
		caseBox = new JComboBox();
		caseBox.setBounds(383, 151, 136, 22);
		getContentPane().add(caseBox);
		for(String id : Court.getInstance().getAllCases().keySet()) {
		       caseBox.addItem(id);
	    }
		
		lawyer = new JLabel("lawyer");
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
            	
	                  	Case d = null;
	                	if(caseBox.getSelectedItem() != null) {
	                    	d = Court.getInstance().getRealCase((String) caseBox.getSelectedItem());
	                	}
	                	Lawyer emp = null;
	                	if(lawyerBox.getSelectedItem() != null) {
	                		emp = Court.getInstance().getRealLawyer((int)lawyerBox.getSelectedItem());
	                	}
	                	 
	                	d.setLawyer(emp);
	                    JOptionPane.showMessageDialog(null, "Lawyer "+ emp.getFirstName() +" added to case "+d.getCode()+" successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

 
            }
            
        });

        
	}
}
