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

	@Test
    public void testCreateUser() {  
		
		userController.addUserController("DJIOLEU", "Wilfried", "djioleuwilfried@gmail.com", "Admin");
                		
        assertEquals("Test echoué", ClaimConstanteUtil.MSG_CREATE_USER, UserController.msgUserController);
	}

	
	
}
