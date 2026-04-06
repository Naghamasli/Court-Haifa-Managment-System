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
import model.Judge;
import model.Testimony;
import model.Verdict;
import model.Witness;
import control.Court;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class AddTestimony extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addTestimonyLb;
	private JButton addBtn;
	private JButton clearBtn;
	private JComboBox caseBox;
	private JLabel content;
	private JLabel witness;
	private JComboBox witnessBox;
	private JTextPane contentTxt;
	
	public AddTestimony() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addTestimonyLb = new JLabel("Testimony");
		addTestimonyLb.setHorizontalAlignment(SwingConstants.CENTER);
		addTestimonyLb.setBounds(178, 27, 317, 34);
		addTestimonyLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addTestimonyLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addTestimonyLb);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(513, 438, 89, 23);
		addBtn.setForeground(new Color(12, 3, 114));
	    addBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(addBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setForeground(new Color(12, 3, 114));
		clearBtn.setBackground(new Color(192, 192, 192));
		clearBtn.setBounds(383, 438, 89, 23);
		getContentPane().add(clearBtn);
		// ActionListener for the "Clear" button
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
		
	    content = new JLabel("Content");
		content.setHorizontalAlignment(SwingConstants.LEFT);
		content.setForeground(new Color(17, 80, 136));
		content.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		content.setBounds(41, 101, 194, 28);
		getContentPane().add(content);
		
		JLabel caseLb = new JLabel("Case");
		caseLb.setHorizontalAlignment(SwingConstants.LEFT);
		caseLb.setForeground(new Color(17, 80, 136));
		caseLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseLb.setBounds(41, 244, 194, 28);
		getContentPane().add(caseLb);
		
		caseBox = new JComboBox();
		caseBox.setBounds(383, 249, 136, 22);
		getContentPane().add(caseBox);
		for(String id : Court.getInstance().getAllCases().keySet()) {
		       caseBox.addItem(id);
	    }
		
		
		witness = new JLabel("Witness");
		witness.setHorizontalAlignment(SwingConstants.LEFT);
		witness.setForeground(new Color(17, 80, 136));
		witness.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		witness.setBounds(41, 301, 194, 28);
		getContentPane().add(witness);
		
		witnessBox = new JComboBox();
		witnessBox.setBounds(383, 306, 136, 22);
		getContentPane().add(witnessBox);
		
		contentTxt = new JTextPane();
		contentTxt.setBounds(383, 109, 136, 129);
		getContentPane().add(contentTxt);
		for(Integer id : Court.getInstance().getAllWitnesses().keySet()) {
		       witnessBox.addItem(id);
	    }
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String content = contentTxt.getText();
            	Testimony t = null;
            	    	  
	                  	Case c = null;
	                	if(caseBox.getSelectedItem() != null) {
	                    	c = Court.getInstance().getRealCase((String) caseBox.getSelectedItem());
	                	}
	                	
	                	Witness w = null;
	                	if(witnessBox.getSelectedItem() != null) {
	                		w = Court.getInstance().getRealWitness((int)witnessBox.getSelectedItem());
	                	}
	                    
	                    t = new Testimony(c,content,w);
               try {
                    if(Court.getInstance().getAllTestimonies().containsValue(t)) {
                    	throw new ObjectAlreadyExistsException("Testimony");
                    }
                    if(contentTxt.getText().isEmpty()) {
                    	throw new FieldsAreNotFullExp();
                    }
                	Court.getInstance().addTestimony(t);
                    JOptionPane.showMessageDialog(null, "Testimony"+ t.getTestimonyID() +" added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } catch (ObjectAlreadyExistsException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (FieldsAreNotFullExp e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });

        
	}
    private void clearFields() {
    	contentTxt.setText("");
    }
}
