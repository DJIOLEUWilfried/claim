package com.kozao.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import com.kozao.controllers.ClaimController;
import com.kozao.controllers.UserController;
import com.kozao.models.User;
import com.kozao.models.enumations.StatusClaim;
import com.kozao.services.UserService;
import com.kozao.services.UserServiceImpl;
import com.kozao.utils.ClaimControlUserUtil;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nom, prenom, email, role, passWord;

		// User user = new User();
		UserController userController = new UserController();

		/*
		 * System.out.println(" Entrer le nom : "); nom = sc.nextLine().trim();
		 * 
		 * System.out.println("\n Entrer le prenom : "); prenom = sc.nextLine().trim();
		 * 
		 * System.out.println("\n Entrer l'email : "); email = sc.nextLine().trim();
		 * 
		 * System.out.println("\n Entrer le role : "); role = sc.nextLine().trim();
		 * 
		 * System.out.println("\n Entrer le mot de passe : "); passWord =
		 * sc.nextLine().trim();
		 * 
		 * userController.addUserController(nom, prenom, email, role, passWord);
		 * System.out.println(UserController.msgUserController);
		 * 
		 * || !"admin".equalsIgnoreCase("admin")
		 */

		UserServiceImpl userService = new UserServiceImpl();

		List<User> allUser = userService.findAllUser();
		
//		for (User u : allUser) {
//			
//			System.out.println("\n" + u);
//		}
		
		
		// int resourceId, String reason, int idUser, String priority
		
		
		
		

	}

}
