package com.kozao.views;

import java.util.Scanner;

import com.kozao.controllers.UserController;
import com.kozao.models.User;
import com.kozao.views.adminViews.DashboardAdmin;
import com.kozao.views.userViews.DashboardUser;

public class Login {

	public static String userSession;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nom, prenom, email, role, password;

		UserController userController = new UserController();

		String value;
		char val;
		boolean r = true;

		do {

			Dashboard();

			value = sc.nextLine();

			value = value.toLowerCase();

			if (value.length() == 1) {

				val = value.charAt(0);
				switch (val) {

				case 'a':

					System.out.println("\n Entrer l'email : ");
					email = sc.nextLine().trim();

					System.out.println("\n Entrer le mot de passe : ");
					password = sc.nextLine().trim();

					User user = userController.loginController(email, password);

					if (user == null) {
						System.out.println(UserController.msgUserController);
					} else {
						userSession = user.getUserName();
						if (user.getUserRole() == "user") {  DashboardUser.main(args);  }
						else {  DashboardAdmin.main(args);  }
					}

					r = false;
					break;

				case 'b':
					System.out.println("\n\n ras");
					r = false;
					break;

				default:
					r = true;
					break;
				}
			}

		} while (r == true);

	}

	public static void Dashboard() {
		System.out.println("\n ======   a- Login   ======");
		System.out.println("\n ======   b- ras   ======");
	}

}
