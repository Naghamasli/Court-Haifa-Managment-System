package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import control.Court;
import enums.Gender;
import model.Case;
import model.Testimony;
import model.Witness;
import Exceptions.FutureDateException;
import Exceptions.InvalidBirthDateException;

public class TestimonyAddFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField firstNameField, lastNameField, birthDateField, addressField, phoneField, emailField;
    private JComboBox<Gender> genderComboBox;
    private JComboBox caseComboBox;
    private JTextArea testimonyContentField;
    private JButton addButton;
    private JLabel messageLabel;

    // Colors and Fonts
    private final Color backgroundColor = new Color(245, 245, 245); // Light gray
    private final Color buttonColor = new Color(0, 123, 255);      // Blue
    private final Color errorColor = new Color(220, 53, 69);       // Red
    private final Font labelFont = new Font("Arial", Font.BOLD, 14);
    private final Font fieldFont = new Font("Arial", Font.PLAIN, 14);
    private JLabel lblNewLabel;
    private JButton btnBack;
    private JTextField textField;

    public TestimonyAddFrame() {
        setTitle("Add Testimony");
        setSize(738, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 680, 540);
		getContentPane().setBackground(new Color(207, 207, 201));
		getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        // Witness ID
        JLabel idLabel = new JLabel("Witness ID");
        idLabel.setBounds(20, 122, 130, 25);
        idLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        idLabel.setForeground(new Color(0, 64, 128));
        getContentPane().add(idLabel);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(20, 158, 130, 25);
        firstNameLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        firstNameLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(168, 158, 137, 25);
        firstNameField.setFont(fieldFont);
        firstNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(firstNameField);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(20, 206, 130, 25);
        lastNameLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        lastNameLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(168, 206, 137, 25);
        lastNameField.setFont(fieldFont);
        lastNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(lastNameField);

        // Birth Date
        JLabel birthDateLabel = new JLabel("Birth Date");
        birthDateLabel.setBounds(20, 253, 130, 25);
        birthDateLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        birthDateLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(birthDateLabel);

        birthDateField = new JTextField();
        birthDateField.setBounds(168, 253, 137, 25);
        birthDateField.setFont(fieldFont);
        birthDateField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(birthDateField);

        // Address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(20, 297, 130, 25);
        addressLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        addressLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(168, 289, 137, 25);
        addressField.setFont(fieldFont);
        addressField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(addressField);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(20, 333, 130, 25);
        phoneLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        phoneLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(168, 333, 137, 25);
        phoneField.setFont(fieldFont);
        phoneField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(phoneField);

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(20, 369, 130, 25);
        emailLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        emailLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(168, 369, 137, 25);
        emailField.setFont(fieldFont);
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(emailField);

        // Gender
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(363, 297, 130, 25);
        genderLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        genderLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(genderLabel);

        genderComboBox = new JComboBox<>(Gender.values());
        genderComboBox.setBounds(503, 297, 150, 25);
        genderComboBox.setFont(fieldFont);
        getContentPane().add(genderComboBox);

        // Case Selection
        JLabel caseLabel = new JLabel("Case");
        caseLabel.setBounds(363, 253, 130, 25);
        caseLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        caseLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(caseLabel);

        caseComboBox = new JComboBox();
        caseComboBox.setBounds(497, 253, 156, 25);
        caseComboBox.setFont(fieldFont);
        getContentPane().add(caseComboBox);
        for(String s: Court.getInstance().getAllCases().keySet()) {
        	caseComboBox.addItem(s);
        }

        // Testimony Content
        JLabel testimonyLabel = new JLabel("Content");
        testimonyLabel.setBounds(363, 122, 130, 25);
        testimonyLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
        testimonyLabel.setForeground(new Color(0, 64, 128));
		getContentPane().add(testimonyLabel);

        testimonyContentField = new JTextArea();
        testimonyContentField.setBounds(497, 125, 156, 100);
        testimonyContentField.setFont(fieldFont);
        testimonyContentField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(testimonyContentField);

        // Add Button
        addButton = new JButton("Add ");
        addButton.setBounds(513, 438, 89, 23);
        addButton.setForeground(new Color(12, 3, 114));
        addButton.setBackground(new Color(192, 192, 192));
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addTestimony());
        getContentPane().add(addButton);

        // Message Label
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setForeground(errorColor);
        messageLabel.setFont(labelFont);
        messageLabel.setBounds(17, 530, 350, 25);
        getContentPane().add(messageLabel);
        
        lblNewLabel = new JLabel("Testimony");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(178, 27, 317, 34);
        lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(0, 64, 128));
        getContentPane().add(lblNewLabel);
        
        btnBack = new JButton("Back");
        btnBack.setForeground(new Color(12, 3, 114));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setBounds(393, 438, 89, 23);
        getContentPane().add(btnBack);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setBounds(168, 122, 137, 25);
        getContentPane().add(textField);
        btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoUserNeeded ad = new NoUserNeeded();
				ad.setVisible(true);
				dispose();			 }
		});

       

    }

    private boolean validateFields() {
        resetFieldBorders();

       
        if (firstNameField.getText().isEmpty()) {
            showError("First Name cannot be empty.", firstNameField);
            return false;
        }
        if (lastNameField.getText().isEmpty()) {
            showError("Last Name cannot be empty.", lastNameField);
            return false;
        }
        if (birthDateField.getText().isEmpty()) {
            showError("Birth Date cannot be empty.", birthDateField);
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthDateField.getText().trim());
            if (!birthDateField.getText().trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new ParseException("Invalid date format", 0);
            }
        } catch (ParseException e) {
            showError("Birth Date must be a valid date in format dd/mm/yyyy (e.g., 31/12/1990).", birthDateField);
            return false;
        }
        if (addressField.getText().isEmpty()) {
            showError("Address cannot be empty.", addressField);
            return false;
        }
        if (phoneField.getText().isEmpty()) {
            showError("Phone Number cannot be empty.", phoneField);
            return false;
        }
        if (emailField.getText().isEmpty()) {
            showError("Email cannot be empty.", emailField);
            return false;
        }
        if (caseComboBox.getSelectedItem() == null) {
            showError("A Case must be selected.", caseComboBox);
            return false;
        }
        if (testimonyContentField.getText().isEmpty()) {
            showError("Testimony Content cannot be empty.", testimonyContentField);
            return false;
        }
        return true;
    }

    private void showError(String message, JComponent field) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        field.setBorder(BorderFactory.createLineBorder(errorColor, 2));
    }

    private void resetFieldBorders() {
        firstNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lastNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        birthDateField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addressField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        phoneField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        caseComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        testimonyContentField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    private void addTestimony() {
        if (!validateFields()) {
            return;
        }

        try {
            int id = Integer.parseInt(textField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String Birth= birthDateField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            Gender gender = (Gender) genderComboBox.getSelectedItem();
            Case c = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); // Ensures strict validation
            
           
            Date birthDate = dateFormat.parse(Birth); // Parse the input
            if (birthDate.after(Court.getInstance().TODAY)) { // Check if it's a future date
                    throw new FutureDateException();
            }
        	if(caseComboBox.getSelectedItem() != null) {
            	c = Court.getInstance().getRealCase((String) caseComboBox.getSelectedItem());
        	}
            String testimonyContent = testimonyContentField.getText();

            // Create Witness
            Witness witness = new Witness(id, firstName, lastName, birthDate, address, phone, email, gender);

            // Create Testimony
            Testimony testimony = new Testimony(c, testimonyContent, witness);

            // Add to Court
            Court.getInstance().addWitness(witness);
            Court.getInstance().addTestimony(testimony);
            witness.addTestimony(testimony); // Link testimony to witness

            JOptionPane.showMessageDialog(null, "Testimony added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            resetFields();
            SerializationHelp.saveCourt(Court.getInstance());

        }catch (ParseException e2) {
            JOptionPane.showMessageDialog(null, "Invalid date format! Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FutureDateException e3) {
            JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            showError("An error occurred: " + e.getMessage(), null);
        }
    }

    private void resetFields() {
    	textField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        birthDateField.setText("");
        addressField.setText("");
        phoneField.setText("");
        emailField.setText("");
        testimonyContentField.setText("");
        messageLabel.setText("");
    }
}