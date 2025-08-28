package com.kozao.models;

import java.util.List;

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
	private boolean UserStatus;
	private String passWord;
	private Role roleJoin;

	/**
	 * 
	 * @param userName      the name of user
	 * @param userFirstName the first name of user
	 * @param userEmail
	 * @param userRole
	 * @param userStatus
	 * @param passWord
	 */

	/**
	 * Return the user id
	 * 
	 * @return userId
	 */
	public User() {
		super();
	}

	public User(String userName, String userFirstName, String userEmail, Role roleJoin, boolean userStatus,
			String passWord) {
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userEmail = userEmail;
		this.roleJoin = roleJoin;
		this.UserStatus = userStatus;
		this.passWord = passWord;
		// this.claims = claims;
	}

	public int getIdUser() {
		return idUser;
	}

	/**
	 * Change the user id
	 * 
	 * @param idUser is the new idUser
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * Return the user name
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Change the userName
	 * 
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

	public Role getRoleJoin() {
		return roleJoin;
	}

	public void setRoleJoin(Role roleJoin) {
		this.roleJoin = roleJoin;
	}

	@Override
	public String toString() {
		return String.format("Id= %s  Name= %s  FirstName= %s  Email= %s  Role= %s  Statut= %s", idUser, userName,
				userFirstName, userEmail, roleJoin.getRoleName(), UserStatus);
	}

}
