package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.Court;
import model.Judge;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BackgroundPanel contentPane;
	private JMenuBar menuBar;
	private JMenu addFunctions;
	private JMenuItem addAccused;
	private JMenuItem addAppeal;
	private JMenuItem addCourtRoom;
	private JMenuItem addCriminalCase;
	private JMenuItem addFinancialCase;
	private JMenuItem addFamilyCase;
	private JMenu removeFunctions;
	private JMenuItem removeAccused;
	private JMenuItem removeAppeal;
	private JMenuItem removeCourtRoom;
	private JMenuItem removeCriminalCase;
	private JMenuItem removeFinancialCase;
	private JMenuItem removeFamilyCase;
	private JMenuItem removeDepartment;
	private JMenu queries;
	private JMenuItem bothSize;
	private JMenuItem findANewManager;
	private JMenuItem casesWithMoreThreeTestimoniesOfGender;
	private JMenuItem caseCountByDepartment;
	private JMenuItem suitableLawyer;
	private JMenuItem differenceBetweencases;
	private ImageIcon im = new ImageIcon("others/logoCourt.png");
	int logoWidth = 100; // Adjust width as needed
	int logoHeight = 100; // Adjust height as needed
	private Image scaledImage = im.getImage().getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
    private JMenuItem addDepartment;
    private JMenuItem uniqeCrimeTools;
    private JMenuItem mainMenue;
    private JMenuItem stopMusic;
    private static Clip clip;
    private JMenuItem save;
    private JMenu userOpt;
    private JMenuItem howManyCases;
    private JMenuItem addDocument;
    private JMenuItem addEmployee;
    private JMenuItem addJudge;
    private JMenuItem addLawyer;
    private JMenuItem addMeeting;
    private JMenuItem addTestimony;
    private JMenuItem addVerdict;
    private JMenuItem addWitness;
    private JMenu workFunctions;
    private JMenuItem addEmployeeToDepartment;
    private JMenuItem addJudgeToDepartment;
    private JMenuItem addLawyerToDepartment;
    private JMenuItem removeDocument;
    private JMenuItem removeEmployee;
    private JMenuItem removeJudge;
    private JMenuItem removeLawyer;
    private JMenuItem removeMeeting;
    private JMenuItem removeTestimony;
    private JMenuItem removeWitness;
    private JMenuItem removeVerdict_1;
    private JMenu getRealFunc;
    private JMenuItem GetrealAccused;
    private JMenuItem GetrealAppeal;
    private JMenuItem GetrealCourtroom;
    private JMenuItem GetrealCriminalcase;
    private JMenuItem GetrealFinancialcase;
    private JMenuItem GetrealFamilycase;
    private JMenuItem GetrealDepartment;
    private JMenuItem GetrealDocument;
    private JMenuItem GetRealEmployee;
    private JMenuItem GetrealLawyer;
    private JMenuItem GetrealJudge;
    private JMenuItem realMeeting;
    private JMenuItem GetrealTestimony;
    private JMenuItem getRealVerdict;
    private JMenuItem getrealWitness;
    private AudioInputStream audioInput;
    private JMenuItem meetingCalander;
    private JMenuItem addLawyerToCase;
    private JMenuItem addJudgeToCase;
    private JMenuItem appealapplication;
    private JMenuItem appealapproval;
    private JMenuItem updateCriminalCase;
    private JMenuItem updatefamilyCase;
    private JMenuItem updatefinancialCase;
    private int number;
    private JMenuItem visitorLog;
  


	public JMenu getAddFunctions() {
		return addFunctions;
	}

	public void setAddFunctions(JMenu addFunctions) {
		this.addFunctions = addFunctions;
	}

	public JMenuItem getAddAccused() {
		return addAccused;
	}

	public void setAddAccused(JMenuItem addCustomer) {
		this.addAccused = addCustomer;
	}

	public JMenuItem getAddAppeal() {
		return addAppeal;
	}

	public void setAddAppeal(JMenuItem addVIPCustomer) {
		this.addAppeal = addVIPCustomer;
	}

	public JMenuItem getAddCourtRoom() {
		return addCourtRoom;
	}

	public void setAddCourtRoom(JMenuItem addBooking) {
		this.addCourtRoom = addBooking;
	}

	public JMenuItem getAddCriminalCase() {
		return addCriminalCase;
	}

	public void setAddCriminalCase(JMenuItem addStandardRoom) {
		this.addCriminalCase = addStandardRoom;
	}

	public JMenuItem getAddFinancialCase() {
		return addFinancialCase;
	}
	
	public void setAddFinancialCase(JMenuItem addSuperiorRoom) {
		this.addFinancialCase = addSuperiorRoom;
	}

	public JMenuItem getAddFamilyCase() {
		return addFamilyCase;
	}

	public void setAddFamilyCase(JMenuItem addSuite) {
		this.addFamilyCase = addSuite;
	}

	public JMenu getRemoveFunctions() {
		return removeFunctions;
	}

	public void setRemoveFunctions(JMenu removeFunctions) {
		this.removeFunctions = removeFunctions;
	}

	public JMenuItem getRemoveAccused() {
		return removeAccused;
	}

	public void setRemoveAccused(JMenuItem removeCustomer) {
		this.removeAccused = removeCustomer;
	}

	public JMenuItem getRemoveAppeal() {
		return removeAppeal;
	}

	public void setRemoveAppeal(JMenuItem removeVIPCustomer) {
		this.removeAppeal = removeVIPCustomer;
	}

	public JMenuItem getRemoveCourtRoom() {
		return removeCourtRoom;
	}

	public void setRemoveCourtRoom(JMenuItem removeBooking) {
		this.removeCourtRoom = removeBooking;
	}

	public JMenuItem getRemoveStandardRoom() {
		return removeCriminalCase;
	}

	public void setRemoveStandardRoom(JMenuItem removeStandardRoom) {
		this.removeCriminalCase = removeStandardRoom;
	}

	public JMenuItem getRemoveFinancialCase() {
		return removeFinancialCase;
	}

	public void setRemoveFinancialCase(JMenuItem removeSuperiorRoom) {
		this.removeFinancialCase = removeSuperiorRoom;
	}


	public JMenuItem getRemoveFamilyCase() {
		return removeFamilyCase;
	}

	public void setRemoveFamilyCase(JMenuItem removeSuite) {
		this.removeFamilyCase = removeSuite;
	}
	
	public JMenu getAllFunctions() {
		return queries;
	}

	public void setAllFunctions(JMenu allFunctions) {
		this.queries = allFunctions;
	}

	public JMenuItem getBothSize() {
		return bothSize;
	}

	public void setBothSize(JMenuItem bothSize) {
		this.bothSize = bothSize;
	}

	public JMenuItem getFindANewManager() {
		return findANewManager;
	}

	public void setFindANewManager(JMenuItem findANewManager) {
		this.findANewManager = findANewManager;
	}

	public JMenuItem getCasesWithMoreThreeTestimoniesOfGender() {
		return casesWithMoreThreeTestimoniesOfGender;
	}

	public void setCasesWithMoreThreeTestimoniesOfGender(JMenuItem casesWithMoreThreeTestimoniesOfGender) {
		this.casesWithMoreThreeTestimoniesOfGender = casesWithMoreThreeTestimoniesOfGender;
	}

	public JMenuItem getCaseCountByDepartment() {
		return caseCountByDepartment;
	}

	public void setCaseCountByDepartment(JMenuItem caseCountByDepartment) {
		this.caseCountByDepartment = caseCountByDepartment;
	}

	public JMenuItem getSuitableLawyer() {
		return suitableLawyer;
	}

	public void setSuitableLawyer(JMenuItem suitableLawyer) {
		this.suitableLawyer = suitableLawyer;
	}

	public JMenuItem getDifferenceBetweencases() {
		return differenceBetweencases;
	}
	
	public void setDifferenceBetweencases(JMenuItem differenceBetweencases) {
		this.differenceBetweencases = differenceBetweencases;
	}

/*
 * this class is the Employee frame that contains all of the buttons to access any function in the system
 * all of the buttons are set in the main menu bar 
 * first there is an add functions button that is a drop list with the access to all of the add functions
 * and the same for the remove and getreal functions 
 * a user option button that is a drop list that has a mane menu button and a stop music button
 * and lastly a save button that saves all of the actions that were made and logs out
 */
	public MainFrame(String user) {
		
		super("Welcome to the Court system");
		if (user.matches("\\d+")) { 
		    number = Integer.parseInt(user);
		}
			
		URL music = (getClass().getClassLoader().getResource("sound.wav")); // playing lobby music at the
		AudioInputStream audio = null;
		try {
			audio = AudioSystem.getAudioInputStream(music);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    clip = null;
		try {
			 clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		try {
			clip.open(audio);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(im.getImage());
		setBounds(100, 100, 680, 540);
		setIconImage(im.getImage());
		contentPane = new BackgroundPanel();
        contentPane.setPreferredSize(new Dimension(800, 540)); // Set the preferred size of the panel
        contentPane.setLayout(null);
        setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(207, 207, 201));
		menuBar.setBounds(0, 0, 1314, 32);		
		setJMenuBar(menuBar);		
		
		addFunctions = new JMenu("addFunctins");
		addFunctions.setBackground(new Color(207, 207, 201));
		addFunctions.setForeground(new Color(0, 64, 128));
		addFunctions.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addFunctions.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(addFunctions);
		
		addAccused = new JMenuItem("AddAccused");
		addAccused.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addAccused.setForeground(new Color(0, 64, 128));
		addAccused.setBackground(new Color(207, 207, 201));
		addFunctions.add(addAccused);
		addAccused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddAccused c = new AddAccused();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addAppeal = new JMenuItem("AddAppeal");
		addAppeal.setBackground(new Color(207, 207, 201));
		addAppeal.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addAppeal.setForeground(new Color(0, 64, 128));
		addFunctions.add(addAppeal);
		addAppeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddAppeal c = new AddAppeal();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addCourtRoom = new JMenuItem("AddCourtRoom");
		addCourtRoom.setBackground(new Color(207, 207, 201));
		addCourtRoom.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addCourtRoom.setForeground(new Color(0, 64, 128));
		addFunctions.add(addCourtRoom);
		addCourtRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddCourtRoom c = new AddCourtRoom();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addCriminalCase = new JMenuItem("AddCriminalCase");
		addCriminalCase.setBackground(new Color(207, 207, 201));
		addCriminalCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addCriminalCase.setForeground(new Color(0, 64, 128));
		addFunctions.add(addCriminalCase);
		addCriminalCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddCriminalCase c = new AddCriminalCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addFinancialCase = new JMenuItem("AddFinancialCase");
		addFinancialCase.setForeground(new Color(0, 64, 128));
		addFinancialCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addFinancialCase.setBackground(new Color(207, 207, 201));
		addFunctions.add(addFinancialCase);
		addFinancialCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddFinancialCase c = new AddFinancialCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addFamilyCase = new JMenuItem("AddFamilyCase");
		addFamilyCase.setBackground(new Color(207, 207, 201));
		addFamilyCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addFamilyCase.setForeground(new Color(0, 64, 128));
		addFunctions.add(addFamilyCase);
		addFamilyCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddFamilyCase c = new AddFamilyCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addDepartment = new JMenuItem("AddDepartment");
		addDepartment.setForeground(new Color(0, 64, 128));
		addDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addDepartment.setBackground(new Color(207, 207, 201));
		addFunctions.add(addDepartment);
		addDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddDepartment c = new AddDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addDocument = new JMenuItem("AddDocument");
		addDocument.setForeground(new Color(0, 64, 128));
		addDocument.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addDocument.setBackground(new Color(207, 207, 201));
		addFunctions.add(addDocument);
		addDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
				 if(!user.equals("admin")) {
	    				userI = Integer.parseInt(user);
	             }		
				AddDocument c = new AddDocument(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addEmployee = new JMenuItem("AddEmployee");
		addEmployee.setForeground(new Color(0, 64, 128));
		addEmployee.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addEmployee.setBackground(new Color(207, 207, 201));
		addFunctions.add(addEmployee);
		addEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddEmployee c = new AddEmployee();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addJudge = new JMenuItem("AddJudge");
		addJudge.setForeground(new Color(0, 64, 128));
		addJudge.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addJudge.setBackground(new Color(207, 207, 201));
		addFunctions.add(addJudge);
		addJudge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddJudge c = new AddJudge();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addLawyer = new JMenuItem("AddLawyer");
		addLawyer.setForeground(new Color(0, 64, 128));
		addLawyer.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addLawyer.setBackground(new Color(207, 207, 201));
		addFunctions.add(addLawyer);
		addLawyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddLawyer c = new AddLawyer();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addMeeting = new JMenuItem("AddMeeting");
		addMeeting.setForeground(new Color(0, 64, 128));
		addMeeting.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addMeeting.setBackground(new Color(207, 207, 201));
		addFunctions.add(addMeeting);
		addMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
				 if(!user.equals("admin")) {
	    				userI = Integer.parseInt(user);
	             }
				AddMeeting c = new AddMeeting(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addTestimony = new JMenuItem("AddTestimony");
		addTestimony.setForeground(new Color(0, 64, 128));
		addTestimony.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addTestimony.setBackground(new Color(207, 207, 201));
		addFunctions.add(addTestimony);
		addTestimony.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddTestimony c = new AddTestimony();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addVerdict = new JMenuItem("AddVerdict");
		addVerdict.setForeground(new Color(0, 64, 128));
		addVerdict.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addVerdict.setBackground(new Color(207, 207, 201));
		addFunctions.add(addVerdict);
		addVerdict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddVerdict c = new AddVerdict();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addWitness = new JMenuItem("AddWitness");
		addWitness.setForeground(new Color(0, 64, 128));
		addWitness.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addWitness.setBackground(new Color(207, 207, 201));
		addFunctions.add(addWitness);
		addWitness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddWitness c = new AddWitness();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});

		
		workFunctions = new JMenu("workFunctions");
		workFunctions.setHorizontalAlignment(SwingConstants.CENTER);
		workFunctions.setForeground(new Color(0, 64, 128));
		workFunctions.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		workFunctions.setBackground(new Color(207, 207, 201));
		menuBar.add(workFunctions);
		
		addEmployeeToDepartment = new JMenuItem("AddEmployeeToDepartment");
		addEmployeeToDepartment.setForeground(new Color(0, 64, 128));
		addEmployeeToDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addEmployeeToDepartment.setBackground(new Color(207, 207, 201));
		workFunctions.add(addEmployeeToDepartment);
		addEmployeeToDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddEmployeeToDepartment c = new AddEmployeeToDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addJudgeToDepartment = new JMenuItem("AddJudgeToDepartment");
		addJudgeToDepartment.setForeground(new Color(0, 64, 128));
		addJudgeToDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addJudgeToDepartment.setBackground(new Color(207, 207, 201));
		workFunctions.add(addJudgeToDepartment);
		addJudgeToDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddJudgeToDepartment c = new AddJudgeToDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addLawyerToDepartment = new JMenuItem("AddLawyerToDepartment");
		addLawyerToDepartment.setForeground(new Color(0, 64, 128));
		addLawyerToDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addLawyerToDepartment.setBackground(new Color(207, 207, 201));
		workFunctions.add(addLawyerToDepartment);
		addLawyerToDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddLawyerToDepartment c = new AddLawyerToDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addLawyerToCase = new JMenuItem("AddLawyerToCase");
		addLawyerToCase.setHorizontalAlignment(SwingConstants.LEFT);
		addLawyerToCase.setForeground(new Color(0, 64, 128));
		addLawyerToCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addLawyerToCase.setBackground(new Color(207, 207, 201));
		workFunctions.add(addLawyerToCase);
		addLawyerToCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddLawyerToCase c = new AddLawyerToCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		addJudgeToCase = new JMenuItem("AddJudgeToCase");
		addJudgeToCase.setHorizontalAlignment(SwingConstants.LEFT);
		addJudgeToCase.setForeground(new Color(0, 64, 128));
		addJudgeToCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		addJudgeToCase.setBackground(new Color(207, 207, 201));
		workFunctions.add(addJudgeToCase);
		addJudgeToCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AddJudgeToCase c = new AddJudgeToCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		appealapplication = new JMenuItem("AppealApplication");
		appealapplication.setHorizontalAlignment(SwingConstants.LEFT);
		appealapplication.setForeground(new Color(0, 64, 128));
		appealapplication.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		appealapplication.setBackground(new Color(207, 207, 201));
		workFunctions.add(appealapplication);
		appealapplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AppealApplication c = new AppealApplication();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		appealapproval = new JMenuItem("AppealApproval");
		appealapproval.setHorizontalAlignment(SwingConstants.LEFT);
		appealapproval.setForeground(new Color(0, 64, 128));
		appealapproval.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		appealapproval.setBackground(new Color(207, 207, 201));
		workFunctions.add(appealapproval);
		appealapproval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				AppealApproval c = new AppealApproval();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		updateCriminalCase = new JMenuItem("UpdateCriminalCase");
		updateCriminalCase.setHorizontalAlignment(SwingConstants.LEFT);
		updateCriminalCase.setForeground(new Color(0, 64, 128));
		updateCriminalCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		updateCriminalCase.setBackground(new Color(207, 207, 201));
		workFunctions.add(updateCriminalCase);
		updateCriminalCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				Updatecase c = new Updatecase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		updatefamilyCase = new JMenuItem("UpdateFamilyCase");
		updatefamilyCase.setHorizontalAlignment(SwingConstants.LEFT);
		updatefamilyCase.setForeground(new Color(0, 64, 128));
		updatefamilyCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		updatefamilyCase.setBackground(new Color(207, 207, 201));
		workFunctions.add(updatefamilyCase);
		updatefamilyCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				UpdateFamilyCase c = new UpdateFamilyCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		updatefinancialCase = new JMenuItem("UpdateFinancialCase");
		updatefinancialCase.setHorizontalAlignment(SwingConstants.LEFT);
		updatefinancialCase.setForeground(new Color(0, 64, 128));
		updatefinancialCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		updatefinancialCase.setBackground(new Color(207, 207, 201));
		workFunctions.add(updatefinancialCase);
		updatefinancialCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				UpdateFinancialCase c = new UpdateFinancialCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		visitorLog = new JMenuItem("VisitorsLog");
		visitorLog.setHorizontalAlignment(SwingConstants.LEFT);
		visitorLog.setForeground(new Color(0, 64, 128));
		visitorLog.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		visitorLog.setBackground(new Color(207, 207, 201));
		workFunctions.add(visitorLog);
		visitorLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				VisitorsLog c = new VisitorsLog();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		meetingCalander = new JMenuItem("MeetingCalander");
		meetingCalander.setForeground(new Color(0, 64, 128));
		meetingCalander.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		meetingCalander.setBackground(new Color(207, 207, 201));
		workFunctions.add(meetingCalander);
		meetingCalander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				MeetingCalendar c = new MeetingCalendar();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});


		
		removeFunctions = new JMenu("removeFunctions");
		removeFunctions.setBackground(new Color(207, 207, 201));
		removeFunctions.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeFunctions.setForeground(new Color(0, 64, 128));
		menuBar.add(removeFunctions);

		
		removeAccused = new JMenuItem("RemoveAccused");
		removeAccused.setBackground(new Color(207, 207, 201));
		removeAccused.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeAccused.setForeground(new Color(0, 64, 128));
		removeFunctions.add(removeAccused);
		removeAccused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveAccused c = new RemoveAccused();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeAppeal = new JMenuItem("RemoveAppeal");
		removeAppeal.setForeground(new Color(0, 64, 128));
		removeAppeal.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeAppeal.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeAppeal);
		removeAppeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveAppeal c = new RemoveAppeal();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeCourtRoom = new JMenuItem("RemoveCourtRoom");
		removeCourtRoom.setForeground(new Color(0, 64, 128));
		removeCourtRoom.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeCourtRoom.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeCourtRoom);
		removeCourtRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveCourtRoom c = new RemoveCourtRoom();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		
		removeCriminalCase = new JMenuItem("RemoveCriminalCase");
		removeCriminalCase.setForeground(new Color(0, 64, 128));
		removeCriminalCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeCriminalCase.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeCriminalCase);
		removeCriminalCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveCriminalCase c = new RemoveCriminalCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeFinancialCase = new JMenuItem("RemoveFinancialCase");
		removeFinancialCase.setForeground(new Color(0, 64, 128));
		removeFinancialCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeFinancialCase.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeFinancialCase);
		removeFinancialCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveFinancialCase c = new RemoveFinancialCase();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeFamilyCase = new JMenuItem("RemoveFamilyCase");
		removeFamilyCase.setForeground(new Color(0, 64, 128));
		removeFamilyCase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeFamilyCase.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeFamilyCase);
		removeFamilyCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveFamilyCase c = new RemoveFamilyCase();				
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeDepartment = new JMenuItem("RemoveDepartment");
		removeDepartment.setForeground(new Color(0, 64, 128));
		removeDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeDepartment.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeDepartment);
		removeDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveDepartment c = new RemoveDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeDocument = new JMenuItem("RemoveDocument");
		removeDocument.setForeground(new Color(0, 64, 128));
		removeDocument.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeDocument.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeDocument);
		addDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveDocument c = new RemoveDocument();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeEmployee = new JMenuItem("RemoveEmployee");
		removeEmployee.setForeground(new Color(0, 64, 128));
		removeEmployee.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeEmployee.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeEmployee);
		removeEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveEmployee c = new RemoveEmployee();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeLawyer = new JMenuItem("RemoveLawyer");
		removeLawyer.setForeground(new Color(0, 64, 128));
		removeLawyer.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeLawyer.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeLawyer);
		removeLawyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveLawyer c = new RemoveLawyer();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeJudge = new JMenuItem("RemoveJudge");
		removeJudge.setForeground(new Color(0, 64, 128));
		removeJudge.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeJudge.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeJudge);
		removeJudge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveJudge c = new RemoveJudge();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeMeeting = new JMenuItem("RemoveMeeting");
		removeMeeting.setForeground(new Color(0, 64, 128));
		removeMeeting.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeMeeting.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeMeeting);
		removeMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveMeeting c = new RemoveMeeting();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeTestimony = new JMenuItem("RemoveTestimony");
		removeTestimony.setForeground(new Color(0, 64, 128));
		removeTestimony.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeTestimony.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeTestimony);
		removeTestimony.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveTestimony c = new RemoveTestimony();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeVerdict_1 = new JMenuItem("RemoveVerdict");
		removeVerdict_1.setForeground(new Color(0, 64, 128));
		removeVerdict_1.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeVerdict_1.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeVerdict_1);
		removeVerdict_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveVerdict c = new RemoveVerdict();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		removeWitness = new JMenuItem("RemoveWitness");
		removeWitness.setForeground(new Color(0, 64, 128));
		removeWitness.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		removeWitness.setBackground(new Color(207, 207, 201));
		removeFunctions.add(removeWitness);
		removeWitness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				RemoveWitness c = new RemoveWitness();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		getRealFunc = new JMenu("GetRealFunctions");
		getRealFunc.setForeground(new Color(0, 64, 128));
		getRealFunc.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		getRealFunc.setBackground(new Color(207, 207, 201));
		menuBar.add(getRealFunc);
		
		GetrealAccused = new JMenuItem("GetRealAccused");
		GetrealAccused.setForeground(new Color(0, 64, 128));
		GetrealAccused.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealAccused.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealAccused);
		GetrealAccused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
				 if(!user.equals("admin")) {
	    				userI = Integer.parseInt(user);
	             }
				GetRealAccused c = new GetRealAccused(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealAppeal = new JMenuItem("GetRealAppeal");
		GetrealAppeal.setForeground(new Color(0, 64, 128));
		GetrealAppeal.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealAppeal.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealAppeal);
		GetrealAppeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealAppeal c = new GetRealAppeal();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealCourtroom = new JMenuItem("GetRealCourtRoom");
		GetrealCourtroom.setForeground(new Color(0, 64, 128));
		GetrealCourtroom.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealCourtroom.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealCourtroom);
		GetrealCourtroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealCourtRoom c = new GetRealCourtRoom();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealCriminalcase = new JMenuItem("GetRealCriminalCase");
		GetrealCriminalcase.setForeground(new Color(0, 64, 128));
		GetrealCriminalcase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealCriminalcase.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealCriminalcase);
		GetrealCriminalcase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
                if(!user.equals("admin")) {
    				userI = Integer.parseInt(user);
                }
				GetRealCriminalcase c = new GetRealCriminalcase(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealFinancialcase = new JMenuItem("GetRealFinancialCase");
		GetrealFinancialcase.setForeground(new Color(0, 64, 128));
		GetrealFinancialcase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealFinancialcase.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealFinancialcase);
		GetrealFinancialcase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
				 if(!user.equals("admin")) {
	    				userI = Integer.parseInt(user);
	             }				
				GetRealFinancialCase c = new GetRealFinancialCase(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealFamilycase = new JMenuItem("GetRealFamilyCase");
		GetrealFamilycase.setForeground(new Color(0, 64, 128));
		GetrealFamilycase.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealFamilycase.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealFamilycase);
		GetrealFamilycase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
				 if(!user.equals("admin")) {
	    				userI = Integer.parseInt(user);
	             }	
				GetRealFamilyCase c = new GetRealFamilyCase(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealDepartment = new JMenuItem("GetRealDepartment");
		GetrealDepartment.setForeground(new Color(0, 64, 128));
		GetrealDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealDepartment.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealDepartment);
		GetrealDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealDepartment c = new GetRealDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealDocument = new JMenuItem("GetRealDocument");
		GetrealDocument.setForeground(new Color(0, 64, 128));
		GetrealDocument.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealDocument.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealDocument);
		GetrealDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealDocument c = new GetRealDocument();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetRealEmployee = new JMenuItem("GetRealEmployee");
		GetRealEmployee.setForeground(new Color(0, 64, 128));
		GetRealEmployee.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetRealEmployee.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetRealEmployee);
		GetRealEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealEmployee c = new GetRealEmployee();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealLawyer = new JMenuItem("GetRealLawyer");
		GetrealLawyer.setForeground(new Color(0, 64, 128));
		GetrealLawyer.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealLawyer.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealLawyer);
		GetrealLawyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealLawyer c = new GetRealLawyer();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealJudge = new JMenuItem("GetRealJudge");
		GetrealJudge.setForeground(new Color(0, 64, 128));
		GetrealJudge.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealJudge.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealJudge);
		GetrealJudge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealJudge c = new GetRealJudge();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		realMeeting = new JMenuItem("GetRealMeeting");
		realMeeting.setForeground(new Color(0, 64, 128));
		realMeeting.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		realMeeting.setBackground(new Color(207, 207, 201));
		getRealFunc.add(realMeeting);
		realMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userI=0;
				getContentPane().setVisible(false);
				 if(!user.equals("admin")) {
	    				userI = Integer.parseInt(user);
	             }
				GetRealMeeting c = new GetRealMeeting(userI);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		GetrealTestimony = new JMenuItem("GetRealTestimony");
		GetrealTestimony.setForeground(new Color(0, 64, 128));
		GetrealTestimony.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		GetrealTestimony.setBackground(new Color(207, 207, 201));
		getRealFunc.add(GetrealTestimony);
		GetrealTestimony.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealTestimony c = new GetRealTestimony();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		getRealVerdict = new JMenuItem("GetRealVerdict");
		getRealVerdict.setForeground(new Color(0, 64, 128));
		getRealVerdict.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		getRealVerdict.setBackground(new Color(207, 207, 201));
		getRealFunc.add(getRealVerdict);
		getRealVerdict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealVerdict c = new GetRealVerdict();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		getrealWitness = new JMenuItem("GetRealWitness");
		getrealWitness.setForeground(new Color(0, 64, 128));
		getrealWitness.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		getrealWitness.setBackground(new Color(207, 207, 201));
		getRealFunc.add(getrealWitness);
		getrealWitness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				GetRealWitness c = new GetRealWitness();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		queries = new JMenu("allQueries");
		queries.setForeground(new Color(0, 64, 128));
		queries.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		queries.setBackground(new Color(207, 207, 201));
		menuBar.add(queries);
		
		bothSize = new JMenuItem("FamilyCasesWithWitnessesOnBothSides");
		bothSize.setForeground(new Color(0, 64, 128));
		bothSize.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		bothSize.setBackground(new Color(207, 207, 201));
		queries.add(bothSize);
		bothSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FamilyCasesWithBothSideWitnesses c = new FamilyCasesWithBothSideWitnesses();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		findANewManager = new JMenuItem("FindANewManager");
		findANewManager.setForeground(new Color(0, 64, 128));
		findANewManager.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		findANewManager.setBackground(new Color(207, 207, 201));
		queries.add(findANewManager);
		findANewManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FindAnewManager c = new FindAnewManager();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		
		casesWithMoreThreeTestimoniesOfGender = new JMenuItem("CasesWithMoreThan3TestimoniesOfGender");
		casesWithMoreThreeTestimoniesOfGender.setForeground(new Color(0, 64, 128));
		casesWithMoreThreeTestimoniesOfGender.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		casesWithMoreThreeTestimoniesOfGender.setBackground(new Color(207, 207, 201));
		queries.add(casesWithMoreThreeTestimoniesOfGender);
		casesWithMoreThreeTestimoniesOfGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FindCasesWithMoreThanThreeTestimonies c = new FindCasesWithMoreThanThreeTestimonies();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		caseCountByDepartment = new JMenuItem("FindInActiveCaseCountByDepartment");
		caseCountByDepartment.setForeground(new Color(0, 64, 128));
		caseCountByDepartment.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		caseCountByDepartment.setBackground(new Color(207, 207, 201));
		queries.add(caseCountByDepartment);
		caseCountByDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FindInActiveCaseCountByDepartment c = new FindInActiveCaseCountByDepartment();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		suitableLawyer = new JMenuItem("FindASuitableLawyer");
		suitableLawyer.setForeground(new Color(0, 64, 128));
		suitableLawyer.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		suitableLawyer.setBackground(new Color(207, 207, 201));
		queries.add(suitableLawyer);
		suitableLawyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FindsuitableLawyer c = new FindsuitableLawyer();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		differenceBetweencases = new JMenuItem("FindDifferenceBetweenCases");
		differenceBetweencases.setForeground(new Color(0, 64, 128));
		differenceBetweencases.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		differenceBetweencases.setBackground(new Color(207, 207, 201));
		queries.add(differenceBetweencases);
		differenceBetweencases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FindTheDifferenceBetweenCases c = new FindTheDifferenceBetweenCases();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		uniqeCrimeTools = new JMenuItem("FindUniqeCrimeToolsByCrimeScene");
		uniqeCrimeTools.setForeground(new Color(0, 64, 128));
		uniqeCrimeTools.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		uniqeCrimeTools.setBackground(new Color(207, 207, 201));
		queries.add(uniqeCrimeTools);
		uniqeCrimeTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				FindUniqeCrimeTools c = new FindUniqeCrimeTools();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		howManyCases = new JMenuItem("HowMAnyCasesBeforeDate");
		howManyCases.setForeground(new Color(0, 64, 128));
		howManyCases.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		howManyCases.setBackground(new Color(207, 207, 201));
		queries.add(howManyCases);
		howManyCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				HowManyCasesBefore c = new HowManyCasesBefore();
				setContentPane(c);
				getContentPane().setVisible(true);
			}
		});
		
		
		userOpt = new JMenu("User Options");
		userOpt.setForeground(new Color(0, 64, 128));
		userOpt.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		userOpt.setBackground(new Color(207, 207, 201));
		menuBar.add(userOpt);
		
		mainMenue = new JMenuItem("MainMenue");
		mainMenue.setForeground(new Color(0, 64, 128));
		mainMenue.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		mainMenue.setBackground(new Color(207, 207, 201));
		userOpt.add(mainMenue);
		mainMenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				setContentPane(contentPane);
				getContentPane().setVisible(true);
			}
		});
		
		stopMusic = new JMenuItem("Stop Music");
		stopMusic.setForeground(new Color(0, 64, 128));
		stopMusic.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		stopMusic.setBackground(new Color(207, 207, 201));
		userOpt.add(stopMusic);
		stopMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				if(stopMusic.getText().equals("Stop Music")) {
					stopMusic.setText("Start Music");
					clip.stop();
					i++;
				}
				if(i == 0) {
					stopMusic.setText("Stop Music");
					clip.start();
				}
			}
		});
		
		
		save = new JMenuItem("Save");
		save.setForeground(new Color(0, 64, 128));
		save.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		save.setBackground(new Color(207, 207, 201));
		menuBar.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "By clicking this button, you are saving everything and loging-out", "Thank you for using our system", JOptionPane.INFORMATION_MESSAGE);
                clip.stop();
				dispose();
				SerializationHelp.saveCourt(Court.getInstance());
                Login lf = new Login();
                lf.setVisible(true);
			}
		});
		
		
	if(Court.getInstance().getAllLawyers().containsKey(number)) {
		if(Court.getInstance().getRealLawyer(number) instanceof Judge) {
			addAccused.setVisible(false);
			addCourtRoom.setVisible(false);
			addDepartment.setVisible(false);
			addDocument.setVisible(false);
			addCriminalCase.setVisible(false);
			addFamilyCase.setVisible(false);
			addFinancialCase.setVisible(false);
			addEmployee.setVisible(false);
			addEmployeeToDepartment.setVisible(false);
			addJudge.setVisible(false);
			addJudgeToCase.setVisible(false);
			addJudgeToDepartment.setVisible(false);
			addLawyer.setVisible(false);
			addLawyerToCase.setVisible(false);
			addLawyerToDepartment.setVisible(false);
			addTestimony.setVisible(false);
			addWitness.setVisible(false);
			getRealVerdict.setVisible(false);
			GetrealAccused.setVisible(false);
			GetrealAppeal.setVisible(false);
			GetRealEmployee.setVisible(false);
			GetrealCourtroom.setVisible(false);
			GetrealDepartment.setVisible(false);
			GetrealDocument.setVisible(false);
			GetrealJudge.setVisible(false);
			GetrealLawyer.setVisible(false);
			GetrealTestimony.setVisible(false);
			getrealWitness.setVisible(false);
			queries.setVisible(false);
			removeFunctions.setVisible(false);
			appealapplication.setVisible(false);
			updateCriminalCase.setVisible(false);
			updatefinancialCase.setVisible(false);
			updatefamilyCase.setVisible(false);

		}else {
				addAccused.setVisible(false);
				addCourtRoom.setVisible(false);
				addDepartment.setVisible(false);
				addCriminalCase.setVisible(false);
				addFamilyCase.setVisible(false);
				addMeeting.setVisible(false);
				addAppeal.setVisible(false);
				addFinancialCase.setVisible(false);
				addVerdict.setVisible(false);
				addEmployee.setVisible(false);
				addEmployeeToDepartment.setVisible(false);
				addJudge.setVisible(false);
				addJudgeToCase.setVisible(false);
				addJudgeToDepartment.setVisible(false);
				addLawyer.setVisible(false);
				addLawyerToCase.setVisible(false);
				addLawyerToDepartment.setVisible(false);
				addTestimony.setVisible(false);
				addWitness.setVisible(false);
				getRealVerdict.setVisible(false);
				GetrealAppeal.setVisible(false);
				GetRealEmployee.setVisible(false);
				GetrealCourtroom.setVisible(false);
				GetrealDepartment.setVisible(false);
				GetrealDocument.setVisible(false);
				GetrealJudge.setVisible(false);
				GetrealLawyer.setVisible(false);
				GetrealTestimony.setVisible(false);
				getrealWitness.setVisible(false);
				queries.setVisible(false);
				removeFunctions.setVisible(false);
				appealapproval.setVisible(false);
				updateCriminalCase.setVisible(false);
				updatefinancialCase.setVisible(false);
				updatefamilyCase.setVisible(false);
		
	  }
	}else if(Court.getInstance().getAllEmployees().containsKey(number)) {
		addVerdict.setVisible(false);
		addMeeting.setVisible(false);
		addEmployee.setVisible(false);
		addDocument.setVisible(false);
		addEmployeeToDepartment.setVisible(false);
		addJudge.setVisible(false);
		addLawyer.setVisible(false);
		realMeeting.setVisible(false);
		meetingCalander.setVisible(false);
		addTestimony.setVisible(false);
		addWitness.setVisible(false);
		getRealVerdict.setVisible(false);
		GetrealAppeal.setVisible(false);
		GetRealEmployee.setVisible(false);
		GetrealDocument.setVisible(false);
		GetrealJudge.setVisible(false);
		GetrealLawyer.setVisible(false);
		GetrealTestimony.setVisible(false);
		getrealWitness.setVisible(false);
		queries.setVisible(false);
		removeAccused.setVisible(false);
		removeAppeal.setVisible(false);
		removeCriminalCase.setVisible(false);
		removeDocument.setVisible(false);
		removeEmployee.setVisible(false);
		removeFamilyCase.setVisible(false);
		removeFinancialCase.setVisible(false);
		removeJudge.setVisible(false);
		removeLawyer.setVisible(false);
		removeMeeting.setVisible(false);
		removeTestimony.setVisible(false);
		removeVerdict_1.setVisible(false);
		removeWitness.setVisible(false);
		appealapproval.setVisible(false);
		appealapplication.setVisible(false);		
	}
	
  }
}

