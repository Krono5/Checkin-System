package api;

import java.util.Date;

public class Member {
	private String memberName;
	private Date dateOfBirth;
	private String oAID;
	private String bSAID;
	private String emailAddress;
	private String unitType;
	private Integer unitNumber;
	private boolean healthForm;
	private String jobAssignment;
	private String sleepingLocation;
	
	

	public Member() {
		this.memberName = null;
		this.dateOfBirth = null;
		this.oAID = null;
		this.bSAID = null;
	}

	public Member(String memberName, Date dateOfBirth, String oAID,
			String bSAID, String emailAddress, String unitType, Integer unitNumber, boolean healthForm, String jobAssignment, String sleepingLocation) {
		memberName = this.memberName;
		dateOfBirth = this.dateOfBirth;
		oAID = this.oAID;
		bSAID = this.bSAID;
		emailAddress = this.emailAddress;
		unitType = this.unitType;
		unitNumber = this.unitNumber;
		healthForm = this.healthForm;
		jobAssignment = this.jobAssignment;
		sleepingLocation = this.sleepingLocation;
		
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getoAID() {
		return oAID;
	}

	public void setoAID(String oAID) {
		this.oAID = oAID;
	}

	public String getbSAID() {
		return bSAID;
	}

	public void setbSAID(String bSAID) {
		this.bSAID = bSAID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public Integer getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(Integer unitNumber) {
		this.unitNumber = unitNumber;
	}

	public boolean isHealthForm() {
		return healthForm;
	}

	public void setHealthForm(boolean healthForm) {
		this.healthForm = healthForm;
	}

	public String getJobAssignment() {
		return jobAssignment;
	}

	public void setJobAssignment(String jobAssignment) {
		this.jobAssignment = jobAssignment;
	}

	public String getSleepingLocation() {
		return sleepingLocation;
	}

	public void setSleepingLocation(String sleepingLocation) {
		this.sleepingLocation = sleepingLocation;
	}

}
