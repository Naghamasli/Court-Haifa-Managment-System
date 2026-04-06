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
import model.Accused;
import model.Appeal;
import model.Case;
import model.Courtroom;
import model.CriminalCase;
import model.Department;
import model.Document;
import model.FamilyCase;
import model.FinancialCase;
import model.Judge;
import model.Lawyer;
import model.Person;
import model.Verdict;
import control.Court;
import enums.Specialization;
import enums.Status;

import javax.swing.JComboBox;

public class AddFamilyCase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addFamilyCaseLb;
	private JButton addBtn;
	private JButton clearBtn;
	private JTextField dateTxt;
	private JComboBox specializationBox;
	private JLabel accused;
	private JLabel opedDate;
	private JLabel caseStatus;
	private JComboBox statusBox;
	private JLabel lawyer;
	private JComboBox lawyerBox;
	private JTextField relationTxt;
	
	public AddFamilyCase() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addFamilyCaseLb = new JLabel("Family Case");
		addFamilyCaseLb.setHorizontalAlignment(SwingConstants.CENTER);
		addFamilyCaseLb.setBounds(178, 27, 317, 34);
		addFamilyCaseLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addFamilyCaseLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addFamilyCaseLb);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(525, 463, 89, 23);
		addBtn.setForeground(new Color(12, 3, 114));
	    addBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(addBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setForeground(new Color(12, 3, 114));
		clearBtn.setBackground(new Color(192, 192, 192));
		clearBtn.setBounds(387, 463, 89, 23);
		getContentPane().add(clearBtn);
		// ActionListener for the "Clear" button
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
		
	    accused = new JLabel("Accused");
		accused.setHorizontalAlignment(SwingConstants.LEFT);
		accused.setForeground(new Color(17, 80, 136));
		accused.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		accused.setBounds(41, 101, 194, 28);
		getContentPane().add(accused);
		
		opedDate = new JLabel("Open date");
		opedDate.setHorizontalAlignment(SwingConstants.LEFT);
		opedDate.setForeground(new Color(17, 80, 136));
		opedDate.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		opedDate.setBounds(41, 140, 194, 28);
		getContentPane().add(opedDate);
		
		dateTxt = new JTextField();
		dateTxt.setForeground(new Color(0, 0, 51));
		dateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateTxt.setColumns(10);
		dateTxt.setBounds(383, 142, 136, 26);
		getContentPane().add(dateTxt);
		
		JLabel caseType = new JLabel("Case Type");
		caseType.setHorizontalAlignment(SwingConstants.LEFT);
		caseType.setForeground(new Color(17, 80, 136));
		caseType.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseType.setBounds(41, 218, 194, 28);
		getContentPane().add(caseType);
		
		specializationBox = new JComboBox(Specialization.values());
		specializationBox.setBounds(383, 223, 136, 22);
		getContentPane().add(specializationBox);
		
		caseStatus = new JLabel("Case Status");
		caseStatus.setHorizontalAlignment(SwingConstants.LEFT);
		caseStatus.setForeground(new Color(17, 80, 136));
		caseStatus.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseStatus.setBounds(41, 179, 194, 28);
		getContentPane().add(caseStatus);
		
		statusBox = new JComboBox(Status.values());
		statusBox.setBounds(383, 184, 136, 22);
		getContentPane().add(statusBox);
		
		lawyer = new JLabel("Lawyer");
		lawyer.setHorizontalAlignment(SwingConstants.LEFT);
		lawyer.setForeground(new Color(17, 80, 136));
		lawyer.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lawyer.setBounds(41, 253, 194, 28);
		getContentPane().add(lawyer);
		
		lawyerBox = new JComboBox();
		lawyerBox.setBounds(383, 259, 136, 22);
		getContentPane().add(lawyerBox);
		for(Integer id : Court.getInstance().getAllLawyers().keySet()) {
		       lawyerBox.addItem(id);
	    }
		
		JComboBox accusedBox = new JComboBox();
		accusedBox.setBounds(383, 106, 136, 22);
		getContentPane().add(accusedBox);
		for(Integer id : Court.getInstance().getAllAccuseds().keySet()) {
			accusedBox.addItem(id);
	    }
		
		JLabel verdict = new JLabel("Verdict");
		verdict.setHorizontalAlignment(SwingConstants.LEFT);
		verdict.setForeground(new Color(17, 80, 136));
		verdict.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		verdict.setBounds(41, 295, 194, 28);
		getContentPane().add(verdict);
		
		JLabel victim = new JLabel("Victim");
		victim.setHorizontalAlignment(SwingConstants.LEFT);
		victim.setForeground(new Color(17, 80, 136));
		victim.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		victim.setBounds(41, 334, 194, 28);
		getContentPane().add(victim);
		
		JLabel relationType = new JLabel("Relation Type");
		relationType.setHorizontalAlignment(SwingConstants.LEFT);
		relationType.setForeground(new Color(17, 80, 136));
		relationType.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		relationType.setBounds(41, 377, 194, 28);
		getContentPane().add(relationType);
		
		JComboBox verdictBox = new JComboBox();
		verdictBox.setBounds(383, 300, 136, 22);
		getContentPane().add(verdictBox);
		verdictBox.addItem("None");
		for(Integer id : Court.getInstance().getAllVerdicts().keySet()) {
			verdictBox.addItem(id);
	    }
		
		relationTxt = new JTextField();
		relationTxt.setForeground(new Color(0, 0, 51));
		relationTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		relationTxt.setColumns(10);
		relationTxt.setBounds(383, 377, 136, 26);
		getContentPane().add(relationTxt);
		
		JComboBox victimBox = new JComboBox();
		victimBox.setBounds(383, 339, 136, 22);
		getContentPane().add(victimBox);
		for(Integer id : Court.getInstance().getAllWitnesses().keySet()) {
			victimBox.addItem(id);
	    }
		
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String open = dateTxt.getText();
            	String relation = relationTxt.getText();
            	FamilyCase fc = null;
            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // Ensures strict validation
            	Date issue = null;
            	Specialization sp=null;
            	Status s=null;
            	Accused a = null;
            	Lawyer l = null;
            	Verdict v = null;
            	Person p = null;

            	
            	  try {
	                	 // Parse the input
	                    	issue = dateFormat.parse(open);
	                      if (issue.after(Court.getInstance().TODAY)) { // Check if it's a future date
	                              throw new FutureDateException();
	                      }
	                      sp = (Specialization) specializationBox.getSelectedItem();
	                      s = (Status) statusBox.getSelectedItem();

	                	if(accusedBox.getSelectedItem() != null) {
	                     	a = Court.getInstance().getRealAccused((int)accusedBox.getSelectedItem());
	                	}
	                	if(lawyerBox.getSelectedItem() != null) {
	                		if(lawyerBox.getSelectedItem().equals("None")) {
	                			l=null;
	                		}else {
		                     	l = Court.getInstance().getRealLawyer((int)lawyerBox.getSelectedItem());
	                		}
	                	}
	                	if(verdictBox.getSelectedItem() != null) {
	                		if(verdictBox.getSelectedItem().equals("None")) {
	                			v=null;
	                		}else {
		                     	v = Court.getInstance().getRealVerdict((int)verdictBox.getSelectedItem());
	                		}
	                	}
	                	if(victimBox.getSelectedItem() != null) {
	                     	p = Court.getInstance().getRealWitness((int)victimBox.getSelectedItem());
	                	}
	                    

            	  }catch (ParseException e2) {
                      JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                  } catch (FutureDateException e3) {
                      JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                  }
            	  
               try {
                    if(Court.getInstance().getAllCases().containsValue(fc)) {
                    	throw new ObjectAlreadyExistsException("Family Case");
                    }
                    if(relationTxt.getText().isEmpty() || dateTxt.getText().isEmpty() || relationTxt.getText().isEmpty()) {
                    	throw new FieldsAreNotFullExp();
                    }
                    fc = new FamilyCase(a,issue,s,sp,l,v,p,relation);
                	Court.getInstance().addFamilyCase(fc);
                    JOptionPane.showMessageDialog(null, fc.getCode()+ " added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
    	relationTxt.setText("");
    	dateTxt.setText("");
    	relationTxt.setText("");
    }
}
