package api;

import java.util.Date;

public class SleepingLocation {
//In this class we need name, location, and "boolean is available", dates available
	private String name;
	private String location;
	private boolean isAvaiable;
	private Date dateAvaiable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAvaiable() {
		return isAvaiable;
	}
	public void setAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
	}
	public Date getDateAvaiable() {
		return dateAvaiable;
	}
	public void setDateAvaiable(Date dateAvaiable) {
		this.dateAvaiable = dateAvaiable;
	}
	
}
