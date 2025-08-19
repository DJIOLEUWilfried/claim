package com.kozao.utils;

import javax.mail.internet.InternetAddress;

import org.mindrot.jbcrypt.BCrypt;

public class ClaimControlUserUtil {

	public static boolean controlAddUser(String name, String firstName, String email, String role, String password) {

		if (name.isEmpty() || firstName.isEmpty() || email.isEmpty() || role.isEmpty() || password.isEmpty()
				|| name == null || firstName == null || email == null || role == null || password == null) {

			return true;
		}

		return false;
	}

	public static boolean emailValid(String email) {

		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
			// System.out.println("Email valide !");

			return true;

		} catch (Exception e) {
			// System.out.println("Email invalide !");

			return false;
		}
	}

	public static String cryptPassWord(String passWord) {

		return BCrypt.hashpw(passWord, BCrypt.gensalt());
	}

	public static boolean controlUpdateUserProfil(String name, String firstName, String email, int id) {

		if (name.isEmpty() || firstName.isEmpty() || email.isEmpty() || id == 0 || name == null || firstName == null
				|| email == null) {

			return true;
		}

		return false;
	}

	public static boolean controlUpdatePassWord(String oldPassword, String newPassword) {
		if (oldPassword.isEmpty() || newPassword.isEmpty() || oldPassword == null || newPassword == null) {
			return true;
		}
		return false;
	}

	public static boolean checkAllFields(String... values) {

		for (String value : values) {

			if (value.isEmpty() || value == null) {
				return true;
			}
		}
		return false;
	}

}
