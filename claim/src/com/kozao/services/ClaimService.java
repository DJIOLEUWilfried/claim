package com.kozao.services;

import java.util.List;

import com.kozao.models.Category;
import com.kozao.models.Claim;
import com.kozao.models.User;

public interface ClaimService {

	Claim addReclamation(Claim claim, User user, Category cat);

	Claim updateReclamation(Claim claim, User user, Category cat);

	Claim deleteReclamation(int id);

	Claim findReclamation(Claim recl);

	List<Claim> findAllReclamation();

}
