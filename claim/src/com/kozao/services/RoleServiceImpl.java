package com.kozao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kozao.models.Resource;
import com.kozao.models.Role;
import com.kozao.utils.ClaimConstanteUtil;

public class RoleServiceImpl implements RoleService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public int addRole(Role role) {

		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_CREATE_ROLE);

			pre.setString(1, role.getRoleName());
			pre.setString(2, role.getRoleDescription());

			return (pre.executeUpdate() > 0) ? 1 : 0 ;
			
		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
	}

	@Override
	public int updateRole(Role role) {
		int r = 0;
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_ROLE);

			pre.setString(1, role.getRoleName());
			pre.setString(2, role.getRoleDescription());
			pre.setInt(3, role.getRoleId());

			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int deleteRole(int roleId) {
		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_DELETE_ROLE);
			pre.setInt(1, roleId);

			roleId = pre.executeUpdate();

			return roleId;

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
	}

	@Override
	public Role findRoleById(int roleId) {
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_ROLE_BY_ID);

			pre.setInt(1, roleId);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Role role = new Role();

				role.setRoleId(rs.getInt("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRoleDescription(rs.getString("role_description"));

				return role;
			}

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}

	@Override
	public Role findRoleByName(String roleName) {
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_ROLE_BY_NAME);

			pre.setString(1, roleName);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Role role = new Role();

				role.setRoleId(rs.getInt("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRoleDescription(rs.getString("role_description"));

				return role;
			}

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}

	@Override
	public List<Role> findAllRole() {
		List<Role> allRole = new ArrayList<>();

		try {
			Connection con = ConnexionDB.getConnection();
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(ClaimConstanteUtil.QUERY_FIND_ALL_ROLE);
			while (rs.next()) {
				Role role = new Role();

				role.setRoleId(rs.getInt("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRoleDescription(rs.getString("role_description"));

				allRole.add(role);
			}

			return allRole;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return allRole;
	}

}
