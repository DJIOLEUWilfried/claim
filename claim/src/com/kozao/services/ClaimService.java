package com.kozao.services;

import java.util.List;

import com.kozao.models.Claim;
import com.kozao.models.enumations.StatusClaim;

public interface ClaimService {

	int addReclamation(Claim claim);

	int updateReclamation(Claim claim);
	
	int updateStatusReclamation(Claim claim);

	int deleteReclamation(int claimId);

	Claim findReclamationById(int claimId);

	List<Claim> findReclamationByIdUser(int userId);
	
	List<Claim> findAllReclamation();
	
	List<Claim> historyOfAllClaims(String date);

}
