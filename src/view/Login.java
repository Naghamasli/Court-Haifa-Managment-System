package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Court;
import model.Judge;

import javax.swing.JPanel;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon im = new ImageIcon("others/logoCourt.png");
    private JLabel loginLabel;
    private JTextField usernameTXT;
    private String adminLogin = "admin";
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordTXT;
    private JButton loginB;
    private JLabel picLabel;
    int logoWidth = 100; // Adjust width as needed
    int logoHeight = 100; // Adjust height as needed
    private Image scaledImage = im.getImage().getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
    private ImageIcon resizedIcon = new ImageIcon(scaledImage);
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;




//this is the login page that first opens it accepts a username and a password if they are both "admin" 
//then the admin page opens up and if it matches any of the employees then it opens up the employee page
//else it displays an error message
	public Login() {
		getContentPane().setForeground(new Color(0, 64, 128));
		getContentPane().setBackground(new Color(207, 207, 201));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 575);
		setIconImage(im.getImage());
		getContentPane().setLayout(null);
		
		
		loginLabel = new JLabel("Court Management System");
		loginLabel.setForeground(new Color(0, 64, 128));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Book Antiqua", Font.BOLD, 24));
		loginLabel.setBounds(110, 42, 472, 49);
		getContentPane().add(loginLabel);
		
		usernameTXT = new JTextField();
		usernameTXT.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTXT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameTXT.setForeground(new Color(12, 3, 114));
		usernameTXT.setBounds(193, 245, 161, 29);
		getContentPane().add(usernameTXT);
		usernameTXT.setColumns(10);
		
		loginB = new JButton("Login");
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = usernameTXT.getText();
				int user;
				String password = new String(passwordTXT.getPassword());
		        if(userName.equals("admin") && password.equals("admin")) {
		        	MainFrame ad = new MainFrame(userName);
					ad.setVisible(true);
					dispose();
		        }else if(userName.matches("\\d+")){
					user = Integer.parseInt(userName);
					if(Court.getInstance().getAllLawyers().containsKey(user) && userName.equals(password)) {
				        	if(Court.getInstance().getRealLawyer(user) instanceof Judge) {
				        		MainFrame ad = new MainFrame(userName);
								ad.setVisible(true);
								dispose();
								return;
				        	}else {
				        		MainFrame ad = new MainFrame(userName);
								ad.setVisible(true);
								dispose();
								return;
				        	}
				    }else if(Court.getInstance().getAllEmployees().containsKey(user) && userName.equals(password)) {
				    	MainFrame ad = new MainFrame(userName);
						ad.setVisible(true);
						dispose();
						return;
				   }else {
					   JOptionPane.showMessageDialog(null, "Username or Password are incorrect! Please try again.", "Alert message", JOptionPane.ERROR_MESSAGE);
	                   usernameTXT.setText("");
	                   passwordTXT.setText("");
				   }

		       }else {
		    	   JOptionPane.showMessageDialog(null, "Username or Password are incorrect! Please try again.", "Alert message", JOptionPane.ERROR_MESSAGE);
                   usernameTXT.setText("");
                   passwordTXT.setText("");
		       }
		     }
		});
		loginB.setBackground(new Color(192, 192, 192));
		loginB.setForeground(new Color(12, 3, 114));
		loginB.setBounds(42, 370, 89, 23);
		getContentPane().add(loginB);
		
		userLabel = new JLabel("Username");
		userLabel.setForeground(new Color(0, 64, 128));
		userLabel.setFont(new Font("Book Antiqua", Font.BOLD, 19));
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setBounds(42, 245, 110, 29);
		getContentPane().add(userLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(new Color(0, 64, 128));
		passwordLabel.setFont(new Font("Book Antiqua", Font.BOLD, 19));
		passwordLabel.setBounds(50, 285, 89, 41);
		getContentPane().add(passwordLabel);
		
		passwordTXT = new JPasswordField();
		passwordTXT.setForeground(new Color(12, 3, 114));
		passwordTXT.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTXT.setBounds(193, 293, 161, 29);
		getContentPane().add(passwordTXT);
		
		JLabel lblNewLabel = new JLabel("Please sign in!");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 155, 150, 42);
		getContentPane().add(lblNewLabel);
		
		picLabel = new JLabel("");
		picLabel.setVerticalAlignment(SwingConstants.TOP);
		picLabel.setIcon(resizedIcon);
		picLabel.setBounds(469, 222, logoWidth, logoHeight);
		getContentPane().add(picLabel);
		
		lblNewLabel_1 = new JLabel("If you would like to perform actions without logging in, ");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 480, 342, 29);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("<html><u>Click Here!</u></html>");
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(346, 479, 80, 29);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	NoUserNeeded ad = new NoUserNeeded();
				ad.setVisible(true);
				dispose();
		    }
		});
		
	}
}
