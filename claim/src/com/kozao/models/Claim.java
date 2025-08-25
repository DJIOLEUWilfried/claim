package com.kozao.models;

public class Claim {
	
	private int idClaim;
	private String reason;
	private String submissionDate ;
	private String confirmationDate ;
	private String priority ;
	private StatusClaim statusClaim;
	
	private User user;
	private Resource resource_id;

	public Claim() {}
	
	public Claim(String reason, String submissionDate, String confirmationDate, String priority, StatusClaim statusClaim,
			User user, Resource resource_id) {
		super();
		this.reason = reason;
		this.submissionDate = submissionDate;
		this.confirmationDate = confirmationDate;
		this.priority = priority;
		this.statusClaim = statusClaim;
		this.user = user;
		this.resource_id = resource_id;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Resource getResource_id() {
		return resource_id;
	}
	public void setResource_id(Resource resource_id) {
		this.resource_id = resource_id;
	}
	

	
	

}
