package com.wd.gson;

public class ExistingPlayersEntity {
	private int tcid;
	private String username;
	private String pwd;
	private String email;
	private String flag;

	public int getTcid() {
		return tcid;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
