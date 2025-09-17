package com.kozao.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kozao.models.*;
import com.kozao.utils.ClaimConstanteUtil;




public class UserServiceImpl implements UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	public UserServiceImpl() {}
	

	
	@Override
	public int addUser(User user) {

		if ( findEmail( user.getUserEmail() ) ) { 
			return -1;
		}
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_CREATE_USER);

			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserFirstName());
			pre.setString(3, user.getUserEmail());
			pre.setInt(4, user.getRoleJoin().getRoleId());
			pre.setBoolean(5, true);
			pre.setString(6, user.getPassWord());

			return (pre.executeUpdate() > 0) ? 1 : 0 ;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
	}

	
	@Override
	public int updateUserProfil(User user) {
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_USER_PROFIL);

			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserFirstName());
			pre.setString(3, user.getUserEmail());
			pre.setInt(4, user.getIdUser());

			return (pre.executeUpdate() > 0) ? 1 : 0 ;
			
		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
	}

	
	@Override
	public int updatePassWord(String firstName, String newPassword) {

		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_PASSWORD);

			pre.setString(1, newPassword);
			pre.setString(2, firstName);

			return (pre.executeUpdate() > 0) ? 1 : 0 ;

		} catch (SQLException e) {
			logger.error(String.format("\n . Error : %s", e.getMessage()));
		}
		
		return 0;
	}

	
	public boolean findPassWord(String oldPassword) {

		try {
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_PASSWORD);

			pre.setString(1, oldPassword);

			int rst = pre.executeUpdate();

			if (rst > 0) {
				return true;
			}

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}
		return false;
	}

	
	@Override
	public int disableUser(int id) {
		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_STAUT_USER);

			pre.setBoolean(1, false);
			pre.setInt(2, id);

			id = pre.executeUpdate();

			return id;

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));

			return 0;
		}

	}

	
	@Override
	public int enableUser(int id) {
		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_STAUT_USER);

			pre.setBoolean(1, true);
			pre.setInt(2, id);

			id = pre.executeUpdate();

			return id;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
	}

	
	@Override
	public User login(String user_email) {

		try {
			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_EMAIL);

			pre.setString(1, user_email);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				User user = new User();

				user.setUserFirstName(rs.getString("user_name"));
				// user.setUserRole(rs.getInt("user_role"));
				user.setUserStatus(rs.getBoolean("user_status"));
				user.setPassWord(rs.getString("password"));

				return user;
			}

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}
	
	
	@Override
	public int deleteUser(int id) {
		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_DELETE_USER);
			pre.setInt(1, id);

			id = pre.executeUpdate();

			return id;

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
	}

	
	@Override
	public User findUserById(int id) {

		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_USER_BY_ID);

			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Role role = new Role();
				role.setRoleName(rs.getString("role_name"));

				User user = new User();

				user.setIdUser(rs.getInt("id_user"));
				user.setUserName(rs.getString("user_name"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setRoleJoin(role);
				user.setUserStatus(rs.getBoolean("user_status"));
				
				return user;
			}

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}

	
	@Override
	public User findUserByName(String name) {

		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_USER_BY_NAME);

			pre.setString(1, name);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Role role = new Role();
				role.setRoleName(rs.getString("role_name"));

				User user = new User();

				user.setIdUser(rs.getInt("id_user"));
				user.setUserName(rs.getString("user_name"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setRoleJoin(role);
				user.setUserStatus(rs.getBoolean("user_status"));
				
				return user;
			}

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}

	
	@Override
	public User findUserByFirstName(String firstName) {

		try {

			Connection con = ConnexionDB.getConnection();

			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_USER_BY_FIRST_NAME);

			pre.setString(1, firstName);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Role role = new Role();
				role.setRoleName(rs.getString("role_name"));

				User user = new User();

				user.setIdUser(rs.getInt("id_user"));
				user.setUserName(rs.getString("user_name"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setRoleJoin(role);
				user.setUserStatus(rs.getBoolean("user_status"));
				user.setPassWord(rs.getString("password"));
				
				return user;
			}

		} catch (SQLException e) {

			logger.error(String.format("\n Error : %s", e));
		}

		return null;

	}


	public boolean findEmail(String user_email) {
		try {

			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_EMAIL);

			pre.setString(1, user_email);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) { return true; }

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}
		return false;
	}
	
	
	@Override
	public List<User> findAllUser() {

		List<User> allUser = new ArrayList<>();

		try {
			Connection con = ConnexionDB.getConnection();
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(ClaimConstanteUtil.QUERY_FIND_ALL_USER);

			while (rs.next()) {
				
                Role role = new Role();
				role.setRoleName(rs.getString("role_name"));

                User user = new User();
				user.setIdUser(rs.getInt("id_user"));
				user.setUserName(rs.getString("user_name"));
				user.setUserFirstName(rs.getString("user_first_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setRoleJoin(role);
				user.setUserStatus(rs.getBoolean("user_status"));
				
				allUser.add(user);
			}

			return allUser;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return allUser;
	}

	
	public int forgotPassword(String email) {
		
		return 0;
	}
	
	
	
}
