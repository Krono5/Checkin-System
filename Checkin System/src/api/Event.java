package api;

public class Event {
	private String active;
	private String name;
	private String jobAssignments;
	private String sleepingLocations;
	private String mealsFees;
	private String fullWeekendFee;
	private String discountWeekendFee;
	private String dynamicFields;
	
	public Event(String name){
		this.name = name;
	}

	/**
	 * @return the active
	 */
	public String getActive(){
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active){
		this.active = active;
	}

	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * @return the jobAssignments
	 */
	public String getJobAssignments(){
		return jobAssignments;
	}

	/**
	 * @param jobAssignments the jobAssignments to set
	 */
	public void setJobAssignments(String jobAssignments){
		this.jobAssignments = jobAssignments;
	}

	/**
	 * @return the sleepingLocations
	 */
	public String getSleepingLocations(){
		return sleepingLocations;
	}

	/**
	 * @param sleepingLocations the sleepingLocations to set
	 */
	public void setSleepingLocations(String sleepingLocations){
		this.sleepingLocations = sleepingLocations;
	}

	/**
	 * @return the mealsFees
	 */
	public String getMealsFees(){
		return mealsFees;
	}

	/**
	 * @param mealsFees the mealsFees to set
	 */
	public void setMealsFees(String mealsFees){
		this.mealsFees = mealsFees;
	}

	/**
	 * @return the fullWeekendFee
	 */
	public String getFullWeekendFee(){
		return fullWeekendFee;
	}

	/**
	 * @param fullWeekendFee the fullWeekendFee to set
	 */
	public void setFullWeekendFee(String fullWeekendFee){
		this.fullWeekendFee = fullWeekendFee;
	}

	/**
	 * @return the discountWeekendFee
	 */
	public String getDiscountWeekendFee(){
		return discountWeekendFee;
	}

	/**
	 * @param discountWeekendFee the discountWeekendFee to set
	 */
	public void setDiscountWeekendFee(String discountWeekendFee){
		this.discountWeekendFee = discountWeekendFee;
	}

	/**
	 * @return the dynamicFields
	 */
	public String getDynamicFields(){
		return dynamicFields;
	}

	/**
	 * @param dynamicFields the dynamicFields to set
	 */
	public void setDynamicFields(String dynamicFields){
		this.dynamicFields = dynamicFields;
	}
}
