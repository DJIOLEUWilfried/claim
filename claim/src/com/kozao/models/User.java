package com.kozao.models;

/**
 * 
 * @author DJIOLEU Wilfried
 * @version 1.0
 */
public class User {
	
	
	private int idUser;
	private String userName;
	private String userFirstName;
	private String userEmail;
	private String userRole;
	private boolean UserStatus;
	private String passWord;
	
	
	public User() {
		super();
	}

	/**
	 * 
	 * @param userName the name of user
	 * @param userFirstName the first name of user
	 * @param userEmail
	 * @param userRole
	 * @param userStatus
	 * @param passWord
	 */
	public User(String userName, String userFirstName, String userEmail, String userRole, boolean userStatus,
			String passWord) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userEmail = userEmail;
		this.userRole = userRole;
		UserStatus = userStatus;
		this.passWord = passWord;
	}
	
	/**
	 * Return the user id
	 * @return userId
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * Change the user id
	 * @param idUser is the new idUser
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * Return the user name
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Change the userName
	 * @param userName is the new userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public boolean getUserStatus() {
		return UserStatus;
	}
	public void setUserStatus(boolean userStatus) {
		UserStatus = userStatus;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
}
