package com.kozao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Logger;

import com.kozao.models.Resource;
import com.kozao.models.User;
import com.kozao.utils.ClaimConstanteUtil;

public class ResourceServiceImpl implements ResourceService {

	public static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public int addResource(Resource res) {
		int r = 0;

		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_CREATE_RESOURCE);

			pre.setString(1, res.getResourceName());
			pre.setString(2, res.getResourceDescription());

			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.warning(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int updateResource(Resource res) {
		int r = 0;
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_RESOURCE);

			pre.setString(1, res.getResourceName());
			pre.setString(2, res.getResourceDescription());
			pre.setInt(3, res.getIdResource());

			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.warning(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int deleteResource(int id) {
		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_DELETE_RESOURCE);
			pre.setInt(1, id);

			id = pre.executeUpdate();

			return id;

		} catch (SQLException e) {

			logger.warning(String.format("\n Error : %s", e));
		}

		return 0;
	}

	@Override
	public Resource findResourceById(int id) {
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_USER_BY_ID);

			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Resource res = new Resource();

				res.setIdResource(rs.getInt("resource_id"));
				res.setResourceName(rs.getString("resource_name"));
				res.setResourceDescription(rs.getString("resource_description"));

				return res;
			}

		} catch (SQLException e) {

			logger.warning(String.format("\n Error : %s", e));
		}

		return null;
	}

	@Override
	public Resource findResourceByName(String name) {
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_USER_BY_ID);

			pre.setString(1, name);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Resource res = new Resource();

				res.setIdResource(rs.getInt("resource_id"));
				res.setResourceName(rs.getString("resource_name"));
				res.setResourceDescription(rs.getString("resource_description"));

				return res;
			}

		} catch (SQLException e) {

			logger.warning(String.format("\n Error : %s", e));
		}

		return null;
	}

	@Override
	public List<Resource> findAllResources() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
