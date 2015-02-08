package api;

public class JobAssignment {
//This class need Job Title, Job Location, Admin name, Integer for space available, 
	private String jobTitle;
	private String jobLocation;
	private String adminName;
	private Integer spaceAvaibale;
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Integer getSpaceAvaibale() {
		return spaceAvaibale;
	}
	public void setSpaceAvaibale(Integer spaceAvaibale) {
		this.spaceAvaibale = spaceAvaibale;
	}
	
}
