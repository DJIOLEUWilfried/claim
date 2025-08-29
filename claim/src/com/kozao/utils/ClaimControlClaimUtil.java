package com.kozao.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClaimControlClaimUtil {

	public static String dateAndTime() {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");

		return myDateObj.format(myFormatObj);
	}
	
	public static boolean enumValid(String statusClaim) {

		if (statusClaim == "PENDING" || statusClaim == "INPROGRESS" || statusClaim == "RESOLVED" || statusClaim == "REJETED" ) {
			return true;
		}
		return false;
	}

}
