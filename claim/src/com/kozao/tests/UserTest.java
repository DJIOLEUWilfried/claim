package com.kozao.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.kozao.controllers.UserController;
import com.kozao.models.User;
import com.kozao.utils.ClaimConstanteUtil;

public class UserTest {

	public UserController userController = new UserController();
	
 
	@Test
	public void testCreateUser() {

		userController.addUserController("AJBB", "nj", "Tchhjoffo@gmail.com", 2);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_USER,
				UserController.msgUserController);
	}
	
	
	@Test
	public void testUpdateUserProfil() {

		userController.updateUserProfilController("DJAMEN1", "Jores1", "djamenjores1@gmail.com", 4);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PROFIL,
				UserController.msgUserController);
	}	
	
	
	@Test  
	public void testUpdatePassWord() {

		userController.updatePassWordController("wilfried1", "ras1", "ras2");
		
		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_PASSWORD,
				UserController.msgUserController);
	}
	
	
	
	@Test  
	public void testDisableUser() {

		userController.disableUserController(4);
		
		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_DISABLE_USER_STATUS,
				UserController.msgUserController);
	}
		

	@Test  
	public void testEnableUser() {

		userController.enableUserController(4);
		
		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_ENABLE_USER_STATUS,
				UserController.msgUserController);
	}	
		
	
	
	@Test  
	public void testFindUserById() { 

		User user = userController.findUserByIdController(2);
		
		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, user);
	}
	
	
	@Test  
	public void testFindUserByName() { 

		User user = userController.findUserByNameController("KAMGA");
		
		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, user);
	}
		
	
	@Test  
	public void testfindUserByFirstName() { 

		User user = userController.findUserByFirstNameController("souleman");
		
		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, user);
	}
	
	
	@Test  
	public void testFindAllUser() { 

		List<User> user = userController.findAllUserController();
		
		assertFalse(ClaimConstanteUtil.MSG_LIST_NULL, user.isEmpty());	
	}
    
	
	
	@Test  
	public void testDeleteUser() {

		userController.deleteUserController(5);
		
		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.QUERY_USER_DELETE,
				UserController.msgUserController);
	}	
   
	
	@Test  
	public void testLogin() { 

		User user = userController.loginController("djioleuwilfried@gmail.com", "ras2");
		
		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, user);
	}
	 
	
	
}
