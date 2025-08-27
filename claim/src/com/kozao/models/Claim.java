package com.kozao.models;

import com.kozao.models.enumations.StatusClaim;

public class Claim {
	
	private int idClaim;
	private String reason;
	private String submissionDate ;
	private String confirmationDate ;
	private String priority ;
	private StatusClaim statusClaim;
	
	private int userId;
	private int resourceId;

	public Claim() {}
	
	public Claim(String reason, String submissionDate, String confirmationDate, String priority, StatusClaim statusClaim,
			int userId, int resourceId) {
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	

	
	

}
