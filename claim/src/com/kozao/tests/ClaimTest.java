package com.kozao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.kozao.controllers.ClaimController;
import com.kozao.controllers.ResourceController;
import com.kozao.models.Claim;
import com.kozao.models.Role;
import com.kozao.utils.ClaimConstanteUtil;

public class ClaimTest {

	ClaimController claimController = new ClaimController();
/*
	
	@Test
	public void testCreateResource() { // int resourceId, String reason,

		claimController.addClaimController(5, "Mon disque dur ne fonctionne plus!!", 1);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CREATE_CLAIM,
				ClaimController.msgClaimController);
	}

	@Test
	public void testUpdateClaimController() { // int resourceId, String

		claimController.updateClaimController(4, "Ma souris est en fonctionne plus !!", 1);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_CLAIM,
				ClaimController.msgClaimController);
	}

	@Test
	public void testUpdateStatusClaim() { // String statusClaim, int

		claimController.updateStatusClaim("INPROGRESS", 1);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_UPDATE_STATUS_CLAIM,
				ClaimController.msgClaimController);
	}

	@Test
	public void testDeleteClaimController() {

		claimController.deleteClaimController(2);

		assertEquals(ClaimConstanteUtil.MSG_TEST_FAILED, ClaimConstanteUtil.MSG_CLAIM_DELETE,
				ClaimController.msgClaimController);
	}
   
	
	@Test
	public void testFindClaimById() {

		Claim claim = claimController.findClaimById(3);

		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, claim);
	}

   
	
	@Test
	public void testFindClaimByIdUser(){
		List<Claim> claim = claimController.findClaimByIdUser(3);
		
		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, claim);
	}

   
	@Test
	public void testFindAllClaim() {

		List<Claim> claim = claimController.findAllClaim();
		
		assertNotNull(ClaimConstanteUtil.MSG_OBJET_NULL, claim);
	}
 */
	
	@Test
	public void testHistoryOfAllClaims() {

		List<Claim> claim = claimController.historyOfAllClaims("28-08-202");
		
		System.out.println("Recla == " + claim);

		
		assertFalse(ClaimConstanteUtil.MSG_LIST_NULL, claim.isEmpty());
	}
	
	
}
