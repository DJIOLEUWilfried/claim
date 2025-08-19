package com.kozao.controllers;

import com.kozao.models.User;
import com.kozao.services.UserService;
import com.kozao.services.UserServiceImpl;
import com.kozao.utils.ClaimConstanteUtil;
import com.kozao.utils.ClaimControlUserUtil;

public class UserController {

	UserService userService = new UserServiceImpl();
	User user = new User();
	public static String msgUserController;

	public void addUserController(String name, String firstName, String email, String role, String password) {

		if (ClaimControlUserUtil.controlAddUser(name, firstName, email, role, password)) {

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
		user.setUserRole(role);
		user.setPassWord(ClaimControlUserUtil.cryptPassWord(password));

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
		if (ClaimControlUserUtil.controlUpdatePassWord(oldPassword, newPassword)) {

			msgUserController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		int r = userService.updatePassWord(oldPassword, newPassword);

		msgUserController = (r < 0) ? ClaimConstanteUtil.MSG_FAILED_UPDATE_PASSWORD
				: (r == 1) ? ClaimConstanteUtil.MSG_PASSWORD_INVALID : ClaimConstanteUtil.MSG_UPDATE_PASSWORD;

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

		User user = userService.login(user_email, password);

		if (user == null) {
			msgUserController = ClaimConstanteUtil.MSG_ERROR_LOGIN;
		} else {
			return user;
		}

		return null;
	}

}
