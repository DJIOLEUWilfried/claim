package com.kozao.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.kozao.controllers.UserController;
import com.kozao.utils.ClaimConstanteUtil;

public class UserTest {

	public UserController userController = new UserController();
   
	
	@Test
	public void testCreateUser() {

		userController.addUserController("KAMGA12", "Souleman", "kamga12souleman@gmail.com", "User");

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_USER,
				UserController.msgUserController);
	}

	@Test
	public void testupdateUserProfilController() {

		userController.updateUserProfilController("DJAMEN", "Jores", "djamenjores@gmail.com", 13);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PROFIL,
				UserController.msgUserController);
	}

	
	@Test  
	public void updatePassWordController() {

		userController.updatePassWordController("Claim545", "ras1");

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PASSWORD,
				UserController.msgUserController);
	}
	
	
	
	
	
	
	
	
	
	

}
