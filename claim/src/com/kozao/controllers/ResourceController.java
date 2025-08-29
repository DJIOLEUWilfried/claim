package com.kozao.controllers;

import java.util.List;

import com.kozao.models.Resource;
import com.kozao.services.ResourceService;
import com.kozao.services.ResourceServiceImpl;
import com.kozao.utils.ClaimConstanteUtil;
import com.kozao.utils.ClaimControlUserUtil;

public class ResourceController {

	ResourceService resourceService = new ResourceServiceImpl();	
	Resource resource = new Resource();
	public static String msgResourceController;
	
	
	public void addResourceController(String resourceName, String resourceDescription) {
		
		resourceName = resourceName.trim().toLowerCase();
		resourceDescription = resourceDescription.trim().toLowerCase();
		
		if (ClaimControlUserUtil.checkAllFields(resourceName, resourceDescription) ) {

			msgResourceController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return;
		}  

		resource.setResourceName(resourceName);
		resource.setResourceDescription(resourceDescription);

		int r = resourceService.addResource(resource);
		
		msgResourceController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_RESOURCE : ClaimConstanteUtil.MSG_FAILED_CREATE_RESOURCE;		
		
	}  
	
	public void updateResourceController(String resourceName, String resourceDescription, int resourceId) {
		
		resourceName = resourceName.trim().toLowerCase();
		resourceDescription = resourceDescription.trim().toLowerCase();
		
		if (ClaimControlUserUtil.checkAllFields(resourceName, resourceDescription) || resourceId < 1 ) {
			msgResourceController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return;
		}  

		resource.setResourceName(resourceName);
		resource.setResourceDescription(resourceDescription);
		resource.setIdResource(resourceId);

		int r = resourceService.updateResource(resource);
		
		msgResourceController = (r > 0) ? ClaimConstanteUtil.MSG_UPDATE_RESOURCE : ClaimConstanteUtil.MSG_FAILED_UPDATE_RESOURCE;		
		
	}
	
	public void deleteResourceController(int resourceId) {
		if (resourceId < 1) {
			msgResourceController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return ;  
		} 
		
		int r = resourceService.deleteResource(resourceId); 
		
		msgResourceController = (r > 0) ? ClaimConstanteUtil.MSG_RESOURCE_DELETE
			            	: ClaimConstanteUtil.MSG_FAILED_RESOURCE_DELETE
			            	; 
	}

	public Resource findResourceByIdController(int resourceId) {
		if (resourceId < 1) {
			msgResourceController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return null;
		}

		Resource resource = resourceService.findResourceById(resourceId);

		if (resource == null) {
			msgResourceController = ClaimConstanteUtil.MSG_FAILLED_FIND_RESOURCE;
			return null;
		}

		return resource; 
	}

	public Resource findResourceByNameController(String resourceName) {
		resourceName = resourceName.trim().toLowerCase();
		
		if (ClaimControlUserUtil.checkAllFields(resourceName) ) {

			msgResourceController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return null;
		}  

		Resource resource = resourceService.findResourceByName(resourceName);

		if (resource == null) {
			msgResourceController = ClaimConstanteUtil.MSG_FAILLED_FIND_RESOURCE;
			return null;
		}

		return resource; 
	}

	public List<Resource> findAllUserController(){
		 List <Resource> allResource = resourceService.findAllResources();
		 
		 return allResource ;
	}

	
	
	
}
