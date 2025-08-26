package com.kozao.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.kozao.controllers.UserController;
import com.kozao.models.User;
import com.kozao.utils.ClaimConstanteUtil;

public class UserTest {

	public UserController userController = new UserController();
	
	
//	@Test
//	public void testCreateUser() {
//
//		userController.addUserController("DJIOLEU1", "Wilfried1", "djioleuwilfried@gmail.com", "User");
//
//		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_USER,
//				UserController.msgUserController);
//	}
//	
	
//	@Test
//	public void testupdateUserProfilController() {
//
//		userController.updateUserProfilController("DJAMEN1", "Jores1", "djamenjores1@gmail.com", 13);
//
//		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PROFIL,
//				UserController.msgUserController);
//	}
//	
	
	
//	@Test  
//	public void testUpdatePassWordController() {
//
//		userController.updatePassWordController("DJIOLEU1", "ras2", "ras3");
//		
//		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PASSWORD,
//				UserController.msgUserController);
//	}
	
	
//	@Test  
//	public void testdisableUserController() {
//
//		userController.disableUserController(18);
//		
//		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_DISABLE_USER_STATUS,
//				UserController.msgUserController);
//	}
	
	
//	@Test  
//	public void testenableUserController() {
//
//		userController.enableUserController(18);
//		
//		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_ENABLE_USER_STATUS,
//				UserController.msgUserController);
//	}	
	
//	@Test  
//	public void testloginController() { // "L'objet ne doit pas être null"
//
//		User user = userController.loginController("djioleuwilfried@gmail.com", "Claim25");
//		
//		assertNotNull(ClaimConstanteUtil.MSG_USER_NOT_NULL, user);
//	}	
	
	
//	@Test  
//	public void testfindUserByIdController() { // "L'objet ne doit pas être null"
//
//		User user = userController.findUserByIdController(17);
//		
//		assertNotNull(ClaimConstanteUtil.MSG_USER_NOT_NULL, user);
//	}
	
//	@Test  
//	public void testfindUserByNameController() { // "L'objet ne doit pas être null"
//
//		User user = userController.findUserByNameController("KAMGA2");
//		
//		assertNotNull(ClaimConstanteUtil.MSG_USER_NOT_NULL, user);
//	}
	
//	@Test  
//	public void testfindUserByFirstNameController() { // "L'objet ne doit pas être null"
//
//		User user = userController.findUserByFirstNameController("Cyria");
//		
//		assertNotNull(ClaimConstanteUtil.MSG_USER_NOT_NULL, user);
//	}
	
	
//	@Test  
//	public void testfindAllUserController() { // "L'objet ne doit pas être null"
//
//		List<User> user = userController.findAllUserController();
//		
//		assertNotNull(ClaimConstanteUtil.MSG_USER_NOT_NULL, user);
//	}
	

	@Test  
	public void testdeleteUserController() {

		userController.deleteUserController(1);
		
		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.QUERY_USER_DELETE,
				UserController.msgUserController);
	}
	
	
	
}
