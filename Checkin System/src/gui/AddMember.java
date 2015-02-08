package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AddMember {
	private JPanel addMembers = new JPanel();
	private JTabbedPane addMembersPane = new JTabbedPane();
	private JPanel personalPanel = new JPanel(new GridLayout(0,1));
	private JPanel paymentPanel = new JPanel(new GridLayout(0,1));
	//Personal
	private JPanel buttonPanel = new JPanel();
	
	private JLabel jobAssignmentLabel = new JLabel("Job Assignment");
	private JLabel sleepingLocationLabel = new JLabel ("Sleeping Location");
	private JLabel healthFormLabel = new JLabel ("Health Form");
	private JLabel verifyInfo = new JLabel ("Please verify your information");
	private JLabel dateOfBirthLabel = new JLabel("DOB");
	private JLabel emailAddressLabel = new JLabel("Email Address");
	private JLabel boyScoutIDLabel = new JLabel("BSA ID");
	private JLabel unitTypeLabel = new JLabel("Unit Type");
	private JLabel unitNumberLabel = new JLabel("Unit Number");
	
	
	private JComboBox jobAssignmentBox = new JComboBox();
	private JComboBox sleepingLocationBox = new JComboBox();
	private JComboBox healthFormBox = new JComboBox();
	
	private final JTextField dateOfBirthField = new JTextField();
	private final JTextField emailAddressField = new JTextField();
	private final JTextField boyScoutIDField	= new JTextField();
	private final JTextField unitTypeField = new JTextField();
	private final JTextField unitNumberField = new JTextField();
	
	private JButton acceptButton = new JButton("Accept");
	private JButton clearButton = new JButton("Clear");
	
	
	public AddMember(){
		personalPanel.add(jobAssignmentLabel);
	}
	
}
