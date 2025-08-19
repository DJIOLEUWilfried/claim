package com.kozao.models;

public class Claim {
	
	private int idClaim;
	private String reason;
	private String submissionDate ;
	private String confirmationDate ;
	private String priority ;
	private boolean statusClaim;
	
	private User user;
	private Category category;
	

	public Claim() {
		super();
	}

	public Claim(String reason, String submissionDate, String confirmationDate, String priority,
			boolean statusClaim, User user, Category category) {
		super();
		this.reason = reason;
		this.submissionDate = submissionDate;
		this.confirmationDate = confirmationDate;
		this.priority = priority;
		this.statusClaim = statusClaim;
		this.user = user;
		this.category = category;
		
		
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
	public boolean getStatusClaim() {
		return statusClaim;
	}
	public void setStatusClaim(boolean statusClaim) {
		this.statusClaim = statusClaim;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
