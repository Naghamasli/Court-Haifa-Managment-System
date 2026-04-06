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

import Exceptions.DepartmentAlreadyExistsExp;
import Exceptions.FieldsAreNotFullExp;
import Exceptions.IdCannotBeNullExp;
//import Exceptions.DepartmentAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Department;
import model.Employee;
import control.Court;
import enums.Position;
import enums.Specialization;

import javax.swing.JComboBox;

public class AddDepartment extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addDepartmentLb;
	private JLabel idLb;
	private JTextField idTxt;
	private JButton addBtn;
	private JButton clearBtn;
	private JLabel lblDepartmentName;
	private JLabel lblDepartmentManager;
	private JLabel lblDepartmentBuilding;
	private JLabel lblDepartmentSpecialization;
	private JTextField nameTxt;
	private JTextField buildingTxt;
	private JComboBox<Integer> managers;
	private JComboBox<Specialization> specializing;
	
	public AddDepartment() {
		setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addDepartmentLb = new JLabel("Department");
		addDepartmentLb.setHorizontalAlignment(SwingConstants.CENTER);
		addDepartmentLb.setBounds(132, 27, 317, 34);
		addDepartmentLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addDepartmentLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addDepartmentLb);
		
		idLb = new JLabel("Department Number");
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
		
		lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentName.setForeground(new Color(17, 80, 136));
		lblDepartmentName.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblDepartmentName.setBounds(41, 150, 194, 28);
		getContentPane().add(lblDepartmentName);
		
		lblDepartmentManager = new JLabel("Department Manager\r\n");
		lblDepartmentManager.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentManager.setForeground(new Color(17, 80, 136));
		lblDepartmentManager.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblDepartmentManager.setBounds(41, 199, 194, 28);
		getContentPane().add(lblDepartmentManager);
		
		lblDepartmentBuilding = new JLabel("Department Building\r\n");
		lblDepartmentBuilding.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentBuilding.setForeground(new Color(17, 80, 136));
		lblDepartmentBuilding.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblDepartmentBuilding.setBounds(41, 251, 194, 28);
		getContentPane().add(lblDepartmentBuilding);
		
		lblDepartmentSpecialization = new JLabel("Department Specialization\r\n");
		lblDepartmentSpecialization.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentSpecialization.setForeground(new Color(17, 80, 136));
		lblDepartmentSpecialization.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblDepartmentSpecialization.setBounds(41, 305, 229, 28);
		getContentPane().add(lblDepartmentSpecialization);
		
		nameTxt = new JTextField();
		nameTxt.setForeground(new Color(0, 0, 51));
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameTxt.setColumns(10);
		nameTxt.setBounds(383, 156, 136, 26);
		getContentPane().add(nameTxt);
		
		buildingTxt = new JTextField();
		buildingTxt.setForeground(new Color(0, 0, 51));
		buildingTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buildingTxt.setColumns(10);
		buildingTxt.setBounds(383, 253, 136, 26);
		getContentPane().add(buildingTxt);
		
		managers = new JComboBox<>();
		managers.setBounds(383, 204, 136, 23);
		getContentPane().add(managers);
		for(int id : Court.getInstance().getAllEmployees().keySet()) {
			if(Court.getInstance().getRealEmployee(id).getPosition() == Position.Manager) {
				managers.addItem(id);
			}
		}
		
		specializing = new JComboBox<>(Specialization.values());
		specializing.setBounds(383, 310, 136, 23);
		getContentPane().add(specializing);
	
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
                String name = nameTxt.getText();
                Employee ep = null;
                if(managers.getSelectedItem() != null) {
                	ep = Court.getInstance().getAllEmployees().get(managers.getSelectedItem());
                }
                String building = buildingTxt.getText();
                Specialization sp = (Specialization) specializing.getSelectedItem();
                
                Department d = new Department(id, name, ep, building, sp);

                try {
                	if(Court.getInstance().getAllDepartments().containsKey(id))
                	{
                		throw new DepartmentAlreadyExistsExp();
                	}
                	if(id == null || name == null || ep == null || building == null || sp == null)
                	{
                		throw new FieldsAreNotFullExp();
                	}
                    Court.getInstance().addDepartment(d);
                    JOptionPane.showMessageDialog(null, "Department added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } catch (DepartmentAlreadyExistsExp ex) {
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
    	nameTxt.setText("");
    	buildingTxt.setText("");
    	
    	
    }
}
