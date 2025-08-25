package com.kozao.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import com.kozao.controllers.UserController;


public class UserTest {

	public UserController userController;

	@BeforeEach
	void setUp() {
		userController = new UserController();
	}

	@Test
    void testCreateAndRead() {
		
		userController.addUserController("DJIOLEU", "Wilfried", "djioleuwilfried@gmail.com", "admin");
        
        // assertNotNull(result);
        assertEquals(UserController.msgUserController, "kjgfh");
    }
	
	
	
}
