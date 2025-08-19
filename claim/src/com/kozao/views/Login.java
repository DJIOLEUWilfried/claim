package com.kozao.views;

import java.util.Scanner;

import com.kozao.controllers.UserController;
import com.kozao.models.User;
import com.kozao.views.userViews.DashboardUser;

public class Login {
	
	public static String userSession;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nom, prenom, email, role, password;

		// User user = new User();
		UserController userController = new UserController();

		System.out.println("\n\t LOGIN ");

		System.out.println("\n Enter your email : ");
		email = sc.nextLine();

		System.out.println("\n Enter your passorwd: ");
		password = sc.nextLine();

		User user = userController.loginController(email, password);

		if (user == null) {
		    System.out.println(UserController.msgUserController);    
		} else {
			userSession = user.getUserName();
			DashboardUser.main(args);
		}

	}
	
	
	
	
	
	
	

}
