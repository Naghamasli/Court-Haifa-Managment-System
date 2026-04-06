package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Court;
import model.Accused;
import model.Appeal;
import model.Department;
import model.Document;
import model.Employee;
import model.Lawyer;
import model.Meeting;
import model.Testimony;
import model.Verdict;

import javax.swing.JComboBox;
import javax.swing.JFrame;



public class NoUserNeeded extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel removeLb;
	private JLabel allChoices;
	private JButton back;
	private JButton btnGo;
	private JLabel allChoices_1;
	private JButton btnGo_1;

	public NoUserNeeded() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		removeLb = new JLabel("Choose activity");
		removeLb.setHorizontalAlignment(SwingConstants.CENTER);
		removeLb.setBounds(23, 35, 317, 34);
		removeLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		removeLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(removeLb);
		
		allChoices = new JLabel("Visitor check-In");
		allChoices.setBounds(40, 127, 133, 18);
		allChoices.setHorizontalAlignment(SwingConstants.LEFT);
		allChoices.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		allChoices.setForeground(new Color(17, 80, 136));
		getContentPane().add(allChoices);
		
		back = new JButton("Back");
		back.setBounds(509, 404, 89, 23);
		back.setForeground(new Color(12, 3, 114));
		back.setBackground(new Color(192, 192, 192));
		getContentPane().add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ad = new Login();
				ad.setVisible(true);
				dispose();
			 }
		});
		
		btnGo = new JButton("go");
		btnGo.setForeground(new Color(12, 3, 114));
		btnGo.setBackground(Color.LIGHT_GRAY);
		btnGo.setBounds(246, 127, 89, 23);
		getContentPane().add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitorsCheckIn ad = new VisitorsCheckIn();
				ad.setVisible(true);
				dispose();
			 }
		});
		
		allChoices_1 = new JLabel("Add tetimony");
		allChoices_1.setHorizontalAlignment(SwingConstants.LEFT);
		allChoices_1.setForeground(new Color(17, 80, 136));
		allChoices_1.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		allChoices_1.setBounds(40, 171, 133, 18);
		getContentPane().add(allChoices_1);
		
		btnGo_1 = new JButton("go");
		btnGo_1.setForeground(new Color(12, 3, 114));
		btnGo_1.setBackground(Color.LIGHT_GRAY);
		btnGo_1.setBounds(246, 171, 89, 23);
		getContentPane().add(btnGo_1);
		btnGo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestimonyAddFrame ad = new TestimonyAddFrame();
				ad.setVisible(true);
				dispose();
			 }
		});
	    
		
		
	}

}
