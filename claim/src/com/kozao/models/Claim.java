package com.kozao.models;

import com.kozao.models.enumations.StatusClaim;

public class Claim {
	
	private int idClaim;
	private String reason;
	private String submissionDate ;
	private String confirmationDate ;
	private String priority ;
	
	private StatusClaim statusClaim;
	private User userId;
	private Resource resourceId;

	public Claim() {}
	
	public Claim(String reason, String submissionDate, String confirmationDate, String priority, StatusClaim statusClaim,
			User userId, Resource resourceId) {
		super();
		this.reason = reason;
		this.submissionDate = submissionDate;
		this.confirmationDate = confirmationDate;
		this.priority = priority;
		this.statusClaim = statusClaim;
		this.userId = userId;
		this.resourceId = resourceId;
	}
	
	public int getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getConfirmationDate() {
		return confirmationDate;
	}
	public void setConfirmationDate(String confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public StatusClaim isStatusClaim() {
		return statusClaim;
	}
	public void setStatusClaim(StatusClaim statusClaim) {
		this.statusClaim = statusClaim;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Resource getResourceId() {
		return resourceId;
	}

	public void setResourceId(Resource resourceId) {
		this.resourceId = resourceId;
	}

	public StatusClaim getStatusClaim() {
		return statusClaim;
	}
	
	
	@Override
	public String toString() {
		return String.format("Id= %s  Resource= %s  Reason= %s  Owner= %s  Submission Date= %s  Confirmation Date= %s  Status= %s  Priority= %s", 
				idClaim, resourceId.getResourceName(), reason, userId.getUserName(), submissionDate, confirmationDate, statusClaim, priority);
				
	}

	

}
