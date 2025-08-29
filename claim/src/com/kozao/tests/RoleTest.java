package com.kozao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.kozao.controllers.RoleController;
import com.kozao.models.Role;
import com.kozao.utils.ClaimConstanteUtil;

public class RoleTest {

	RoleController roleController = new RoleController();
	
	@Test
	public void testCreateRole() {

		roleController.addRoleController("super admin1", "ras ras1");

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_ROLE,
				RoleController.msgRoleController);
	}
	

	@Test
	public void testUpdateRole() {

		roleController.updateRoleController("user", "Premiere role2 modifier", 2);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_ROLE,
				RoleController.msgRoleController);
	}

	
	@Test
	public void testdeleteRole() {

		roleController.deleteRoleController(6);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_ROLE_DELETE,
				RoleController.msgRoleController);
	}
	
	
	@Test
	public void testfindRoleById() {

		Role role = roleController.findRoleByIdController(2);

		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, role);
	}

   	
	@Test
	public void testfindRoleByName() {

		Role role = roleController.findRoleByNameController("admin");

		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, role);
	}


	@Test
	public void testfindAllResources() {

		List<Role> role = roleController.findAllRoleController();

		assertFalse(ClaimConstanteUtil.MSG_LIST_NULL, role.isEmpty());	
	}
	
	

}
