package com.kozao.services;

import java.util.List;

import com.kozao.models.Category;
import com.kozao.models.Claim;
import com.kozao.models.Resource;
import com.kozao.models.User;

public interface ClaimService {

	int addReclamation(Claim claim, User user, Resource resource);

	int updateReclamation(Claim claim, User user, Resource resource);

	int deleteReclamation(int claimId);

	Claim findReclamationById(int claimId);
	
	Claim findReclamationByIdUser(int userId);

	List<Claim> findAllReclamation();

}
