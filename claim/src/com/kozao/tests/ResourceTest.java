package com.kozao.tests;

import org.junit.Test;

import com.kozao.controllers.ResourceController;
import com.kozao.controllers.UserController;
import com.kozao.utils.ClaimConstanteUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ResourceTest {
	
	ResourceController resourceController = new ResourceController();
	@Test
	public void testCreateResource() {

		resourceController.addResourceController(null, null);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_RESOURCE,
				ResourceController.msgResourceController);
	}

}
