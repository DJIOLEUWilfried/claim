package com.kozao.services;


import java.util.List;

import com.kozao.models.Resource;


public interface ResourceService {

	int addResource(Resource res) ;

    int updateResource(Resource res) ;
	
	int deleteResource(int id) ;

	Resource findResourceById(int id) ;

    Resource findResourceByName(String name) ;

	List<Resource> findAllResources() ;
}
