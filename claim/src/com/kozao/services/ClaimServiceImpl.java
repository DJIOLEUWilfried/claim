package com.kozao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import com.kozao.models.Claim;

import com.kozao.models.enumations.StatusClaim;
import com.kozao.utils.ClaimConstanteUtil;

public class ClaimServiceImpl implements ClaimService{

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public int addReclamation(Claim claim, StatusClaim statusClaim, int userId, int resourceId) {
		int r = 0;

		try {
			
			Connection con = ConnexionDB.getConnection();
			PreparedStatement pre = con.prepareStatement(ClaimConstanteUtil.QUERY_CREATE_CLAIM);

			pre.setString(1, claim.getReason());
			pre.setString(2, claim.getSubmissionDate());
			pre.setString(3, claim.getConfirmationDate());
			pre.setString(4, claim.getPriority());
			pre.setString(5, StatusClaim.PENDING.toString());
			pre.setInt(6, userId);
			pre.setInt(7, resourceId);

			r = pre.executeUpdate();

		} catch (SQLException e) {
			logger.error(String.format("\n Error : %s", e));
		}

		return r;
	}

	@Override
	public int updateReclamation(Claim claim, StatusClaim statusClaim, int userId, int resourceId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStatusReclamation(Claim claim, StatusClaim statusClaim, int userId, int resourceId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReclamation(int claimId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Claim findReclamationById(int claimId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim findReclamationByIdUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> findAllReclamation() {
		// TODO Auto-generated method stub
		return null;
	}

}
