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



public class FindTheDifferenceBetweenCases extends JInternalFrame {

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

	public FindTheDifferenceBetweenCases() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		lblFindASuitable = new JLabel("Difference Between Longest And Shortest Case");
		lblFindASuitable.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindASuitable.setBounds(79, 33, 470, 34);
		lblFindASuitable.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblFindASuitable.setForeground(new Color(0, 64, 128));
		getContentPane().add(lblFindASuitable);
		
		date = new JLabel("Please Choose A Lawyer");
		date.setBounds(94, 127, 223, 22);
		date.setHorizontalAlignment(SwingConstants.LEFT);
		date.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		date.setForeground(new Color(17, 80, 136));
		getContentPane().add(date);
		
		find = new JButton("Calculate");
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
		
		lawyer = new JLabel("The Difference Is");
		lawyer.setHorizontalAlignment(SwingConstants.LEFT);
		lawyer.setForeground(new Color(17, 80, 136));
		lawyer.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lawyer.setBounds(94, 278, 202, 21);
		getContentPane().add(lawyer);
		
		answerTxt = new JTextField();
		answerTxt.setColumns(10);
		answerTxt.setBounds(354, 280, 106, 20);
		getContentPane().add(answerTxt);
		answerTxt.setEditable(false);
		
		caseBox = new JComboBox();
		caseBox.setBounds(350, 127, 132, 22);
		getContentPane().add(caseBox);
		for(int i: Court.getInstance().getAllLawyers().keySet()) {
			caseBox.addItem(i);
		}
	  
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lawyer l = Court.getInstance().getRealLawyer((int)caseBox.getSelectedItem());
				int answer = Court.getInstance().differenceBetweenTheLongestAndShortestCase(l);
	            answerTxt.setText(""+answer);
			 }
		});
	}
}
