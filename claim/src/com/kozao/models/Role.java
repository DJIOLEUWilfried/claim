package com.kozao.models;

public class Role {

	private int roleId;
	private String roleName;
	private String roleDescription;
	
	public Role() { }
	
	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	
	public Role(int roleId, String roleName, String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	@Override
	public String toString() {
		return String.format("Id= %s  Name= %s  Description= %s ", roleId, roleName, roleDescription);
	}
	
}
