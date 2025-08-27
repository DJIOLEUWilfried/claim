package com.kozao.controllers;

import com.kozao.models.Resource;
import com.kozao.services.ResourceService;
import com.kozao.services.ResourceServiceImpl;
import com.kozao.utils.ClaimConstanteUtil;
import com.kozao.utils.ClaimControlUserUtil;
import com.kozao.utils.ClaimSendPasswordUtil;

public class ResourceController {

	ResourceService resourceService = new ResourceServiceImpl();	
	Resource resource = new Resource();
	public static String msgResourceController;
	
	
	public void addResourceController(String resourceName, String resourceDescription) {
		
		resourceName = resourceName.trim();
		resourceDescription = resourceDescription.trim();
		
		if (ClaimControlUserUtil.checkAllFields(resourceName, resourceDescription) ) {

			msgResourceController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return;
		}  

		resource.setResourceName(resourceName);
		resource.setResourceDescription(resourceDescription);

		int r = resourceService.addResource(resource);
		
		msgResourceController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_RESOURCE : ClaimConstanteUtil.MSG_FAILED_CREATE_RESOURCE;		
		
	}
	
	
	
	
	
	
	
	
}
