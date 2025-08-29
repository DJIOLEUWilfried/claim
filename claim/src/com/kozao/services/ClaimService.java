package com.kozao.services;

import java.util.List;

import com.kozao.models.Claim;
import com.kozao.models.enumations.StatusClaim;

public interface ClaimService {

	int addClaim(Claim claim);

	int updateClaim(Claim claim);
	
	int updateStatusClaim(Claim claim);

	int deleteClaim(int claimId);

	Claim findClaimById(int claimId);

	List<Claim> findClaimByIdUser(int userId);
	
	List<Claim> findAllClaim();
	
	List<Claim> historyOfAllClaims(String date);

}
