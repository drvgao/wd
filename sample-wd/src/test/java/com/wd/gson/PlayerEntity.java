package com.wd.gson;

/**
 * Player JSON entity. 'used' field is used to determine test data
 * used or not.
 * 
 * @author rdurgam
 *
 */
public class PlayerEntity {
	private int sno;
	private String fname;
	private String lname;
	private String email;
	private String town;
	private String state;
	private String used;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getfName() {
		return fname;
	}

	public void setfName(String fName) {
		this.fname = fName;
	}

	public String getlName() {
		return lname;
	}

	public void setlName(String lName) {
		this.lname = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}
}