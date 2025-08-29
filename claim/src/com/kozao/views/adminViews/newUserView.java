package com.kozao.views.adminViews;

import java.util.Scanner;

import com.kozao.controllers.UserController;

public class newUserView {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String nom, prenom, email, role, passWord;
		
		// User user = new User();
		UserController userController = new UserController();
        
        
		System.out.println(" Entrer le nom : ");
		nom = sc.nextLine().trim();

		System.out.println("\n Entrer le prenom : ");
		prenom = sc.nextLine().trim();

		System.out.println("\n Entrer l'email : ");
		email = sc.nextLine().trim();

		System.out.println("\n Entrer le role : ");
		role = sc.nextLine().trim();

		System.out.println("\n Entrer le mot de passe : ");
		passWord = sc.nextLine().trim();

		//userController.addUserController(nom, prenom, email, role);
		//System.out.println(UserController.msgUserController);
		
	
		
		// System.out.println(" Entrer le nom : ");

	}

}
