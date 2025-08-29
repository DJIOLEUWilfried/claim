package com.kozao.controllers;

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
	
	
	//     id_claim, resource_id, reason, id_user, submission_date, confirmation_date, status_claim, priority

	public void addUserController(int resourceId, String reason, int idUser, String priority) {
		reason = reason.trim();
		
		if (ClaimControlUserUtil.checkAllFields(reason, priority) || resourceId < 1 || idUser < 1 ) {

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
        claim.setPriority("Urgent");

		int r = claimService.addReclamation(claim);
		
		msgClaimController = (r > 0) ? ClaimConstanteUtil.MSG_CREATE_CLAIM : ClaimConstanteUtil.MSG_FAILED_CLAIM_RESOURCE;		
	}    

}
