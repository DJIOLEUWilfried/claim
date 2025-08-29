package com.kozao.controllers;


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

		roleName = roleName.trim();
		roleDescription = roleDescription.trim();

		if (ClaimControlUserUtil.checkAllFields(roleName, roleDescription)) {

			msgRoleController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		role.setRoleName(roleName);
		role.setRoleDescription(roleDescription);

		int r = roleService.addRole(role);

		msgRoleController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_ROLE
				: ClaimConstanteUtil.MSG_FAILED_CREATE_ROLE;

	}
}
