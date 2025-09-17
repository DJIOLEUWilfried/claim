package com.kozao.controllers;

import java.util.List;

import com.kozao.models.Role;
import com.kozao.models.User;
import com.kozao.services.UserService;
import com.kozao.services.UserServiceImpl;
import com.kozao.utils.ClaimConstanteUtil;
import com.kozao.utils.ClaimControlUserUtil;
import com.kozao.utils.ClaimSendPasswordUtil;

public class UserController {

	UserService userService = new UserServiceImpl();
	
	User user = new User();
	
	public static String msgUserController;

	public void addUserController(String name, String firstName, String email, int role) {
        name = name.trim().toUpperCase();
        firstName = firstName.trim().toLowerCase();
        email = email.trim();
        
		if (ClaimControlUserUtil.checkAllFields(name, firstName, email) || role < 1) {

			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return;
		}  

		
		if (ClaimControlUserUtil.emailValid(email) == false) {
			msgUserController = ClaimConstanteUtil.MSG_INVALID_ROLE;
			return;
		}
			
		String password = ClaimSendPasswordUtil.SendPassword(email, name);
		if (password.isEmpty() || password == null) {
			msgUserController = ClaimConstanteUtil.MSG_FAILED_SEND_PASSWORD;
			return;
		}
		
		user.setUserName(name);
		user.setUserFirstName(firstName);
		user.setUserEmail(email);

		Role ro = new Role();
		ro.setRoleId(role);
		user.setRoleJoin(ro);
		
		user.setPassWord(password);

		int r = userService.addUser(user);
		
		msgUserController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_USER : 
			                (r == -1) ? ClaimConstanteUtil.MSG_ACCOUNT_ALREADY_EXISTS : ClaimConstanteUtil.MSG_FAILED_CREATE_USER;		
	}    

	public void updateUserProfilController(String name, String firstName, String email, int id) {

		name = name.trim().toUpperCase();
        firstName = firstName.trim().toLowerCase();
        email = email.trim();
        
		if (ClaimControlUserUtil.checkAllFields(name, firstName, email) || id < 0) {

			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}
		if (!ClaimControlUserUtil.emailValid(email)) {
			msgUserController = ClaimConstanteUtil.MSG_INVALID_EMAIL;
			return;
		}

		user.setUserName(name);
		user.setUserFirstName(firstName);
		user.setUserEmail(email);
		user.setIdUser(id);

		int r = userService.updateUserProfil(user);

		msgUserController = (r > 0) ? ClaimConstanteUtil.MSG_UPDATE_PROFIL
				: ClaimConstanteUtil.MSG_FAILED_UPDATE_PROFIL;

	}

	public void updatePassWordController(String firstName, String oldPassword, String newPassword) {
		
		firstName = firstName.trim().toLowerCase();
		oldPassword = oldPassword.trim();
		newPassword = newPassword.trim();
		
		if (ClaimControlUserUtil.checkAllFields(firstName, oldPassword, newPassword) ) {

			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}	
		
		User user = findUserByFirstNameController(firstName);
		if ( user == null ) {
			msgUserController = ClaimConstanteUtil.MSG_FAILLED_FIND_USER;
			return ;
		}
		
		String pass = user.getPassWord();
		
		if ( !ClaimControlUserUtil.verifyPassword(oldPassword, pass)) {
			
			msgUserController = ClaimConstanteUtil.MSG_PASSWORD_INVALID;  
		    return ;
		}
		
		int r = userService.updatePassWord( firstName, ClaimControlUserUtil.cryptPassWord(newPassword) );

		msgUserController = (r > 0) ? ClaimConstanteUtil.MSG_UPDATE_PASSWORD :ClaimConstanteUtil.MSG_FAILED_UPDATE_PASSWORD;

	}

	public void disableUserController(int id) {
		if (id < 1) {
			msgUserController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return ;
		}
		
		int r = userService.disableUser(id);
		msgUserController = (r > 0) ? ClaimConstanteUtil.MSG_DISABLE_USER_STATUS
				          : ClaimConstanteUtil.MSG_FAILED_DISABLE_USER_STATUS; 
	}
	
	public void enableUserController(int id) {
		if (id < 1) {
			msgUserController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return ;  
		}
		
		int r = userService.enableUser(id);

		msgUserController = (r > 0) ? ClaimConstanteUtil.MSG_ENABLE_USER_STATUS
			            	: ClaimConstanteUtil.MSG_FAILED_ENABLE_USER_STATUS ; 
	}
	
	public User loginController(String user_email, String password) {
		
		user_email = user_email.trim();
		password = password.trim();
		
		if (ClaimControlUserUtil.checkAllFields(user_email, password)) {
			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return null;
		}

		if (!ClaimControlUserUtil.emailValid(user_email)) {
			msgUserController = ClaimConstanteUtil.MSG_INVALID_EMAIL;
			return null;
		}

		User user = userService.login(user_email);

		if (user == null) { msgUserController = ClaimConstanteUtil.MSG_ERROR_LOGIN;   return null; 	 }		
		else { 
			
			if ( !user.getUserStatus() ) { msgUserController = ClaimConstanteUtil.MSG_DISABLE_STATUS;  return null; }
			
			if ( !ClaimControlUserUtil.verifyPassword(password, user.getPassWord())) {
				
				msgUserController = ClaimConstanteUtil.MSG_ERROR_LOGIN;  
			    return null;
			}		
		}

		return user;   
	}
	
	public User findUserByIdController(int id) {
		if (id < 1) {
			msgUserController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return null;
		}

		User user = userService.findUserById(id);

		if (user == null) {
			msgUserController = ClaimConstanteUtil.MSG_FAILLED_FIND_USER;
			return null;
		}

		return user; 
	}
	
	public User findUserByNameController(String name) {
		name = name.trim().toUpperCase();
		if (ClaimControlUserUtil.checkAllFields(name)) {
			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return null;
		}
		
		User user = userService.findUserByName(name);
		if (user == null) {
			msgUserController = ClaimConstanteUtil.MSG_FAILLED_FIND_USER;
			return null;
		}

		return user;
	}
	
	public User findUserByFirstNameController(String firstName) {
		firstName = firstName.trim().toLowerCase();

		if (ClaimControlUserUtil.checkAllFields(firstName)) {
			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return null;
		}
		User user = userService.findUserByFirstName(firstName);
	
		if (user == null) {
			msgUserController = ClaimConstanteUtil.MSG_FAILLED_FIND_USER;
			return null;
		}
				
		return user;
	}
	
	public List<User> findAllUserController(){
		 
		 return userService.findAllUser();
	}
	
	public void deleteUserController(int id) {
		if (id < 1) {
			msgUserController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return ;  
		}
		
		int r = userService.deleteUser(id);

		msgUserController = (r > 0) ? ClaimConstanteUtil.QUERY_USER_DELETE
			            	: ClaimConstanteUtil.QUERY_FAILED_USER_DELETE ; 
	}

	
	
	
	
	
}
