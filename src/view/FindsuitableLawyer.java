package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Exceptions.FieldsAreNotFullExp;
import Exceptions.FutureDateException;
import control.Court;
import model.Appeal;
import model.Case;
import model.CriminalCase;
import model.Department;
import model.Document;
import model.Employee;
import model.FamilyCase;
import model.FinancialCase;
import model.Lawyer;
import model.Meeting;
import model.Testimony;
import model.Verdict;

import javax.swing.JComboBox;
import javax.swing.JTextField;



public class FindsuitableLawyer extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFindASuitable;
	private JLabel date;
	private JButton find;
	private JLabel lawyer;
	private JTextField answerTxt;
	private JComboBox caseBox;

	public FindsuitableLawyer() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		lblFindASuitable = new JLabel("Find A Suitable Lawyer");
		lblFindASuitable.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindASuitable.setBounds(165, 33, 317, 34);
		lblFindASuitable.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblFindASuitable.setForeground(new Color(0, 64, 128));
		getContentPane().add(lblFindASuitable);
		
		date = new JLabel("Please Choose A Case");
		date.setBounds(94, 127, 202, 18);
		date.setHorizontalAlignment(SwingConstants.LEFT);
		date.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		date.setForeground(new Color(17, 80, 136));
		getContentPane().add(date);
		
		find = new JButton("Find");
		find.setBounds(507, 192, 89, 23);
		find.setForeground(new Color(12, 3, 114));
		find.setBackground(new Color(192, 192, 192));
		getContentPane().add(find);
		
		JButton clear = new JButton("Clear");
		clear.setForeground(new Color(12, 3, 114));
		clear.setBackground(Color.LIGHT_GRAY);
		clear.setBounds(507, 405, 89, 23);
		getContentPane().add(clear);
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	answerTxt.setText("");
            }
        });
		
		lawyer = new JLabel("The Lawyer");
		lawyer.setHorizontalAlignment(SwingConstants.LEFT);
		lawyer.setForeground(new Color(17, 80, 136));
		lawyer.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lawyer.setBounds(94, 278, 202, 18);
		getContentPane().add(lawyer);
		
		answerTxt = new JTextField();
		answerTxt.setColumns(10);
		answerTxt.setBounds(314, 279, 202, 20);
		getContentPane().add(answerTxt);
		answerTxt.setEditable(false);
		
		caseBox = new JComboBox();
		caseBox.setBounds(315, 127, 132, 22);
		getContentPane().add(caseBox);
		for(String i: Court.getInstance().getAllCases().keySet()) {
			      caseBox.addItem(i);
		}
	  
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Case fc = null;
				String s = (String)caseBox.getSelectedItem();
	            if(Court.getInstance().getRealCase(s)instanceof FamilyCase) {
	            	fc = Court.getInstance().getRealFamilyCase(s);
	            }
	            if(Court.getInstance().getRealCase(s)instanceof CriminalCase) {
	            	fc = Court.getInstance().getRealCriminalCase(s);
	            }
	            if(Court.getInstance().getRealCase(s) instanceof FinancialCase) {
	            	fc = Court.getInstance().getRealFinancialCase(s);
	            }
	            Lawyer l = Court.getInstance().findTheSuitableLawyer(fc);
	            answerTxt.setText(l.getId()+""+l.getFirstName()+""+l.getLastName());
			 }
		});
	}
}
