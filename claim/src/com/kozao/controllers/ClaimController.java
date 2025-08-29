package com.kozao.controllers;

import java.util.List;

import com.kozao.models.Claim;
import com.kozao.models.User;
import com.kozao.models.enumations.StatusClaim;
import com.kozao.services.ClaimService;
import com.kozao.services.ClaimServiceImpl;
import com.kozao.utils.ClaimConstanteUtil;
import com.kozao.utils.ClaimControlClaimUtil;
import com.kozao.utils.ClaimControlUserUtil;
import com.kozao.models.Resource;

public class ClaimController {
	
	Claim claim = new Claim();
	ClaimService claimService = new ClaimServiceImpl();
	public static String msgClaimController ;

	public void addClaimController(int resourceId, String reason, int idUser) {
		reason = reason.trim();
		
		if (ClaimControlUserUtil.checkAllFields(reason) || resourceId < 1 || idUser < 1 ) {

			msgClaimController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;	
			return;
		}  

		Resource resource = new Resource();
		resource.setIdResource(resourceId);
		
		User user = new User();
		user.setIdUser(idUser);
		
		claim.setResourceId(resource);
		claim.setReason(reason);  
		claim.setUserId(user);
		claim.setSubmissionDate(ClaimControlClaimUtil.dateAndTime());
        claim.setConfirmationDate(null);
        claim.setStatusClaim(StatusClaim.PENDING);

		int r = claimService.addClaim(claim);
		
		msgClaimController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_CLAIM : ClaimConstanteUtil.MSG_FAILED_CREATE_CLAIM;		
	}    

	public void updateClaimController(int resourceId, String reason, int claimId) {

		reason = reason.trim();
        
		if (ClaimControlUserUtil.checkAllFields(reason) || resourceId < 1 || claimId < 1) {

			msgClaimController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		Resource resource = new Resource();
		resource.setIdResource(resourceId);
		
		claim.setReason(reason);
		claim.setResourceId(resource);
		claim.setIdClaim(claimId);

		int r = claimService.updateClaim(claim);

		msgClaimController = (r > 0) ? ClaimConstanteUtil.MSG_UPDATE_CLAIM
				: ClaimConstanteUtil.MSG_FAILED_UPDATE_CLAIM;

	}

	public void updateStatusClaim(String statusClaim, int claimId) {

		statusClaim = statusClaim.trim().toUpperCase();
        
		if (ClaimControlUserUtil.checkAllFields(statusClaim) || claimId < 1){
			msgClaimController = ClaimConstanteUtil.MSG_REQUIRED_FIELDS;
			return;
		}

		if ( !ClaimControlClaimUtil.enumValid(statusClaim) ) {
			msgClaimController = ClaimConstanteUtil.MSG_SELECT_VALID_STATUS;
			return;
		}
		
		StatusClaim status = StatusClaim.valueOf(statusClaim);
		
		claim.setStatusClaim(status);
		claim.setIdClaim(claimId);
		
		int r = claimService.updateStatusClaim(claim);
	
		msgClaimController = (r > 0) ? ClaimConstanteUtil.MSG_UPDATE_STATUS_CLAIM
				: ClaimConstanteUtil.MSG_FAILED_UPDATE__STATUSCLAIM;
        
	}

	public void deleteClaimController(int claimId) {
		if (claimId < 1) {
			msgClaimController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return ;  
		} 
		
		int r = claimService.deleteClaim(claimId);
		
		msgClaimController = (r > 0) ? ClaimConstanteUtil.MSG_CLAIM_DELETE
			            	: ClaimConstanteUtil.MSG_FAILED_CLAIM_DELETE;
	}

	public Claim findClaimById(int claimId) {
		if (claimId < 1) {
			msgClaimController = ClaimConstanteUtil.MSG_VALIDE_ID;
			return null;
		}
		Claim claim = claimService.findClaimById(claimId);

		if (claim == null) {
			msgClaimController = ClaimConstanteUtil.MSG_FAILLED_FIND_CLAIM;
			return null;
		}

		return claim; 
	}

	public List<Claim> findClaimByIdUser(int userId){
		 List <Claim> allClaim = claimService.findClaimByIdUser(userId);
		 
		 return allClaim ;
	}
	
	public List<Claim> findAllClaim(){
		 List <Claim> allClaim = claimService.findAllClaim();
		 
		 return allClaim ;
	}

	public List<Claim> historyOfAllClaims(String date){
		 List <Claim> allClaim = claimService.historyOfAllClaims(date);
		 
		 return allClaim ;
	}


}
