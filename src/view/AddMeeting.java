package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
import model.Meeting;
import model.Verdict;
import control.Court;
import enums.Status;

import javax.swing.JComboBox;

public class AddMeeting extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addMeetingLb;
	private JButton addBtn;
	private JButton clearBtn;
	private JTextField dateTxt;
	private JComboBox caseBox;
	private JLabel meetingDate;
	private JLabel hour;
	private JLabel courtroom;
	private JComboBox courtroomBox;
	private JTextField timeTxt;
	
	public AddMeeting(int user) {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addMeetingLb = new JLabel("Meeting");
		addMeetingLb.setHorizontalAlignment(SwingConstants.CENTER);
		addMeetingLb.setBounds(178, 27, 317, 34);
		addMeetingLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addMeetingLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addMeetingLb);
		
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
		
		meetingDate = new JLabel("Meeting Date");
		meetingDate.setHorizontalAlignment(SwingConstants.LEFT);
		meetingDate.setForeground(new Color(17, 80, 136));
		meetingDate.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		meetingDate.setBounds(41, 90, 194, 28);
		getContentPane().add(meetingDate);
		
		dateTxt = new JTextField();
		dateTxt.setForeground(new Color(0, 0, 51));
		dateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateTxt.setColumns(10);
		dateTxt.setBounds(383, 92, 136, 26);
		getContentPane().add(dateTxt);
		
		JLabel caseLb = new JLabel("Case");
		caseLb.setHorizontalAlignment(SwingConstants.LEFT);
		caseLb.setForeground(new Color(17, 80, 136));
		caseLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseLb.setBounds(41, 168, 194, 28);
		getContentPane().add(caseLb);
		
		caseBox = new JComboBox();
		caseBox.setBounds(383, 173, 136, 22);
		getContentPane().add(caseBox);
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
		
		hour = new JLabel("Hour");
		hour.setHorizontalAlignment(SwingConstants.LEFT);
		hour.setForeground(new Color(17, 80, 136));
		hour.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		hour.setBounds(41, 129, 194, 28);
		getContentPane().add(hour);
		
		
		courtroom = new JLabel("CourtRoom");
		courtroom.setHorizontalAlignment(SwingConstants.LEFT);
		courtroom.setForeground(new Color(17, 80, 136));
		courtroom.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		courtroom.setBounds(41, 207, 194, 28);
		getContentPane().add(courtroom);
		
		courtroomBox = new JComboBox();
		courtroomBox.setBounds(383, 212, 136, 22);
		getContentPane().add(courtroomBox);
		for(Integer id : Court.getInstance().getAllCourtrooms().keySet()) {
		       courtroomBox.addItem(id);
	    }
		
		timeTxt = new JTextField();
		timeTxt.setForeground(new Color(0, 0, 51));
		timeTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timeTxt.setColumns(10);
		timeTxt.setBounds(383, 135, 136, 26);
		getContentPane().add(timeTxt);
		
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String issueDate = dateTxt.getText();
            	String hour = timeTxt.getText();
            	Meeting m = null;
            	  try {
	                	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                    dateFormat.setLenient(false); // Ensures strict validation
	                	Date issue = dateFormat.parse(issueDate); // Parse the input
	                      LocalTime localTime = LocalTime.of(Integer.parseInt(hour), 0); // Minutes set to 0
	                      // Convert to SQL Time
	                      Time time = Time.valueOf(localTime);
	                      
	                  	Case c = null;
	                	if(caseBox.getSelectedItem() != null) {
	                    	c = Court.getInstance().getRealCase((String) caseBox.getSelectedItem());
	                	}
	              
	                	Courtroom a = null;
	                	if(courtroomBox.getSelectedItem() != null) {
	                		a = Court.getInstance().getRealCourtroom((int)courtroomBox.getSelectedItem());;
	                				
	                	}
	                    
	                    m = new Meeting(issue,time,a,c);

            	  }catch (ParseException e2) {
                      JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                  } 
            	  
               try {
                    if(Court.getInstance().getAllMeetings().containsValue(m)) {
                    	throw new ObjectAlreadyExistsException("Verdict");
                    }
                    if(timeTxt.getText().isEmpty() || dateTxt.getText().isEmpty()) {
                    	throw new FieldsAreNotFullExp();
                    }
                	Court.getInstance().addMeeting(m);
                    JOptionPane.showMessageDialog(null, "Meeting "+ m.getMeetingID() +" added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
    	timeTxt.setText("");
    	dateTxt.setText("");
    }
}
