package api;

import java.util.Date;

public class Member {
private String memberName;
private Date dateOfBirth;
private Integer oAID;
private Integer bSAID;
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
public Integer getoAID() {
	return oAID;
}
public void setoAID(Integer oAID) {
	this.oAID = oAID;
}
public Integer getbSAID() {
	return bSAID;
}
public void setbSAID(Integer bSAID) {
	this.bSAID = bSAID;
}



}
