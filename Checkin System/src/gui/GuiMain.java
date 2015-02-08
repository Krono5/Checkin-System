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

public class GuiMain {


	public static void main (String [] args){
		//Declaration of Frames and panels
		JFrame frame = new JFrame();
		JTabbedPane pane = new JTabbedPane();
		
		JPanel viewMembers = new JPanel();
		JPanel editMembers = new JPanel();
		JPanel deleteMembers = new JPanel();
		
		AddMember test = new AddMember();
		
		//Add Members
			
		
		AddMember();
		
		
		personalPanel.add(jobAssignmentBox);
		
		personalPanel.add(sleepingLocationLabel);
		personalPanel.add(sleepingLocationBox);
		
		personalPanel.add(healthFormLabel);
		personalPanel.add(healthFormBox);
		
		personalPanel.add(verifyInfo);
		personalPanel.add(dateOfBirthLabel);
		personalPanel.add(dateOfBirthField);
		
		personalPanel.add(emailAddressLabel);
		personalPanel.add(emailAddressField);
		
		personalPanel.add(boyScoutIDLabel);
		personalPanel.add(boyScoutIDField);
		
		personalPanel.add(unitTypeLabel);
		personalPanel.add(unitTypeField);
		
		personalPanel.add(unitNumberLabel);
		personalPanel.add(unitNumberField);
		
		personalPanel.add(buttonPanel);
		buttonPanel.add(acceptButton);
		buttonPanel.add(clearButton);
		
		//Button action assignments
		acceptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Change output function
				System.out.println("Test1");
				
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
