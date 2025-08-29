package com.kozao.tests;

import org.junit.Test;

import com.kozao.controllers.ResourceController;
import com.kozao.models.Resource;
import com.kozao.utils.ClaimConstanteUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;


public class ResourceTest {
	
	ResourceController resourceController = new ResourceController();
	
	
	@Test
	public void testCreateResource() {

		resourceController.addResourceController("besoin d'un clavier", "ras ras");

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_RESOURCE,
				ResourceController.msgResourceController);
	}
	
	
	@Test
	public void testUpdateResource() {

		resourceController.updateResourceController("2Ressource2", "Premiere ressource modifier", 1);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_RESOURCE,
				ResourceController.msgResourceController);
	}  
	   
	
	@Test
	public void testdeleteResource() {

		resourceController.deleteResourceController(1);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_RESOURCE_DELETE,
				ResourceController.msgResourceController);
	}
	
	
	@Test  
	public void testfindUserById() { 

		Resource resource = resourceController.findResourceByIdController(3);
		
		assertNotNull(ClaimConstanteUtil.MSG_RESOURCE_NOT_NULL, resource);
	}
		
	
	@Test  
	public void testfindUserByName() { 

		Resource resource = resourceController.findResourceByNameController("besoin d'un clavier");
		
		assertNotNull(ClaimConstanteUtil.MSG_RESOURCE_NOT_NULL, resource);
	}
	
	
	@Test
	public void testfindAllResources() { 

		List<Resource> resource = resourceController.findAllUserController();
		
		assertNotNull(ClaimConstanteUtil.MSG_RESOURCE_NOT_NULL, resource);
	}
	
	
}
