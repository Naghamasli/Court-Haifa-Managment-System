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



public class HowManyCasesBefore extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JLabel date;
	private JButton show;
	private JTextField dateTxt;
	private JLabel amountOfCases;
	private JTextField answerTxt;

	public HowManyCasesBefore() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		label = new JLabel("How Many Cases Before");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(165, 33, 317, 34);
		label.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		label.setForeground(new Color(0, 64, 128));
		getContentPane().add(label);
		
		date = new JLabel("Please Choose A Date");
		date.setBounds(94, 127, 202, 18);
		date.setHorizontalAlignment(SwingConstants.LEFT);
		date.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		date.setForeground(new Color(17, 80, 136));
		getContentPane().add(date);
		
		show = new JButton("Show");
		show.setBounds(507, 192, 89, 23);
		show.setForeground(new Color(12, 3, 114));
		show.setBackground(new Color(192, 192, 192));
		getContentPane().add(show);
		
		dateTxt = new JTextField();
		dateTxt.setBounds(314, 128, 145, 20);
		getContentPane().add(dateTxt);
		dateTxt.setColumns(10);
		
		JButton clear = new JButton("Clear");
		clear.setForeground(new Color(12, 3, 114));
		clear.setBackground(Color.LIGHT_GRAY);
		clear.setBounds(507, 405, 89, 23);
		getContentPane().add(clear);
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dateTxt.setText("");
            	answerTxt.setText("");
            }
        });
		
		amountOfCases = new JLabel("The Amount Of Cases");
		amountOfCases.setHorizontalAlignment(SwingConstants.LEFT);
		amountOfCases.setForeground(new Color(17, 80, 136));
		amountOfCases.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		amountOfCases.setBounds(94, 278, 202, 18);
		getContentPane().add(amountOfCases);
		
		answerTxt = new JTextField();
		answerTxt.setColumns(10);
		answerTxt.setBounds(314, 279, 145, 20);
		getContentPane().add(answerTxt);
		answerTxt.setEditable(false);
	  
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	             String date= dateTxt.getText();
	             try {
	            	 if(dateTxt.getText().isEmpty())
	                	{
	                		throw new FieldsAreNotFullExp();
	                	}
	            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                     dateFormat.setLenient(false); // Ensures strict validation
                     
                    
                     Date birthDate = dateFormat.parse(date); // Parse the input
                     if (birthDate.after(Court.getInstance().TODAY)) { // Check if it's a future date
                             throw new FutureDateException();
                     }
                     int answer =  Court.getInstance().howManyCasesBefore(birthDate);
                     answerTxt.setText(""+answer);
	             }catch (FieldsAreNotFullExp e1) {
	                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
	                    return;
	             }catch (ParseException e2) {
                        JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                 }catch (FutureDateException e3) {
                        JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
			 }
		});
	}
}
