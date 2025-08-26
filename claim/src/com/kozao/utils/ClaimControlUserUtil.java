package com.kozao.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.mindrot.jbcrypt.BCrypt;

public class ClaimControlUserUtil {
	
	public static boolean checkAllFields(String... values) {

		for (String value : values) {

			if (value.isEmpty() || value == null) {
				return true;
			}
		}
		return false;
	}

	public static boolean controlAddUser(String name, String firstName, String email, String role) {

		if (name.isEmpty() || firstName.isEmpty() || email.isEmpty() || role.isEmpty() ||
		    name == null || firstName == null || email == null || role == null ) {

			return true;
		}

		return false;
	}

	public static boolean emailValid(String email) {

		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();

			return true;

		} catch (AddressException  e) {
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
	
	public static boolean verifyPassword( String Password, String hashPassword ) {
		
		if (BCrypt.checkpw(Password, hashPassword) ) { return true; }
		return false;
	}

	

//	public static boolean controlUpdatePassWord(String oldPassword, String newPassword) {
//		if (oldPassword.isEmpty() || newPassword.isEmpty() || oldPassword == null || newPassword == null) {
//			return true;
//		}
//		return false;
//	}

	

}
