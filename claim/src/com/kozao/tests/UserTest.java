package com.kozao.tests;

import static org.junit.Assert.assertEquals;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;

//import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;

import com.kozao.controllers.UserController;
import com.kozao.models.User;
import com.kozao.utils.ClaimConstanteUtil;


public class UserTest {

	public UserController userController = new UserController();

//	@BeforeEach
//	void setUp() {
//		userController = new UserController();
//	}

	@Test
    public void testCreateUser() {
		
		userController.addUserController("Kamga18", "Souleman", "djioleuwilfried@gmail.com", "Admin");
                
        // System.out.println("\n Avant : " + UserController.msgUserController);
		
        assertEquals("Test de création d'un utilisateur echoué", ClaimConstanteUtil.MSG_CREATE_USER, UserController.msgUserController);


	}
//	
//	@Test
//    public void testFindser() {
//		
//		User user = userController.findUserByIdController(1);        
//		
//        assertEquals("Test11 Echouer", ClaimConstanteUtil.MSG_CREATE_USER, UserController.msgUserController);
//        
//        
//	}
	
	
	
}
