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
	public int addRessource(Resource res, int categoryId) {
		int r = 0;

		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_CREATE_RESOURCE);

			pre.setString(1, res.getResourceName());
			pre.setString(2, res.getResourceDescription());
			pre.setInt(3, categoryId);

			r = pre.executeUpdate();

		} catch (SQLException e) {

			// System.out.println("\n Erreur == " + e.getMessage());

			// logger.warning(String.format("\n Error : ", e));

		}

		return r;
	}

	@Override
	public int updateRessource(Resource res, int categoryId) {
		int r = 0;

		try {

			Connection con = ConnexionDB.getConnection();

			// id_ressource nom_ressource description_ressource id_categorie
			// QUERY_UPDATE_RESOURCE = "UPDATE resource SET resource_name=?,
			// description_resource=?, category_id=?
			// "WHERE resource_id=?)"

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_RESOURCE);

			pre.setString(1, res.getResourceName());
			pre.setString(2, res.getResourceDescription());
			pre.setInt(3, categoryId);
			pre.setInt(4, res.getIdResource());

			r = pre.executeUpdate();

		} catch (SQLException e) {

			// System.out.println("\n Erreur == " + e.getMessage());

			// logger.warning(String.format("\n Error : ", e));
		}

		return r;
	}

	@Override
	public int deleteRessource(int id) {
		int r = 0;

		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_DELETE_RESOURCE);

			pre.setInt(1, id);

			r = pre.executeUpdate();

		} catch (SQLException e) {

			// System.out.println("\n Erreur == " + e.getMessage());

			// logger.warning(String.format("\n Error : ", e));
		}

		return r;
	}

	@Override
	public Resource findRessourceById(int id) {

		try {

			Connection con = ConnexionDB.getConnection();

			// QUERY_FIND_RESOURCE_BY_ID = "SELECT resource_id, resource_name, resource_description, category_id FROM resource WHERE resource_id=?";
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_RESOURCE_BY_ID);

			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Resource res = new Resource();

				pre.setInt(1, res.getIdResource()); 
				pre.setString(2, res.getResourceName());
				pre.setString(3, res.getResourceDescription());
				// pre.setString(4, res.getCat());
				 

				return res;
			}

			// msgUser = ClaimConstanteUtil.MSG_INVALID_SEARCH;

		} catch (Exception e) {

			logger.warning(String.format(ClaimConstanteUtil.MSG_FAILLED_FIND_USER, " Error : ", e.getMessage()));

		}

		return null;
	}

	@Override
	public Resource findRessourceByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> findAllRessource() {
		// TODO Auto-generated method stub
		return null;
	}

}
