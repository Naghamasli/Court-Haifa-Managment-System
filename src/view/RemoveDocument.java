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
import model.Department;
import model.Document;
import model.Employee;
import model.Lawyer;

import javax.swing.JComboBox;



public class RemoveDocument extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel removeLb;
	private JLabel allChoices;
	private JButton removeBtn;
	private JComboBox choiceBox;

	public RemoveDocument() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		removeLb = new JLabel("Remove Document");
		removeLb.setHorizontalAlignment(SwingConstants.CENTER);
		removeLb.setBounds(165, 33, 317, 34);
		removeLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		removeLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(removeLb);
		
		allChoices = new JLabel("All Document");
		allChoices.setBounds(163, 127, 133, 18);
		allChoices.setHorizontalAlignment(SwingConstants.LEFT);
		allChoices.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		allChoices.setForeground(new Color(17, 80, 136));
		getContentPane().add(allChoices);
		
		removeBtn = new JButton("Remove");
		removeBtn.setBounds(509, 404, 89, 23);
		removeBtn.setForeground(new Color(12, 3, 114));
		removeBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(removeBtn);
		
		choiceBox = new JComboBox();
		choiceBox.setBounds(358, 127, 107, 22);
		getContentPane().add(choiceBox);
	    for(int id: Court.getInstance().getAllDocuments().keySet())
		{	
				choiceBox.addItem(id);
		}
		
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document d = Court.getInstance().getRealDocument((int) choiceBox.getSelectedItem());
				if(Court.getInstance().removeDocument(d) == true)
				{
                    JOptionPane.showMessageDialog(null, "Document removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    choiceBox.removeItem(d.getCode());
				}
			 }
		});
	}

}
