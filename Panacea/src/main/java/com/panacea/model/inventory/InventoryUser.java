package com.panacea.model.inventory;

public class InventoryUser {
	private String userId;
	private String userName;
	private String password;
	private String designation;
	private String userBranch;
	private String userType;

	public InventoryUser(String userId, String userName, String password, String designation, String userBranch,
			String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.designation = designation;
		this.userBranch = userBranch;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserBranch() {
		return userBranch;
	}

	public void setUserBranch(String userBranch) {
		this.userBranch = userBranch;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
