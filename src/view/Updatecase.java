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
import model.FinancialCase;
import model.Judge;
import model.Lawyer;
import model.Person;
import model.Verdict;
import control.Court;
import enums.Specialization;
import enums.Status;

import javax.swing.JComboBox;

public class Updatecase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel updateCaseLb;
	private JButton doneBtn;
	private JButton clearBtn;
	private JTextField dateTxt;
	private JComboBox specializationBox;
	private JLabel accused;
	private JLabel opedDate;
	private JLabel caseStatus;
	private JComboBox statusBox;
	private JLabel lawyer;
	private JComboBox lawyerBox;
	private JTextField sceneTxt;
	private JTextField toolTxt;
	private JComboBox victimBox;
	private JLabel cases;
	private JComboBox caseBox;
	private JButton showBtn;
	
	public Updatecase() {
		setBounds(100, 100, 801, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		updateCaseLb = new JLabel("Update Criminal Case");
		updateCaseLb.setHorizontalAlignment(SwingConstants.CENTER);
		updateCaseLb.setBounds(226, 22, 317, 34);
		updateCaseLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		updateCaseLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(updateCaseLb);
		
		doneBtn = new JButton("Update");
		doneBtn.setBounds(525, 463, 89, 23);
		doneBtn.setForeground(new Color(12, 3, 114));
	    doneBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(doneBtn);
		
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
		accused.setBounds(41, 134, 194, 28);
		getContentPane().add(accused);
		
		opedDate = new JLabel("Open date");
		opedDate.setHorizontalAlignment(SwingConstants.LEFT);
		opedDate.setForeground(new Color(17, 80, 136));
		opedDate.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		opedDate.setBounds(41, 173, 194, 28);
		getContentPane().add(opedDate);
		
		dateTxt = new JTextField();
		dateTxt.setForeground(new Color(0, 0, 51));
		dateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateTxt.setColumns(10);
		dateTxt.setBounds(245, 175, 136, 26);
		getContentPane().add(dateTxt);
		dateTxt.setEditable(false);
		
		JLabel caseType = new JLabel("Case Type");
		caseType.setHorizontalAlignment(SwingConstants.LEFT);
		caseType.setForeground(new Color(17, 80, 136));
		caseType.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseType.setBounds(41, 252, 194, 28);
		getContentPane().add(caseType);
		
		specializationBox = new JComboBox(Specialization.values());
		specializationBox.setBounds(245, 257, 136, 22);
		getContentPane().add(specializationBox);
		
		caseStatus = new JLabel("Case Status");
		caseStatus.setHorizontalAlignment(SwingConstants.LEFT);
		caseStatus.setForeground(new Color(17, 80, 136));
		caseStatus.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseStatus.setBounds(41, 212, 194, 28);
		getContentPane().add(caseStatus);
		
		statusBox = new JComboBox(Status.values());
		statusBox.setBounds(245, 217, 136, 22);
		getContentPane().add(statusBox);
		
		lawyer = new JLabel("Lawyer");
		lawyer.setHorizontalAlignment(SwingConstants.LEFT);
		lawyer.setForeground(new Color(17, 80, 136));
		lawyer.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lawyer.setBounds(41, 291, 194, 28);
		getContentPane().add(lawyer);
		
		lawyerBox = new JComboBox();
		lawyerBox.setBounds(245, 296, 136, 22);
		getContentPane().add(lawyerBox);
		lawyerBox.addItem("None");
		for(Integer id : Court.getInstance().getAllLawyers().keySet()) {
		       lawyerBox.addItem(id);
	    }
		
		JComboBox accusedBox = new JComboBox();
		accusedBox.setBounds(245, 139, 136, 22);
		getContentPane().add(accusedBox);
		for(Integer id : Court.getInstance().getAllAccuseds().keySet()) {
			accusedBox.addItem(id);
	    }
		
		JLabel verdict = new JLabel("Verdict");
		verdict.setHorizontalAlignment(SwingConstants.LEFT);
		verdict.setForeground(new Color(17, 80, 136));
		verdict.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		verdict.setBounds(41, 330, 194, 28);
		getContentPane().add(verdict);
		
		JLabel victim = new JLabel("Victim");
		victim.setHorizontalAlignment(SwingConstants.LEFT);
		victim.setForeground(new Color(17, 80, 136));
		victim.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		victim.setBounds(459, 134, 194, 28);
		getContentPane().add(victim);
		
		JLabel crimeScene = new JLabel("Crime Scene");
		crimeScene.setHorizontalAlignment(SwingConstants.LEFT);
		crimeScene.setForeground(new Color(17, 80, 136));
		crimeScene.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		crimeScene.setBounds(459, 173, 194, 28);
		getContentPane().add(crimeScene);
		
		JComboBox verdictBox = new JComboBox();
		verdictBox.setBounds(245, 335, 136, 22);
		getContentPane().add(verdictBox);
		verdictBox.addItem("None");
		for(Integer id : Court.getInstance().getAllVerdicts().keySet()) {
			verdictBox.addItem(id);
	    }
		
		sceneTxt = new JTextField();
		sceneTxt.setForeground(new Color(0, 0, 51));
		sceneTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sceneTxt.setColumns(10);
		sceneTxt.setBounds(600, 175, 136, 26);
		getContentPane().add(sceneTxt);
		
		victimBox = new JComboBox();
		victimBox.setBounds(600, 139, 136, 22);
		getContentPane().add(victimBox);
		for(Integer id : Court.getInstance().getAllWitnesses().keySet()) {
			victimBox.addItem(id);
	    }
		for(Integer id : Court.getInstance().getAllLawyers().keySet()) {
			victimBox.addItem(id);
	    }
		for(Integer id : Court.getInstance().getAllEmployees().keySet()) {
			victimBox.addItem(id);
	    }
		for(Integer id : Court.getInstance().getAllAccuseds().keySet()) {
			victimBox.addItem(id);
	    }
		
		
		JLabel crimeTool = new JLabel("Crime Tool");
		crimeTool.setHorizontalAlignment(SwingConstants.LEFT);
		crimeTool.setForeground(new Color(17, 80, 136));
		crimeTool.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		crimeTool.setBounds(459, 212, 194, 28);
		getContentPane().add(crimeTool);
		
		toolTxt = new JTextField();
		toolTxt.setForeground(new Color(0, 0, 51));
		toolTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolTxt.setColumns(10);
		toolTxt.setBounds(600, 214, 136, 26);
		getContentPane().add(toolTxt);
		
		cases = new JLabel("Cases");
		cases.setHorizontalAlignment(SwingConstants.LEFT);
		cases.setForeground(new Color(17, 80, 136));
		cases.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		cases.setBounds(173, 79, 194, 28);
		getContentPane().add(cases);
		
		caseBox = new JComboBox();
		caseBox.setBounds(311, 84, 136, 22);
		getContentPane().add(caseBox);
		for(String c: Court.getInstance().getAllCases().keySet()) {
			if(Court.getInstance().getRealCase(c) instanceof CriminalCase)
				caseBox.addItem(c);
		}
		
		showBtn = new JButton("Show");
		showBtn.setForeground(new Color(12, 3, 114));
		showBtn.setBackground(Color.LIGHT_GRAY);
		showBtn.setBounds(525, 84, 89, 23);
		getContentPane().add(showBtn);
		showBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CriminalCase c = Court.getInstance().getRealCriminalCase((String)caseBox.getSelectedItem());
            	accusedBox.setSelectedItem(c.getAccused().getId());
            	dateTxt.setText(""+c.getOpenedDate());
            	statusBox.setSelectedItem(c.getCaseStatus());
            	specializationBox.setSelectedItem(c.getCaseType());
            	if(c.getLawyer() == null) {
            		lawyerBox.setSelectedItem("None");
            	}
            	else {
                	lawyerBox.setSelectedItem(c.getLawyer().getId());
            	}
            	if(c.getVerdict() == null) {
            		verdictBox.setSelectedItem("None");
            	}
            	else {
                	verdictBox.setSelectedItem(c.getVerdict().getVerdictID());
            	}
            	victimBox.setSelectedItem(c.getVictim().getId());
            	toolTxt.setText(c.getCrimeTool());
            	sceneTxt.setText(c.getCrimeScene());
            }
            
        });

		
		
	
		doneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String scene = sceneTxt.getText();
            	String tool = toolTxt.getText();
            	Accused a = null;
            	Lawyer l = null;
            	Verdict v = null;
            	Person p = null;
            	Status s = null;
            	Specialization sp=null;
            	CriminalCase fc = null;
            	 
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
	                     	p = Court.getInstance().getRealLawyer((int)victimBox.getSelectedItem());
	                     	p = Court.getInstance().getRealWitness((int)victimBox.getSelectedItem());
	                     	p = Court.getInstance().getRealEmployee((int)victimBox.getSelectedItem());
	                     	p = Court.getInstance().getRealAccused((int)victimBox.getSelectedItem());
	                	}

               try {
                    if(sceneTxt.getText().isEmpty() || dateTxt.getText().isEmpty() || sceneTxt.getText().isEmpty() || toolTxt.getText().isEmpty()) {
                    	throw new FieldsAreNotFullExp();
                    }
                    fc = Court.getInstance().getRealCriminalCase((String) caseBox.getSelectedItem());
                	fc.setAccused(a);
                	fc.setCaseStatus(s);
                	fc.setCaseType(sp);
                	fc.setCrimeScene(scene);
                	fc.setCrimeTool(tool);
                	fc.setLawyer(l);
                	fc.setVerdict(v);
                	fc.setVictim(p);
                    JOptionPane.showMessageDialog(null, fc.getCode()+ " Updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } catch (FieldsAreNotFullExp e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });

        
	}
    private void clearFields() {
    	sceneTxt.setText("");
    	dateTxt.setText("");
    	sceneTxt.setText("");
    	toolTxt.setText("");
    }
}
