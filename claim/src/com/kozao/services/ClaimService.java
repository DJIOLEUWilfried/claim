package com.kozao.services;

import java.util.List;

import com.kozao.models.Category;
import com.kozao.models.Claim;
import com.kozao.models.Resource;
import com.kozao.models.StatusClaim;
import com.kozao.models.User;

public interface ClaimService {

	int addReclamation(Claim claim, StatusClaim statusClaim, int userId, int resourceId);

	int updateReclamation(Claim claim, StatusClaim statusClaim, int userId, int resourceId);
	
	int updateStatusReclamation(Claim claim, StatusClaim statusClaim, int userId, int resourceId);

	int deleteReclamation(int claimId);

	Claim findReclamationById(int claimId);
	
	Claim findReclamationByIdUser(int userId);

	List<Claim> findAllReclamation();

}
