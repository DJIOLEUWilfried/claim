package com.kozao.controllers;

import java.util.List;

import com.kozao.models.Role;
import com.kozao.services.RoleService;
import com.kozao.services.RoleServiceImpl;
import com.kozao.utils.ClaimConstanteUtil;
import com.kozao.utils.ClaimControlUserUtil;

public class RoleController {

	RoleService roleService = new RoleServiceImpl();
	Role role = new Role();
	public static String msgRoleController;

	public void addRoleController(String roleName, String roleDescription) {

		roleName = roleName.trim().toLowerCase();
		roleDescription = roleDescription.trim().toLowerCase();

		if (ClaimControlUserUtil.checkAllFields(roleName, roleDescription)) {

			msgRoleController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		role.setRoleName(roleName);
		role.setRoleDescription(roleDescription);

		int r = roleService.addRole(role);

		msgRoleController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_ROLE : ClaimConstanteUtil.MSG_FAILED_CREATE_ROLE;

	}

	public void updateRoleController(String roleName, String roleDescription, int roleId) {

		roleName = roleName.trim().toLowerCase();
		roleDescription = roleDescription.trim().toLowerCase();

		if (ClaimControlUserUtil.checkAllFields(roleName, roleDescription) || roleId == 0) {
			msgRoleController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		role.setRoleName(roleName);
		role.setRoleDescription(roleDescription);
		role.setRoleId(roleId);

		int r = roleService.updateRole(role);

		msgRoleController = (r > 0) ? ClaimConstanteUtil.MSG_UPDATE_ROLE : ClaimConstanteUtil.MSG_FAILED_UPDATE_ROLE;

	}

	public void deleteRoleController(int roleId) {
		if (roleId < 1) {
			msgRoleController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return ;  
		} 
		
		int r = roleService.deleteRole(roleId);  
		
		msgRoleController = (r > 0) ? ClaimConstanteUtil.MSG_ROLE_DELETE
			            	: ClaimConstanteUtil.MSG_FAILED_ROLE_DELETE ; 
	}

	public Role findRoleByIdController(int roleId) {
		if (roleId < 1) {
			msgRoleController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return null;
		}

		Role role = roleService.findRoleById(roleId);

		if (role == null) {
			msgRoleController = ClaimConstanteUtil.MSG_FAILLED_FIND_ROLE;
			return null;
		}

		return role; 
	}

	public Role findRoleByNameController(String roleName) {
		roleName = roleName.trim().toLowerCase();
		
		if (ClaimControlUserUtil.checkAllFields(roleName) ) {

			msgRoleController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return null;
		}  

		Role role = roleService.findRoleByName(roleName);

		if (role == null) {
			msgRoleController = ClaimConstanteUtil.MSG_FAILLED_FIND_ROLE;
			return null;
		}

		return role; 
	}

	public List<Role> findAllRoleController(){
		 
		 return roleService.findAllRole();
	}



}
