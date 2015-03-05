package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import api.DatePicker;

public class GuiMain {


	public static void main (String [] args){
		//Declaration of Frames and panels
		JFrame frame = new JFrame();
		JTabbedPane pane = new JTabbedPane();
		JPanel addMembers = new JPanel();
		JPanel viewMembers = new JPanel();
		JPanel editMembers = new JPanel();
		JPanel deleteMembers = new JPanel();
		
		
		
		//Add Members
			
		JTabbedPane addMembersPane = new JTabbedPane();
		JPanel personalPanel = new JPanel(new GridLayout(0,1));
		JPanel paymentPanel = new JPanel(new GridLayout(0,1));
		//Personal
		JPanel buttonPanel = new JPanel();
		
		JLabel jobAssignmentLabel = new JLabel("Job Assignment");
		JLabel sleepingLocationLabel = new JLabel ("Sleeping Location");
		JLabel healthFormLabel = new JLabel ("Health Form");
		JLabel verifyInfo = new JLabel ("Please verify your information");
		JLabel dateOfBirthLabel = new JLabel("DOB");
		JLabel emailAddressLabel = new JLabel("Email Address");
		JLabel boyScoutIDLabel = new JLabel("BSA ID");
		JLabel unitTypeLabel = new JLabel("Unit Type");
		JLabel unitNumberLabel = new JLabel("Unit Number");
		JLabel nameLabel = new JLabel("Name");
		JLabel oAIDLabel = new JLabel("Order of the Arrow ID");
		
		String[] dayArray = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] monthArray = {"January","February", "March","April","May","June","July","August","September","October","November","December"};
				
		
		JComboBox jobAssignmentBox = new JComboBox();
		JComboBox sleepingLocationBox = new JComboBox();
		JComboBox healthFormBox = new JComboBox();
		JComboBox dayBox = new JComboBox(dayArray);
		JComboBox monthBox = new JComboBox(monthArray);
		JComboBox yearBox = new JComboBox();
		
		
		
		
		final JTextField dateOfBirthField = new JTextField();
		final JTextField emailAddressField = new JTextField();
		final JTextField boyScoutIDField	= new JTextField();
		final JTextField unitTypeField = new JTextField();
		final JTextField unitNumberField = new JTextField();
		final JTextField oAIDField = new JTextField();
		final JTextField nameField = new JTextField();
		
		JButton acceptButton = new JButton("Accept");
		JButton clearButton = new JButton("Clear");
		JButton dateInput = new JButton("Select Date");
		
		
		personalPanel.add(jobAssignmentLabel);
		personalPanel.add(jobAssignmentBox);
		
		personalPanel.add(sleepingLocationLabel);
		personalPanel.add(sleepingLocationBox);
		
		personalPanel.add(healthFormLabel);
		personalPanel.add(healthFormBox);
		
		personalPanel.add(verifyInfo);
		
		personalPanel.add(nameLabel);
		personalPanel.add(nameField);
		
		personalPanel.add(dateOfBirthLabel);
		personalPanel.add(dateInput);
		personalPanel.add(dateOfBirthField);
		
		personalPanel.add(emailAddressLabel);
		personalPanel.add(emailAddressField);
		
		personalPanel.add(boyScoutIDLabel);
		personalPanel.add(boyScoutIDField);
		
		personalPanel.add(unitTypeLabel);
		personalPanel.add(unitTypeField);
		
		personalPanel.add(unitNumberLabel);
		personalPanel.add(unitNumberField);
		
		personalPanel.add(oAIDLabel);
		personalPanel.add(oAIDField);
		
		
		personalPanel.add(buttonPanel);
		buttonPanel.add(acceptButton);
		buttonPanel.add(clearButton);
		
		// Date Picker
		dateInput.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				final JFrame f = new JFrame();
				f.setLocationRelativeTo(null);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				dateOfBirthField.setText(new DatePicker(f).setPickedDate());
				f.setVisible(false);
			}
		});
		
		//Button action assignments
		acceptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

//				Member inputtedMember = new Member(nameField.getText(), dateOfBirthField.getText(), oAIDField.getText(), boyScoutIDField.getText(), emailAddressField.getText(), unitTypeField.getText(), unitNumberField.getText(), healthFormBox.getSelectedItem(), jobAssignmentBox.getSelectedItem(), sleepingLocationBox.getSelectedItem());
				
			}
		});
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				dateOfBirthField.setText("");
				emailAddressField.setText("");
				boyScoutIDField.setText("");
				unitNumberField.setText("");
				unitTypeField.setText("");
				oAIDField.setText("");
				nameField.setText("");
				
			}
		});
		
		
		//Payment
		JLabel paymentLabel = new JLabel("Payment");
		JLabel mealsLabel = new JLabel("Meals");
		JTextField paymentTextField = new JTextField();
		
		paymentPanel.add(paymentLabel);
		paymentPanel.add(paymentTextField);
		paymentPanel.add(mealsLabel);
		
		//TODO Get info from Database
		for (int i = 0; i < args.length; i++) {
			
		}
		
		
		
		addMembersPane.add("Personal", personalPanel);
		addMembersPane.add("Payment", paymentPanel);
		
		
		
		//Edit Members
		final JFrame searchResults = new JFrame();
		JPanel buttonPanel2 = new JPanel();
		JLabel infoPrompt = new JLabel("Please enter a name to search");
		final JTextField infoPromptField = new JTextField();
		JButton goButton = new JButton("Go");
		JButton clearButton2 = new JButton("Clear");
		JPanel searchResultsPanel = new JPanel(new GridLayout (0,1));
		
		
		infoPromptField.setColumns(4);
		editMembers.add(infoPrompt);
		editMembers.add(infoPromptField);
		searchResults.add(searchResultsPanel);
		searchResults.pack();
		
		
		buttonPanel2.add(goButton);
		buttonPanel2.add(clearButton2);
		editMembers.add(buttonPanel2, BorderLayout.SOUTH);
		//Edit Member Button Actions
		goButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			searchResults.setVisible(true);
				
			}
		});
		
		clearButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infoPromptField.setText("");
				
			}
		});
		
		JLabel jobAssignmentLabel2 = new JLabel("Job Assignment");
		JLabel sleepingLocationLabel2 = new JLabel ("Sleeping Location");
		JLabel healthFormLabel2 = new JLabel ("Health Form");
		JLabel verifyInfo2 = new JLabel ("Please verify your information");
		JLabel dateOfBirthLabel2 = new JLabel("DOB");
		JLabel emailAddressLabel2 = new JLabel("Email Address");
		JLabel boyScoutIDLabel2 = new JLabel("BSA ID");
		JLabel unitTypeLabel2 = new JLabel("Unit Type");
		JLabel unitNumberLabel2 = new JLabel("Unit Number");
		
		
		JComboBox jobAssignmentBox2 = new JComboBox();
		JComboBox sleepingLocationBox2 = new JComboBox();
		JComboBox healthFormBox2 = new JComboBox();
		
		JTextField dateOfBirthField2 = new JTextField();
		JTextField emailAddressField2 = new JTextField();
		JTextField boyScoutIDField2	= new JTextField();
		JTextField unitTypeField2 = new JTextField();
		JTextField unitNumberField2 = new JTextField();
		
		searchResultsPanel.add(jobAssignmentLabel2);
		searchResultsPanel.add(jobAssignmentBox2);
		
		searchResultsPanel.add(sleepingLocationLabel2);
		searchResultsPanel.add(sleepingLocationBox2);
		
		searchResultsPanel.add(healthFormLabel2);
		searchResultsPanel.add(healthFormBox2);
		
		
		searchResultsPanel.add(verifyInfo2);
		
		searchResultsPanel.add(dateOfBirthLabel2);
		searchResultsPanel.add(dateOfBirthField2);
		
		searchResultsPanel.add(emailAddressLabel2);
		searchResultsPanel.add(emailAddressField2);
		
		searchResultsPanel.add(boyScoutIDLabel2);
		searchResultsPanel.add(boyScoutIDField2);
		
		searchResultsPanel.add(unitTypeLabel2);
		searchResultsPanel.add(unitTypeField2);
		
		searchResultsPanel.add(unitNumberLabel2);
		searchResultsPanel.add(unitNumberField2);
		
		searchResults.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pane.addTab("Add Members", addMembersPane);
		pane.addTab("View Members", viewMembers);
		pane.addTab("Edit Members", editMembers);
		pane.addTab("Delete Members", deleteMembers);
		
		
				
	
		frame.add(pane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(450, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
