package com.kozao.tests;

import org.junit.Test;

import com.kozao.controllers.ResourceController;
import com.kozao.controllers.UserController;
import com.kozao.models.Resource;
import com.kozao.models.User;
import com.kozao.utils.ClaimConstanteUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;




public class ResourceTest {
	
	ResourceController resourceController = new ResourceController();
	
    /*
	@Test
	public void testCreateResource() {

		resourceController.addResourceController("Ressource4", "Quatrieme test");

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_RESOURCE,
				ResourceController.msgResourceController);
	}
	
	
	@Test
	public void testUpdateResource() {

		resourceController.updateResourceController("1Ressource1", "Premiere ressource modifier", 1);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_RESOURCE,
				ResourceController.msgResourceController);
	}  
    
	
	@Test
	public void testdeleteResource() {

		resourceController.deleteResourceController(3);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.QUERY_RESOURCE_DELETE,
				ResourceController.msgResourceController);
	}
	
	*/
	
	@Test  
	public void testfindUserById() { 

		Resource resource = resourceController.findResourceByIdController(2);
		
		assertNotNull(ClaimConstanteUtil.MSG_RESOURCE_NOT_NULL, resource);
	}
	
	
	
	
	
	
	
}
