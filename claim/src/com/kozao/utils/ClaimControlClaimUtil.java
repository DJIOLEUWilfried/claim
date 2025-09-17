package com.kozao.utils;

import java.time.LocalDateTime;

public class ClaimControlClaimUtil {

	public static String dateAndTime() {

		LocalDateTime myDateObj = LocalDateTime.now();

		return myDateObj.toString();
	}
	
	public static boolean enumValid(String statusClaim) {

		if (statusClaim == "PENDING" || statusClaim == "INPROGRESS" || statusClaim == "RESOLVED" || statusClaim == "REJETED" ) {
			return true;
		}
		return false;
	}

}
