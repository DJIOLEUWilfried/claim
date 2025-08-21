package com.kozao.controllers;

import java.util.List;

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

	public void addUserController(String name, String firstName, String email, String role) {

		if (ClaimControlUserUtil.checkAllFields(name, firstName, email, role)) {

			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return;
		}  
		
		if ( !"user".equalsIgnoreCase(role) && !"admin".equalsIgnoreCase(role) ) { 
		    			
			msgUserController = ClaimConstanteUtil.MSG_INVALID_ROLE;
		    return;
		}

		
		if (!ClaimControlUserUtil.emailValid(email)) {
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
		user.setUserRole(role);
		user.setPassWord(password);

		int r = userService.addUser(user);

		msgUserController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_USER : ClaimConstanteUtil.MSG_FAILED_CREATE_USER;
        
	}    

	public void updateUserProfilController(String name, String firstName, String email, int id) {

		if (ClaimControlUserUtil.controlUpdateUserProfil(name, firstName, email, id)) {

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

	public void updatePassWordController(String oldPassword, String newPassword) {
		if (ClaimControlUserUtil.checkAllFields(oldPassword, newPassword)) {

			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		int r = userService.updatePassWord(oldPassword, newPassword);

		msgUserController = (r < 0) ? ClaimConstanteUtil.MSG_FAILED_UPDATE_PASSWORD
				: (r == 1) ? ClaimConstanteUtil.MSG_PASSWORD_INVALID : ClaimConstanteUtil.MSG_UPDATE_PASSWORD;

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
		 List <User> allUser = userService.findAllUser();
		 
		 return allUser ;
	}
	
	public User loginController(String user_email, String password) {
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
