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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import control.Court;
import model.Appeal;

import javax.swing.JComboBox;


public class AppealApproval extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel appealLabel;
    private JLabel allChoicesLabel;
    private JTextArea objectToString;
    private JButton btnDone;
    private JScrollPane scrollPane;
    private JComboBox allChoices;
    private JButton approve;
    private JButton deny;
    

	public AppealApproval() {
		setBounds(100, 100, 680, 540);
        getContentPane().setBackground(new Color(207, 207, 201));
        getContentPane().setLayout(null);

        appealLabel = new JLabel("Approve Appeal");
        appealLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appealLabel.setBounds(165, 26, 317, 34);
        appealLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        appealLabel.setForeground(new Color(0, 64, 128));
        getContentPane().add(appealLabel);
       

        allChoicesLabel = new JLabel("All Pending Appeals");
        allChoicesLabel.setBounds(108, 119, 178, 34);
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
        for (int id : Court.getInstance().getAppealApps().keySet()) {
        	allChoices.addItem(id);
        }
        
        JButton show = new JButton("Show");
        show.setForeground(new Color(12, 3, 114));
        show.setBackground(new Color(0, 64, 128));
        show.setBounds(493, 167, 89, 23);
        getContentPane().add(show);
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 if(Court.getInstance().getAppealApps().get((int)allChoices.getSelectedItem()) != null)
                 {
            		 updateDetails();
                 }
            	}
        });
        
        approve = new JButton("Approve");
        approve.setForeground(new Color(12, 3, 114));
        approve.setBackground(Color.LIGHT_GRAY);
        approve.setBounds(436, 421, 89, 23);
        getContentPane().add(approve);
        approve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 if(Court.getInstance().getRealAppeal((int)allChoices.getSelectedItem()) != null)
                 {
            		 Appeal p = Court.getInstance().getAppealApps().get((int)allChoices.getSelectedItem());
            		 Court.getInstance().addAppeal(p);
                     JOptionPane.showMessageDialog(null, "Appeal "+ p.getAppealID() +" approved and added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                 }
            	}
        });
        
        deny = new JButton("Deny");
        deny.setForeground(new Color(12, 3, 114));
        deny.setBackground(Color.LIGHT_GRAY);
        deny.setBounds(341, 421, 89, 23);
        getContentPane().add(deny);
        deny.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 if(Court.getInstance().getAppealApps().get((int)allChoices.getSelectedItem()) != null)
                 {
            		 Appeal p = Court.getInstance().getAppealApps().get((int)allChoices.getSelectedItem());
            		 Court.getInstance().getAppealApps().remove(p.getAppealID());
                     JOptionPane.showMessageDialog(null, "Appeal "+ p.getAppealID() +" denied ", "Success", JOptionPane.INFORMATION_MESSAGE);
                 }
            	}
        });
       
       
  
    }

    // Helper method to update the displayed customer details
    private void updateDetails() {
        int selecteId = (int) allChoices.getSelectedItem();
        String details = Court.getInstance().getAppealApps().get((int)allChoices.getSelectedItem()).toString();
        objectToString.setText(details);
    }
}

