package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import control.Court;
import model.CriminalCase;
import model.FinancialCase;
import model.Judge;

import javax.swing.JComboBox;


public class GetRealFinancialCase extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel getRealLabel;
    private JLabel allChoicesLabel;
    private JTextArea objectToString;
    private JButton btnDone;
    private JScrollPane scrollPane;
    private JComboBox allChoices;
    

	public GetRealFinancialCase(int userId) {
		setBounds(100, 100, 680, 540);
        getContentPane().setBackground(new Color(207, 207, 201));
        getContentPane().setLayout(null);

        getRealLabel = new JLabel("GetRealFinancialCase");
        getRealLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getRealLabel.setBounds(165, 26, 317, 34);
        getRealLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        getRealLabel.setForeground(new Color(0, 64, 128));
        getContentPane().add(getRealLabel);
       

        allChoicesLabel = new JLabel("AllFinancialCases");
        allChoicesLabel.setBounds(131, 127, 159, 18);
        allChoicesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        allChoicesLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        allChoicesLabel.setForeground(new Color(17, 80, 136));
        getContentPane().add(allChoicesLabel);

        objectToString = new JTextArea();
        objectToString.setEditable(false);
        scrollPane = new JScrollPane(objectToString);
        scrollPane.setBounds(101, 212, 497, 159);
        getContentPane().add(scrollPane);

        objectToString.setForeground(new Color(17, 80, 136));
        objectToString.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        objectToString.setLineWrap(true);
        objectToString.setWrapStyleWord(true);
       

        btnDone = new JButton("Done");
        btnDone.setForeground(new Color(12, 3, 114));
        btnDone.setBackground(new Color(192, 192, 192));
        btnDone.setBounds(537, 421, 89, 23);
        getContentPane().add(btnDone);
        btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	objectToString.setText("");          
            	}
        });
        
       
        
        allChoices = new JComboBox();
        allChoices.setBounds(341, 127, 123, 22);
        getContentPane().add(allChoices);
        if(Court.getInstance().getAllLawyers().containsKey(userId)) {
        	if(Court.getInstance().getRealLawyer(userId) instanceof Judge) {
        		for (String i : Court.getInstance().getAllCases().keySet()) {
                	if(Court.getInstance().getRealCase(i) instanceof FinancialCase) {
                		if(Court.getInstance().getRealJudge(userId).getCasesPresided().contains(Court.getInstance().getRealFinancialCase(i))) {
                  	         allChoices.addItem(i);
                		}
                	}
        	    }
             }else {
            	 for (String i : Court.getInstance().getAllCases().keySet()) {
                   	if(Court.getInstance().getRealCase(i) instanceof FinancialCase && Court.getInstance().getRealCase(i).getLawyer() != null) {
                 		if(Court.getInstance().getRealFinancialCase(i).getLawyer().getId() == userId) {
                   	       allChoices.addItem(i);
                 		}
                 	}
                 	
                  }
             }
        }else {
        	 for (String i : Court.getInstance().getAllCases().keySet()) {
             	if(Court.getInstance().getRealCase(i) instanceof FinancialCase)
             	      allChoices.addItem(i);
             }
       }
        
        JButton show = new JButton("Show");
        show.setForeground(new Color(12, 3, 114));
        show.setBackground(new Color(0, 64, 128));
        show.setBounds(493, 167, 89, 23);
        getContentPane().add(show);
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 if(Court.getInstance().getRealFinancialCase((String)allChoices.getSelectedItem()) != null)
                 {
            		 updateDetails();
                 }
            	}
        });
  
    }

    // Helper method to update the displayed customer details
    private void updateDetails() {
        String selecteId = (String) allChoices.getSelectedItem();
        String details = Court.getInstance().getRealFinancialCase(selecteId).toString();
        objectToString.setText(details);
    }
}

