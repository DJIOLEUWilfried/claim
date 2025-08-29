package com.kozao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.kozao.models.Claim;
import com.kozao.models.Resource;
import com.kozao.models.Role;
import com.kozao.models.User;
import com.kozao.models.enumations.StatusClaim;
import com.kozao.utils.ClaimConstanteUtil;

public class ClaimServiceImpl implements ClaimService{

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public int addReclamation(Claim claim) {
		int r = 0;

		try {
	//     id_claim, resource_id, reason, id_user, submission_date, confirmation_date, status_claim, priority
			
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_CREATE_CLAIM);

			pre.setInt(1, claim.getResourceId().getIdResource());
			pre.setString(2, claim.getReason());
			pre.setInt(3, claim.getUserId().getIdUser());
			pre.setString(4, claim.getSubmissionDate());
			pre.setString(5, claim.getConfirmationDate());
			pre.setString(6, claim.getStatusClaim().name());  // PENDING
			pre.setString(7, claim.getPriority());

			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int updateReclamation(Claim claim) {
		int r = 0;

		try {
			// resource_id, reason, id_user, submission_date, confirmation_date, status_claim, priority
			
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_CLAIM);

			pre.setInt(1, claim.getResourceId().getIdResource());
			pre.setString(2, claim.getReason());		
			pre.setString(3, claim.getPriority());
			pre.setInt(4, claim.getIdClaim());
			
			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int updateStatusReclamation(Claim claim) {
		int r = 0;

		try {
			
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_UPDATE_STATUS_CLAIM);

			pre.setString(1, claim.getStatusClaim().name());		
			pre.setInt(2, claim.getIdClaim());
			
			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int deleteReclamation(int claimId) {
		try {
			
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_DELETE_CLAIM);
	
			pre.setInt(1, claimId );
			
			claimId = pre.executeUpdate();
			
			return claimId;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return 0;
		
	}

	@Override
	public Claim findReclamationById(int claimId) {
		
		try {
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_CLAIM_BY_ID);

			pre.setInt(1, claimId);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Resource resource = new Resource();
				resource.setResourceName(rs.getString("resource_name"));

				User user = new User();
				user.setUserName(rs.getString("user_name"));
				
				String status = rs.getString("status_claim");
				StatusClaim statusClaim = StatusClaim.valueOf(status);
				
				Claim claim = new Claim();
				
				claim.setIdClaim(rs.getInt("id_claim"));
				claim.setResourceId(resource);
				claim.setReason(rs.getString("reason"));
				claim.setUserId(user);
				claim.setSubmissionDate(rs.getString("submission_date"));
				claim.setConfirmationDate(rs.getString("confirmation_date"));
				claim.setStatusClaim(statusClaim);
				
				return claim;
			}

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}

	@Override   
	public List<Claim> findReclamationByIdUser(int userId) {
		
		List<Claim> allClaimByUser = new ArrayList<>();
		try {
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_FIND_CLAIM_BY_ID_USER);

			pre.setInt(1, userId);

			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Resource resource = new Resource();
				resource.setResourceName(rs.getString("resource_name"));

				User user = new User();
				user.setUserName(rs.getString("user_name"));
				
				String status = rs.getString("status_claim");
				StatusClaim statusClaim = StatusClaim.valueOf(status);
				
				Claim claim = new Claim();
				
				claim.setIdClaim(rs.getInt("id_claim"));
				claim.setResourceId(resource);
				claim.setReason(rs.getString("reason"));
				claim.setUserId(user);
				claim.setSubmissionDate(rs.getString("submission_date"));
				claim.setConfirmationDate(rs.getString("confirmation_date"));
				claim.setStatusClaim(statusClaim);
				
				allClaimByUser.add(claim);	
			}
			return allClaimByUser;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return null;
	}

	@Override   
	public List<Claim> findAllReclamation() {
		
		List<Claim> allClaim = new ArrayList<>();
		try {
			Connection con = ConnexionDB.getConnection();
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(ClaimConstanteUtil.QUERY_FIND_ALL_CLAIM);

			while (rs.next()) {
				
				Resource resource = new Resource();
				resource.setResourceName(rs.getString("resource_name"));

				User user = new User();
				user.setUserName(rs.getString("user_name"));
				
				String status = rs.getString("status_claim");
				StatusClaim statusClaim = StatusClaim.valueOf(status);
				
				Claim claim = new Claim();
				
				claim.setIdClaim(rs.getInt("id_claim"));
				claim.setResourceId(resource);
				claim.setReason(rs.getString("reason"));
				claim.setUserId(user);
				claim.setSubmissionDate(rs.getString("submission_date"));
				claim.setConfirmationDate(rs.getString("confirmation_date"));
				claim.setStatusClaim(statusClaim);
				
				allClaim.add(claim);	
			}

			return allClaim;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}
		
		return allClaim;
	}

	@Override
	public List<Claim> historyOfAllClaims(String date) {
		List<Claim> allClaim = new ArrayList<>();
		try {
			Connection con = ConnexionDB.getConnection();
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(ClaimConstanteUtil.QUERY_FIND_HISTORY_ALL_CLAIM);

			while (rs.next()) {
				
				Resource resource = new Resource();
				resource.setResourceName(rs.getString("resource_name"));

				User user = new User();
				user.setUserName(rs.getString("user_name"));
				
				String status = rs.getString("status_claim");
				StatusClaim statusClaim = StatusClaim.valueOf(status);
				
				Claim claim = new Claim();
				
				claim.setIdClaim(rs.getInt("id_claim"));
				claim.setResourceId(resource);
				claim.setReason(rs.getString("reason"));
				claim.setUserId(user);
				claim.setSubmissionDate(rs.getString("submission_date"));
				claim.setConfirmationDate(rs.getString("confirmation_date"));
				claim.setStatusClaim(statusClaim);
				
				allClaim.add(claim);	
			}

			return allClaim;

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}
		
		return allClaim;
	}

	
	
	

}
