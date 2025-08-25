package com.kozao.services;

import java.util.List;

import java.util.Locale.Category;

import com.kozao.models.Resource;


public interface ResourceService {
	
	
    int addResource(Resource res);
	
    int updateResource(Resource res) ;
	
    int deleteResource(int resourceId) ;
	
	Resource findResourceById(int resourceId);
	
	Resource findResourceByName(String resourceName);

	List<Resource> findAllResources() ;
	

}
