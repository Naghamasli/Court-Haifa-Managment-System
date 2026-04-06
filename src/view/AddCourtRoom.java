package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Exceptions.CourtRoomAlreadyExistsExp;
import Exceptions.FieldsAreNotFullExp;
import Exceptions.IdCannotBeNullExp;
import model.Courtroom;
//import Exceptions.DepartmentAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Department;
import control.Court;

import javax.swing.JComboBox;

public class AddCourtRoom extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addCourtRoomLb;
	private JLabel idLb;
	private JTextField idTxt;
	private JButton addBtn;
	private JButton clearBtn;
	private JLabel lblDepartmentName;
	private JComboBox<Integer> departments;
	
	public AddCourtRoom() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addCourtRoomLb = new JLabel("CourtRoom");
		addCourtRoomLb.setHorizontalAlignment(SwingConstants.CENTER);
		addCourtRoomLb.setBounds(132, 27, 317, 34);
		addCourtRoomLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addCourtRoomLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addCourtRoomLb);
		
		idLb = new JLabel("CourtRoom Number");
		idLb.setBounds(41, 98, 194, 28);
		idLb.setHorizontalAlignment(SwingConstants.LEFT);
		idLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		idLb.setForeground(new Color(17, 80, 136));
		getContentPane().add(idLb);
		
		idTxt = new JTextField();
		idTxt.setBounds(383, 100, 136, 26);
		idTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTxt.setForeground(new Color(0, 0, 51));
		getContentPane().add(idTxt);
		idTxt.setColumns(10);
		idTxt.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume(); // Ignore non-digit characters
		        }
		    }
		});
		
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
		
		lblDepartmentName = new JLabel("Department ");
		lblDepartmentName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentName.setForeground(new Color(17, 80, 136));
		lblDepartmentName.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblDepartmentName.setBounds(41, 150, 194, 28);
		getContentPane().add(lblDepartmentName);
		
		departments = new JComboBox<>();
		departments.setBounds(383, 155, 136, 23);
		getContentPane().add(departments);
		for(int id : Court.getInstance().getAllDepartments().keySet()) {
				departments.addItem(id);
		}
	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Integer id = 0;
            	  try {
	                	if(idTxt.getText() == "" || idTxt.getText().isEmpty() || idTxt.getText().isEmpty()) {
	                		throw new IdCannotBeNullExp();
	                	}else {
		                	id = Integer.parseInt(idTxt.getText());
	                	}
            	  }catch(IdCannotBeNullExp e1) {
	                	 JOptionPane.showMessageDialog(null, e1.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
                         return;
            	  }
            	
            	Department d = null;
            	if(departments.getSelectedItem() != null) {
                	d = Court.getInstance().getRealDepartment((int) departments.getSelectedItem());
            	}
            	Courtroom cr = new Courtroom(id, d);
               
                try {
                	if(Court.getInstance().getAllCourtrooms().containsKey(id))
                	{
                		throw new CourtRoomAlreadyExistsExp();
                	}
                	if(id == null || d == null)
                	{
                		throw new FieldsAreNotFullExp();
                	}
                	Court.getInstance().addCourtroom(cr);
                    JOptionPane.showMessageDialog(null, "CourtRoom added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } catch (CourtRoomAlreadyExistsExp ex) {
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
    	idTxt.setText("");
    }
}
