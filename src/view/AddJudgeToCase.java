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
//import Exceptions.caseAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Document;
import model.Employee;
import model.Judge;
import model.Judge;
import model.Judge;
import model.Verdict;
import model.Case;
import control.Court;

import javax.swing.JComboBox;

public class AddJudgeToCase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addJudgeToCase;
	private JButton addBtn;
	private JButton clearBtn;
	private JComboBox caseBox;
	private JLabel Judge;
	private JComboBox judgeBox;
	
	public AddJudgeToCase() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addJudgeToCase = new JLabel("Add Judge to Case");
		addJudgeToCase.setHorizontalAlignment(SwingConstants.CENTER);
		addJudgeToCase.setBounds(178, 27, 317, 34);
		addJudgeToCase.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addJudgeToCase.setForeground(new Color(0, 64, 128));
		getContentPane().add(addJudgeToCase);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(513, 438, 89, 23);
		addBtn.setForeground(new Color(12, 3, 114));
	    addBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(addBtn);
		
		
		JLabel caseL = new JLabel("Case");
		caseL.setHorizontalAlignment(SwingConstants.LEFT);
		caseL.setForeground(new Color(17, 80, 136));
		caseL.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		caseL.setBounds(134, 146, 194, 28);
		getContentPane().add(caseL);
		
		caseBox = new JComboBox();
		caseBox.setBounds(383, 151, 136, 22);
		getContentPane().add(caseBox);
		for(String id : Court.getInstance().getAllCases().keySet()) {
		       caseBox.addItem(id);
	    }
		
		Judge = new JLabel("Judge");
		Judge.setHorizontalAlignment(SwingConstants.LEFT);
		Judge.setForeground(new Color(17, 80, 136));
		Judge.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		Judge.setBounds(134, 101, 194, 28);
		getContentPane().add(Judge);
		
		judgeBox = new JComboBox();
		judgeBox.setBounds(383, 106, 136, 22);
		getContentPane().add(judgeBox);
		for(int id : Court.getInstance().getAllLawyers().keySet()) {
			if(Court.getInstance().getRealLawyer(id) instanceof Judge)
				  judgeBox.addItem(id);
	    }
		
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
	                  	Case d = null;
	                	if(caseBox.getSelectedItem() != null) {
	                    	d = Court.getInstance().getRealCase((String) caseBox.getSelectedItem());
	                	}
	                	Judge emp = null;
	                	if(judgeBox.getSelectedItem() != null) {
	                		emp = Court.getInstance().getRealJudge((int)judgeBox.getSelectedItem());
	                	}
	                	emp.getCasesPresided().add(d);
	                    JOptionPane.showMessageDialog(null, "Judge "+ emp.getFirstName() +" added to case "+d.getCode()+" successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

 
            }
            
        });

        
	}
}
