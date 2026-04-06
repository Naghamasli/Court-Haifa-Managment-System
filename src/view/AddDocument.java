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
import model.Case;
import model.Courtroom;
//import Exceptions.DepartmentAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Department;
import model.Document;
import model.Judge;
import control.Court;
import enums.Status;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class AddDocument extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addDocumemntLb;
	private JButton addBtn;
	private JButton clearBtn;
	private JLabel title;
	private JTextField titeleTxt;
	private JTextField dateTxt;
	private JComboBox caseBox;
	private JLabel content;
	private JLabel issusedDate;
	private JTextPane contentTxt;
	
	public AddDocument(int user) {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addDocumemntLb = new JLabel("Document");
		addDocumemntLb.setHorizontalAlignment(SwingConstants.CENTER);
		addDocumemntLb.setBounds(178, 27, 317, 34);
		addDocumemntLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addDocumemntLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addDocumemntLb);
		
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
		
		title = new JLabel("Title");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setForeground(new Color(17, 80, 136));
		title.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		title.setBounds(41, 112, 194, 28);
		getContentPane().add(title);
		
		titeleTxt = new JTextField();
		titeleTxt.setForeground(new Color(0, 0, 51));
		titeleTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titeleTxt.setColumns(10);
		titeleTxt.setBounds(383, 114, 136, 26);
		getContentPane().add(titeleTxt);
		
	    content = new JLabel("Content");
		content.setHorizontalAlignment(SwingConstants.LEFT);
		content.setForeground(new Color(17, 80, 136));
		content.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		content.setBounds(41, 153, 194, 28);
		getContentPane().add(content);
		
		issusedDate = new JLabel("Issued Date");
		issusedDate.setHorizontalAlignment(SwingConstants.LEFT);
		issusedDate.setForeground(new Color(17, 80, 136));
		issusedDate.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		issusedDate.setBounds(41, 281, 194, 28);
		getContentPane().add(issusedDate);
		
		dateTxt = new JTextField();
		dateTxt.setForeground(new Color(0, 0, 51));
		dateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateTxt.setColumns(10);
		dateTxt.setBounds(383, 287, 136, 26);
		getContentPane().add(dateTxt);
		
		JLabel caseLb = new JLabel("Case");
		caseLb.setHorizontalAlignment(SwingConstants.LEFT);
		caseLb.setForeground(new Color(17, 80, 136));
		caseLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseLb.setBounds(41, 337, 194, 28);
		getContentPane().add(caseLb);
		
		caseBox = new JComboBox();
		caseBox.setBounds(383, 342, 136, 22);
		getContentPane().add(caseBox);
		
		contentTxt = new JTextPane();
		contentTxt.setBounds(383, 161, 136, 115);
		getContentPane().add(contentTxt);
        if(Court.getInstance().getAllLawyers().containsKey(user)) {
        	if(Court.getInstance().getRealLawyer(user) instanceof Judge) {
        		for (String i : Court.getInstance().getAllCases().keySet()) {
                		if(Court.getInstance().getRealJudge(user).getCasesPresided().contains(Court.getInstance().getRealCriminalCase(i))) {
                			caseBox.addItem(i);
                		}
                	
        	    }
             }else {
            	 for (String i : Court.getInstance().getAllCases().keySet()) {
                 		if(Court.getInstance().getRealCriminalCase(i).getLawyer().getId() == user) {
                 			if(Court.getInstance().getRealCriminalCase(i).getCaseStatus().equals(Status.inProcess))
                 			     caseBox.addItem(i);
                 		}
                  }
             }
        }else {
        	 for (String i : Court.getInstance().getAllCases().keySet()) {
             		caseBox.addItem(i);
             }
       }
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String title = titeleTxt.getText();
            	String content = contentTxt.getText();
            	String issueDate = dateTxt.getText();
            	Document d = null;
            	  try {
	                	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                    dateFormat.setLenient(false); // Ensures strict validation
	                	Date issue = dateFormat.parse(issueDate); // Parse the input
	                      if (issue.after(Court.getInstance().TODAY)) { // Check if it's a future date
	                              throw new FutureDateException();
	                      }
	                      
	                  	Case c = null;
	                	if(caseBox.getSelectedItem() != null) {
	                    	c = Court.getInstance().getRealCase((String) caseBox.getSelectedItem());
	                	}
	                    
	                    d = new Document(title, content,issue, c);
	                    if(Court.getInstance().getAllDocuments().containsValue(d)) {
	                    	throw new ObjectAlreadyExistsException("Document");
	                    }
	                    if(titeleTxt.getText().isEmpty() || contentTxt.getText().isEmpty() || dateTxt.getText().isEmpty()) {
	                    	throw new FieldsAreNotFullExp();
	                    }
	                	Court.getInstance().addDocument(d);
	                    JOptionPane.showMessageDialog(null, "Document "+ d.getCode() +" added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    clearFields();

            	  }catch (ParseException e2) {
                      JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                  } catch (FutureDateException e3) {
                      JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    	titeleTxt.setText("");
    	contentTxt.setText("");
    	dateTxt.setText("");
    }
}
