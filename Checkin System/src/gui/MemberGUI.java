package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MemberGUI {
	JPanel addMembers = new JPanel();
	//Add Members
	
			JTabbedPane addMembersPane = new JTabbedPane();
			private JPanel personalPanel = new JPanel(new GridLayout(0,1));
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
			
			
			JComboBox jobAssignmentBox = new JComboBox();
			JComboBox sleepingLocationBox = new JComboBox();
			JComboBox healthFormBox = new JComboBox();
			
			JTextField dateOfBirthField = new JTextField();
			JTextField emailAddressField = new JTextField();
			JTextField boyScoutIDField	= new JTextField();
			JTextField unitTypeField = new JTextField();
			JTextField unitNumberField = new JTextField();
			
			JButton acceptButton = new JButton("Accept");
			JButton clearButton = new JButton("Clear");
			
			
			personalPanel.add(jobAssignmentLabel);
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
			
}
