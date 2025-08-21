package com.kozao.views;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import com.kozao.controllers.UserController;
import com.kozao.utils.ClaimControlUserUtil;




public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        String nom, prenom, email, role, passWord;
		
		// User user = new User();
		UserController userController = new UserController();
        
        /*
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

		userController.addUserController(nom, prenom, email, role, passWord);
		System.out.println(UserController.msgUserController);
		
		|| !"admin".equalsIgnoreCase("admin")
		*/
		
		
		
		String motDePasse = "monSecret123";
        String motDePasseHache = BCrypt.hashpw(motDePasse, BCrypt.gensalt(12));

        System.out.println("\n Mot de passe haché : " + motDePasseHache);

        // Simulation d'une saisie utilisateur
        
        String saisieUtilisateur = "monSecret123";

        if ( BCrypt.checkpw("Claim66", "$2a$10$lHIYh55NOMdK5EhMG6WgVeRp1iJAcCmd/0qh3E1KyQv8qfqrOkFXO") ) {
        	
            System.out.println(" Correct !");
            
        } else {
            System.out.println(" Incorrect.");
        }
		

	}

}
