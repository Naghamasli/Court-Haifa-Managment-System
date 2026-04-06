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
import Exceptions.InvalidBirthDateException;
import Exceptions.NegativeSalaryException;
import Exceptions.ObjectAlreadyExistsException;
import model.Accused;
import model.Courtroom;
//import Exceptions.DepartmentAlreadyExistsExp;
//import Exceptions.FeildsArentFull;
import model.Department;
import model.Employee;
import model.Lawyer;
import control.Court;
import enums.Gender;
import enums.Position;
import enums.Specialization;

import javax.swing.JComboBox;

public class AddAccused extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel addAccusedLb;
	private JLabel idLb;
	private JTextField idTxt;
	private JButton addBtn;
	private JButton clearBtn;
	private JLabel lblDepartmentName;
	private JTextField FnameTxt;
	private JLabel lblLastName;
	private JTextField LnameTxt;
	private JLabel dateLb;
	private JTextField birthDateTxt;
	private JLabel adressLb;
	private JTextField adressTxt;
	private JLabel phoneLb;
	private JTextField phoneTxt;
	private JLabel emailLb;
	private JTextField emailTxt;
	private JLabel genderLb;
	private JComboBox genderBox;
	private JLabel job;
	private JTextField jobTxt;
	
	public AddAccused() {
		setBounds(100, 100, 848, 638);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
		
		addAccusedLb = new JLabel("Accused");
		addAccusedLb.setHorizontalAlignment(SwingConstants.CENTER);
		addAccusedLb.setBounds(268, 30, 317, 34);
		addAccusedLb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		addAccusedLb.setForeground(new Color(0, 64, 128));
		getContentPane().add(addAccusedLb);
		
		idLb = new JLabel("ID\r\n");
		idLb.setBounds(41, 98, 194, 28);
		idLb.setHorizontalAlignment(SwingConstants.LEFT);
		idLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		idLb.setForeground(new Color(17, 80, 136));
		getContentPane().add(idLb);
		
		idTxt = new JTextField();
		idTxt.setBounds(258, 100, 136, 26);
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
		addBtn.setBounds(695, 553, 89, 23);
		addBtn.setForeground(new Color(12, 3, 114));
	    addBtn.setBackground(new Color(192, 192, 192));
		getContentPane().add(addBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setForeground(new Color(12, 3, 114));
		clearBtn.setBackground(new Color(192, 192, 192));
		clearBtn.setBounds(596, 553, 89, 23);
		getContentPane().add(clearBtn);
		// ActionListener for the "Clear" button
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
		
		lblDepartmentName = new JLabel("First Name\r\n");
		lblDepartmentName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentName.setForeground(new Color(17, 80, 136));
		lblDepartmentName.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblDepartmentName.setBounds(41, 150, 194, 28);
		getContentPane().add(lblDepartmentName);
		
		FnameTxt = new JTextField();
		FnameTxt.setForeground(new Color(0, 0, 51));
		FnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FnameTxt.setColumns(10);
		FnameTxt.setBounds(258, 156, 136, 26);
		getContentPane().add(FnameTxt);
		
		lblLastName = new JLabel("Last Name\r\n");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(new Color(17, 80, 136));
		lblLastName.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblLastName.setBounds(41, 200, 194, 28);
		getContentPane().add(lblLastName);
		
		LnameTxt = new JTextField();
		LnameTxt.setForeground(new Color(0, 0, 51));
		LnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LnameTxt.setColumns(10);
		LnameTxt.setBounds(258, 202, 136, 26);
		getContentPane().add(LnameTxt);
		
		dateLb = new JLabel("BirthDate\r\n");
		dateLb.setHorizontalAlignment(SwingConstants.LEFT);
		dateLb.setForeground(new Color(17, 80, 136));
		dateLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		dateLb.setBounds(41, 251, 194, 28);
		getContentPane().add(dateLb);
		
		birthDateTxt = new JTextField();
		birthDateTxt.setForeground(new Color(0, 0, 51));
		birthDateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		birthDateTxt.setColumns(10);
		birthDateTxt.setBounds(258, 253, 136, 26);
		getContentPane().add(birthDateTxt);
		
		adressLb = new JLabel("Adress");
		adressLb.setHorizontalAlignment(SwingConstants.LEFT);
		adressLb.setForeground(new Color(17, 80, 136));
		adressLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		adressLb.setBounds(41, 299, 194, 28);
		getContentPane().add(adressLb);
		
		adressTxt = new JTextField();
		adressTxt.setForeground(new Color(0, 0, 51));
		adressTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adressTxt.setColumns(10);
		adressTxt.setBounds(258, 301, 136, 26);
		getContentPane().add(adressTxt);
		
		phoneLb = new JLabel("Phone Number");
		phoneLb.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLb.setForeground(new Color(17, 80, 136));
		phoneLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		phoneLb.setBounds(41, 339, 194, 28);
		getContentPane().add(phoneLb);
		
		phoneTxt = new JTextField();
		phoneTxt.setForeground(new Color(0, 0, 51));
		phoneTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(258, 338, 136, 26);
		getContentPane().add(phoneTxt);
		phoneTxt.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume(); // Ignore non-digit characters
		        }
		    }
		});
		
		emailLb = new JLabel("Email");
		emailLb.setHorizontalAlignment(SwingConstants.LEFT);
		emailLb.setForeground(new Color(17, 80, 136));
		emailLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		emailLb.setBounds(436, 98, 194, 28);
		getContentPane().add(emailLb);
		
		emailTxt = new JTextField();
		emailTxt.setForeground(new Color(0, 0, 51));
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailTxt.setColumns(10);
		emailTxt.setBounds(598, 100, 136, 26);
		getContentPane().add(emailTxt);
		
		genderLb = new JLabel("Gender");
		genderLb.setHorizontalAlignment(SwingConstants.LEFT);
		genderLb.setForeground(new Color(17, 80, 136));
		genderLb.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		genderLb.setBounds(436, 150, 194, 28);
		getContentPane().add(genderLb);
		
		genderBox = new JComboBox();
		genderBox.setBounds(599, 155, 135, 22);
		getContentPane().add(genderBox);
		genderBox.addItem("Female");
		genderBox.addItem("Male");
		
		job = new JLabel("Job");
		job.setHorizontalAlignment(SwingConstants.LEFT);
		job.setForeground(new Color(17, 80, 136));
		job.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		job.setBounds(436, 200, 194, 28);
		getContentPane().add(job);
		
		jobTxt = new JTextField();
		jobTxt.setForeground(new Color(0, 0, 51));
		jobTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jobTxt.setColumns(10);
		jobTxt.setBounds(598, 206, 136, 26);
		getContentPane().add(jobTxt);
		
		
	


	
		addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 int id = 0;
	             String fName = FnameTxt.getText();
	             String lName = LnameTxt.getText();
	             String adress = adressTxt.getText();
	             String email = emailTxt.getText();
	             String phoneNumber = phoneTxt.getText();
	             String Birth= birthDateTxt.getText();
	             String job = jobTxt.getText();
	             int ln = 0;
	               
	                Gender gender = null;
	                if(genderBox.getSelectedItem() == "Female")  {
						gender = Gender.F;
					}
					if(genderBox.getSelectedItem() == "Male")  {
						gender = Gender.M;
					}
	                try {
	                	if(idTxt.getText() == "" || idTxt.getText().isEmpty() || idTxt.getText().isEmpty()) {
	                		throw new IdCannotBeNullExp();
	                	}else {
		                	id = Integer.parseInt(idTxt.getText());
	                	}
	                	if( idTxt.getText().isEmpty() || fName.isEmpty() || lName.isEmpty() || phoneNumber.isEmpty() ||Birth.isEmpty())
	                	{
	                		throw new FieldsAreNotFullExp();
	                	}
	                	if(Court.getInstance().getAllEmployees().containsKey(id) || Court.getInstance().getAllLawyers().containsKey(id) || Court.getInstance().getAllAccuseds().containsKey(id) || Court.getInstance().getAllWitnesses().containsKey(id)) {
	                		throw new ObjectAlreadyExistsException("Accused ");
	                	}
	                	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                      dateFormat.setLenient(false); // Ensures strict validation
	                      
	                     
	                      Date birthDate = dateFormat.parse(Birth); // Parse the input
	                      if (birthDate.after(Court.getInstance().TODAY)) { // Check if it's a future date
	                              throw new FutureDateException();
	                      }

	                      
	                    try {
							Accused l = new Accused(id,fName,lName, birthDate, adress, phoneNumber, email, gender,job );
							Court.getInstance().addAccused(l);
						} catch (InvalidBirthDateException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    JOptionPane.showMessageDialog(null, "Accused added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                clearFields(); // Clear input fields after successful addition
	                } catch (ObjectAlreadyExistsException ex) {
	                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }catch(IdCannotBeNullExp ex1){
	                	 JOptionPane.showMessageDialog(null, ex1.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
		                 return;
	                }catch (FieldsAreNotFullExp e1) {
	                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Alert message", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }catch (ParseException e2) {
                        JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (FutureDateException e3) {
                        JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
            }

        });

        
	}
    private void clearFields() {
    	idTxt.setText("");
    	FnameTxt.setText("");
    	LnameTxt.setText("");
    	phoneTxt.setText("");
    	adressTxt.setText("");
    	birthDateTxt.setText("");
    	emailTxt.setText("");
    	jobTxt.setText("");
    }
}
