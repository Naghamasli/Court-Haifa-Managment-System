package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Exceptions.FieldsAreNotFullExp;
import Exceptions.FutureDateException;
import control.Court;
import model.Appeal;
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



public class FamilyCasesWithBothSideWitnesses extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton show;

	public FamilyCasesWithBothSideWitnesses() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		label = new JLabel("Family Cases With Witnesses On Both Sides");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(94, 33, 442, 34);
		label.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		label.setForeground(new Color(0, 64, 128));
		getContentPane().add(label);
		
		show = new JButton("Show");
		show.setBounds(273, 122, 89, 23);
		show.setForeground(new Color(12, 3, 114));
		show.setBackground(new Color(192, 192, 192));
		getContentPane().add(show);
		
		JButton clear = new JButton("Clear");
		clear.setForeground(new Color(12, 3, 114));
		clear.setBackground(Color.LIGHT_GRAY);
		clear.setBounds(533, 465, 89, 23);
		getContentPane().add(clear);
		
		JTextPane answerTxt = new JTextPane();
		answerTxt.setBounds(38, 216, 584, 227);
		getContentPane().add(answerTxt);
		answerTxt.setEditable(false);
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	answerTxt.setText("");
            }
        });
	  
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<FamilyCase> answer = Court.getInstance().findFamilyCasesWithWitnessesFromBothSides();
				answerTxt.setText(""+answer);
	           
			 }
		});
	}
}
