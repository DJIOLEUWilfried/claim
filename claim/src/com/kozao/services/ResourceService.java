package com.kozao.services;

import java.util.List;

import java.util.Locale.Category;

import com.kozao.models.Resource;


public interface ResourceService {
	
	
    int addRessource(Resource res, int categoryId);
	
    int updateRessource(Resource res, int categoryId) ;
	
    int deleteRessource(int id) ;
	
	Resource findRessourceById(int id);
	
	Resource findRessourceByName(String name);

	List<Resource> findAllRessource() ;
	

}
