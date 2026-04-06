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
import model.Verdict;
import control.Court;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class AppealApplication extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addAppealLb;
	private JButton addBtn;
	private JButton clearBtn;
	private JTextField dateTxt;
	private JComboBox newBox;
	private JLabel summery;
	private JLabel appealDate;
	private JLabel currentVerdict;
	private JComboBox verdictBox;
	private JTextPane summeryTxt;
	
	public AppealApplication() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addAppealLb = new JLabel("Appeal");
		addAppealLb.setHorizontalAlignment(SwingConstants.CENTER);
		addAppealLb.setBounds(178, 27, 317, 34);
		addAppealLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addAppealLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addAppealLb);
		
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
		
	    summery = new JLabel("Summery");
		summery.setHorizontalAlignment(SwingConstants.LEFT);
		summery.setForeground(new Color(17, 80, 136));
		summery.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		summery.setBounds(41, 101, 194, 28);
		getContentPane().add(summery);
		
		appealDate = new JLabel("Appeal Date");
		appealDate.setHorizontalAlignment(SwingConstants.LEFT);
		appealDate.setForeground(new Color(17, 80, 136));
		appealDate.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		appealDate.setBounds(41, 255, 194, 28);
		getContentPane().add(appealDate);
		
		dateTxt = new JTextField();
		dateTxt.setForeground(new Color(0, 0, 51));
		dateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateTxt.setColumns(10);
		dateTxt.setBounds(383, 255, 136, 26);
		getContentPane().add(dateTxt);
		
		JLabel newVerdict = new JLabel("New Verdict");
		newVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		newVerdict.setForeground(new Color(17, 80, 136));
		newVerdict.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		newVerdict.setBounds(41, 337, 194, 28);
		getContentPane().add(newVerdict);
		
		newBox = new JComboBox();
		newBox.setBounds(383, 342, 136, 22);
		getContentPane().add(newBox);
		for(Integer id : Court.getInstance().getAllVerdicts().keySet()) {
		       newBox.addItem(id);
	    }
		
		currentVerdict = new JLabel("Current Verdict");
		currentVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		currentVerdict.setForeground(new Color(17, 80, 136));
		currentVerdict.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		currentVerdict.setBounds(41, 298, 194, 28);
		getContentPane().add(currentVerdict);
		
		verdictBox = new JComboBox();
		verdictBox.setBounds(383, 303, 136, 22);
		getContentPane().add(verdictBox);
		
		summeryTxt = new JTextPane();
		summeryTxt.setBounds(383, 101, 136, 143);
		getContentPane().add(summeryTxt);
		for(Integer id : Court.getInstance().getAllVerdicts().keySet()) {
			verdictBox.addItem(id);
	    }
		
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String summery = summeryTxt.getText();
            	String appealDate = dateTxt.getText();
            	Appeal p = null;
            	  try {
	                	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                    dateFormat.setLenient(false); // Ensures strict validation
	                	Date issue = dateFormat.parse(appealDate); // Parse the input
	                      if (issue.after(Court.getInstance().TODAY)) { // Check if it's a future date
	                              throw new FutureDateException();
	                      }
	                      
	                  	Verdict nv = null;
	                	if(newBox.getSelectedItem() != null) {
	                    	nv = Court.getInstance().getRealVerdict((int) newBox.getSelectedItem());
	                	}
	                	Verdict cv = null;
	                	if(verdictBox.getSelectedItem() != null) {
	                		cv = Court.getInstance().getRealVerdict((int)verdictBox.getSelectedItem());
	                	}
	                	
	                    
	                    p = new Appeal(summery,issue,cv, nv);

            	  }catch (ParseException e2) {
                      JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                  } catch (FutureDateException e3) {
                      JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                  }
            	  
               try {
                    if(Court.getInstance().getAllAppeals().containsValue(p)) {
                    	throw new ObjectAlreadyExistsException("Appeal");
                    }
                    if(summeryTxt.getText().isEmpty() || dateTxt.getText().isEmpty()) {
                    	throw new FieldsAreNotFullExp();
                    }
                	Court.getInstance().getAppealApps().put(p.getAppealID(), p);
                    JOptionPane.showMessageDialog(null, "Appeal "+p.getAppealID()+" application submited succefully", "Success", JOptionPane.INFORMATION_MESSAGE);
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
    	summeryTxt.setText("");
    	dateTxt.setText("");
    }
}
