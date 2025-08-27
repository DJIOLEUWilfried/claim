package com.kozao.services;

import java.util.List;

import com.kozao.models.Role;


public interface RoleService {
	
	int addRole(Role role) ;

    int updateRole(Role role) ;
	
	int deleteRole(int roleId) ;

	Role findRoleById(int roleId) ;

	Role findRoleByName(String roleName) ;

	List<Role> findAllRole() ;

}
