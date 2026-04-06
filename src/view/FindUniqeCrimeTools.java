package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Exceptions.FieldsAreNotFullExp;
import Exceptions.FutureDateException;
import control.Court;
import enums.Gender;
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
import javax.swing.JTextPane;
import javax.swing.JTextArea;



public class FindUniqeCrimeTools extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFindASuitable;
	private JLabel gender;
	private JButton find;
	private JLabel cases;
	private JTextArea answerTxt;
	private JTextField textField;

	public FindUniqeCrimeTools() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		lblFindASuitable = new JLabel("Crime Tools By Crime Scene");
		lblFindASuitable.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindASuitable.setBounds(32, 33, 564, 34);
		lblFindASuitable.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblFindASuitable.setForeground(new Color(0, 64, 128));
		getContentPane().add(lblFindASuitable);
		
		gender = new JLabel("Please Write A Crime Scene");
		gender.setBounds(94, 127, 230, 18);
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		gender.setForeground(new Color(17, 80, 136));
		getContentPane().add(gender);
		
		find = new JButton("Find");
		find.setBounds(507, 192, 89, 23);
		find.setForeground(new Color(12, 3, 114));
		find.setBackground(new Color(192, 192, 192));
		getContentPane().add(find);
		
		JButton clear = new JButton("Clear");
		clear.setForeground(new Color(12, 3, 114));
		clear.setBackground(Color.LIGHT_GRAY);
		clear.setBounds(547, 477, 89, 23);
		getContentPane().add(clear);
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	answerTxt.setText("");
            }
        });
		
		cases = new JLabel("The Crime Tools");
		cases.setHorizontalAlignment(SwingConstants.LEFT);
		cases.setForeground(new Color(17, 80, 136));
		cases.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		cases.setBounds(46, 238, 436, 18);
		getContentPane().add(cases);
		
		answerTxt = new JTextArea();
		answerTxt.setBounds(42, 285, 594, 164);
		getContentPane().add(answerTxt);
		answerTxt.setEditable(false);
		
		textField = new JTextField();
		textField.setBounds(361, 128, 121, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	  
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				Set<String> tool = Court.getInstance().findUniqueCrimeToolsByCrimeScene(s);
				if(tool != null) {
		            answerTxt.setText(tool.toString());
				}else {
		            answerTxt.setText("No Crime scene matches the given one");
				}
			 }
		});
	}
}
