package com.kozao.tests;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.kozao.controllers.UserController;
import com.kozao.utils.ClaimConstanteUtil;


public class UserTest {

	public UserController userController = new UserController();

	@Test
    public void testCreateUser() {  
		
		userController.addUserController("KAMGA22", "Souleman", "kamga22souleman@gmail.com", "Admin");
                		
        assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_USER, UserController.msgUserController);
	}
	
	@Test
	public void testupdateUserProfilController() {
		
		userController.updateUserProfilController("DJAMEN", "Jores", "djamenjores@gmail.com", 13);
        
        assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PROFIL, UserController.msgUserController);
	}

	@Test
	public void updatePassWord(String oldPassword, String newPassword) {
		// Claim545

		
		
	}
	
	
	
	
	
	
	
	
	
	
}
