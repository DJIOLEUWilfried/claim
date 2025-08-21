package com.kozao.views.adminViews;

import java.util.List;
import java.util.Scanner;

import com.kozao.controllers.UserController;
import com.kozao.models.User;


public class DashboardAdmin {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int id;
		String name, firstName, email, role, password;

		UserController userController = new UserController();
		User user = new User();

		String value;
		char val;
		boolean r = true;
		
		// if (Login.userSession == null) { Login.main(args);  return;}
        // System.out.println(String.format("\n\t\t Welcome, %s !", Login.userSession.toUpperCase()));

		do {

			Dashboard();

			value = sc.nextLine();

			value = value.toLowerCase();

			if (value.length() == 1) {

				val = value.charAt(0);
				switch (val) {

				case 'a':    // Add a user

					System.out.println(" Enter name : ");
					name = sc.nextLine().trim();

					System.out.println("\n Enter first name : ");
					firstName = sc.nextLine().trim();

					System.out.println("\n Enter email : ");
					email = sc.nextLine().trim();

					System.out.println("\n Enter role (user or admin) : ");
					role = sc.nextLine().trim();
					
					userController.addUserController(name, firstName, email, role);
					System.out.println(UserController.msgUserController);

					r = false;
					break;

				case 'b': // b- Disable a user
					System.out.println("\n Enter the ID of the user to be deactivated: ");
					id = sc.nextInt();

					userController.disableUserController(id);
					System.out.println(UserController.msgUserController);

					r = false;
					break;

				case 'c': // c- Activate a user
					System.out.println("\n Enter the ID of the user to be activated: ");
					id = sc.nextInt();

					userController.enableUserController(id);
					System.out.println(UserController.msgUserController);

					r = false;
					break;

				case 'd': // Delete a user
					System.out.println("\n Enter the ID of the user to be deleted: ");
					id = sc.nextInt();

					userController.deleteUserController(id);
					System.out.println(UserController.msgUserController);

					r = false;
					break;

				case 'e':   // Search for a user by ID
					System.out.println("\n Enter the ID of the user you want to search for: ");
					id = sc.nextInt();

					user = userController.findUserByIdController(id);
					if (user == null) {
						System.out.println(UserController.msgUserController);
					} else {

						System.out.println(String.format(
								"\n Id : %d \n Name : %s \n " + "FirstName : %s \n Email : %s"
										+ "\n Role : %s \n Status : %s",
								user.getIdUser(), user.getUserName(), user.getUserFirstName(), user.getUserEmail(),
								user.getUserRole(), user.getUserStatus()));
					}
					r = false;
					break;

				case 'f':   // Search for a user by Name
					System.out.println("\n Enter the name of the user you want to search for: ");
					name = sc.nextLine();

					user = userController.findUserByNameController(name);
					if (user == null) {
						System.out.println(UserController.msgUserController);
					} else {

						System.out.println(String.format(
								"\n Id : %d \n Name : %s \n " + "FirstName : %s \n Email : %s"
										+ "\n Role : %s \n Status : %s",
								user.getIdUser(), user.getUserName(), user.getUserFirstName(), user.getUserEmail(),
								user.getUserRole(), user.getUserStatus()));
					}
					r = false;
					break;

				case 'g':    // Search for a user by First Name
					System.out.println("\n Enter the first name of the user you want to search for: ");
					firstName = sc.nextLine();

					user = userController.findUserByFirstNameController(firstName);
					if (user == null) {
						System.out.println(UserController.msgUserController);
					} else {

						System.out.println(String.format(
								"\n Id : %d \n Name : %s \n " + "FirstName : %s \n Email : %s"
										+ "\n Role : %s \n Status : %s",
								user.getIdUser(), user.getUserName(), user.getUserFirstName(), user.getUserEmail(),
								user.getUserRole(), user.getUserStatus()));
					}
					r = false;
					break;

				case 'h':  // Show all users
					
					List<User> allUser = userController.findAllUserController();
					for(User users : allUser) {
						System.out.println(String.format(
								"\n Id: %d    Name: %s    FirstName: %s    Email: %s    Role: %s    Status: %s \n",
								users.getIdUser(), users.getUserName(), users.getUserFirstName(), users.getUserEmail(),
								users.getUserRole(), users.getUserStatus()));
					}
					r = false;
					break;

				case 'i':
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
		
		System.out.println("\n ======   a- Add a user   ======");
		
		System.out.println("\n ======   b- Disable a user   ======");
		
		System.out.println("\n ======   c- Activate a user   ======");
		
		System.out.println("\n ======   d- Delete a user   ======");
		
		System.out.println("\n ======   e- Search for a user by ID   ======");
		
		System.out.println("\n ======   f- Search for a user by Name   ======");
		
		System.out.println("\n ======   g- Search for a user by First Name   ======");
		
		System.out.println("\n ======   h- Show all users   ======");
		
		System.out.println("\n Select an option using its letter : ");

	} 
	
	
	
	

}
