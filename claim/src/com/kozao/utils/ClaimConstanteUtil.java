package com.kozao.utils;

public class ClaimConstanteUtil {
	
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/claims_management";
	public static final String USER = "root";
	public static final String PASSWORD = "";	
	public static final String JDBC_IS_NULL = "Driver JDBC non trouv� : ";
	public static final String CONNEXION_ERROR = "Connexion error !! ";
	
	// User
	public static final String QUERY_CREATE_USER = "INSERT INTO users (user_name, user_first_name, user_email, user_role, user_status, password) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String QUERY_UPDATE_USER = "UPDATE users SET user_name=?, user_first_name=?, user_email=?, user_role=?, password=? WHERE id_user=?";
	public static final String QUERY_UPDATE_USER_PROFIL = "UPDATE users SET user_name=?, user_first_name=?, user_email=? WHERE id_user=?";
	public static final String QUERY_UPDATE_PASSWORD = "UPDATE users SET password=? WHERE user_name=?";
	public static final String QUERY_FIND_PASSWORD = "SELECT password FROM users WHERE password=?";
	public static final String QUERY_STAUT_USER = "UPDATE users SET user_status=? WHERE id_user=?";	
	public static final String QUERY_DELETE_USER = "DELETE FROM users WHERE id_user=?";
	public static final String QUERY_FIND_USER_BY_ID = "SELECT id_user, user_name, user_first_name, user_email, user_role, user_status FROM users WHERE id_user=?";
	public static final String QUERY_FIND_USER_BY_NAME = "SELECT id_user, user_name, user_first_name, user_email, user_role, user_status, password FROM users WHERE user_name=?";
	public static final String QUERY_FIND_USER_BY_FIRST_NAME = "SELECT id_user, user_name, user_first_name, user_email, user_role, user_status FROM users WHERE user_first_name=?";
	public static final String QUERY_FIND_ALL_USER = "SELECT id_user, user_name, user_first_name, user_email, user_role, user_status FROM users ";
	public static final String QUERY_LOGIN_USER = "SELECT user_name, user_role FROM users WHERE user_email=? AND password=?" ;
	public static final String QUERY_FIND_EMAIL = "SELECT user_name, user_role, user_status, password FROM users WHERE user_email=?" ;

	
	public static final String CHAMP_IS_EMPTY = "\n Please fill in all fields !!" ;
	public static final String MSG_CREATE_USER = "\n User created successfully !!" ;
	public static final String MSG_FAILED_CREATE_USER = "\n Failed to create user !!" ;
	public static final String MSG_UPDATE_USER = "\n User successfully modified !!" ;
	public static final String MSG_FAILED_UPDATE_USER = "\n User modification failed !!" ;
	public static final String MSG_UPDATE_PROFIL = "Profile successfully modified !!";
	public static final String MSG_FAILED_UPDATE_PROFIL = "Failed profile change !!";
	public static final String MSG_PASSWORD_NOT_EXIST = "Your password does not exist !!";
	public static final String MSG_UPDATE_PASSWORD = "Password successfully changed !!";
	public static final String MSG_FAILED_UPDATE_PASSWORD = "Password change failed !!";
	public static final String MSG_DISABLE_USER_STATUS = "User successfully deactivated !!";
	public static final String MSG_FAILED_DISABLE_USER_STATUS = "Failed to deactivate user !!";
	public static final String MSG_ENABLE_USER_STATUS = "User successfully activated !!";
	public static final String MSG_FAILED_ENABLE_USER_STATUS = "User activation failed !!";
	public static final String QUERY_USER_DELETE = "User successfully deleted !!";
	public static final String QUERY_FAILED_USER_DELETE = "Failed to delete user !!";
	public static final String MSG_FAILLED_FIND_USER = "User search error !!";
	public static final String MSG_INVALID_SEARCH = "Invalid search !!";
	public static final String MSG_REQUIRED_FIELDS = "Please fill in all fields !!";
	public static final String MSG_INVALID_EMAIL = "Invalid email !!";   
	public static final String MSG_PASSWORD_INVALID = "This password does not exist !!";
	public static final String MSG_ERROR_LOGIN = "Your login details are incorrect !!";
	public static final String MSG_VALIDE_ID = "Please enter a valid id";
	public static final String MSG_FAILED_SEND_PASSWORD = "Failed to send password via email address !!";
	public static final String MSG_INVALID_ROLE = "Please enter a valid role !!";
	public static final String MSG_DISABLE_STATUS = "Unable to log in, you have been disabled by the administrator. Please contact them !!" ;
	public static final String MSG_TEST_FAILED = "Test failed !!" ;
	public static final String MSG_ACCOUNT_ALREADY_EXISTS = "An account already exists with this email address !!";
	public static final String MSG_USER_NOT_NULL = "The user object must not be null !!";
	
	
	// Resource      
	public static final String QUERY_CREATE_RESOURCE = "INSERT INTO resource (resource_name, resource_description) VALUES (?, ?)";
	public static final String QUERY_UPDATE_RESOURCE = "UPDATE resource SET resource_name=?, description_resource=? WHERE resource_id=?" ;
	public static final String QUERY_DELETE_RESOURCE = "DELETE resource FROM resource_id=?" ;  
	public static final String QUERY_FIND_RESOURCE_BY_ID = "SELECT resource_id, resource_name, resource_description FROM resource WHERE resource_id=?";
	public static final String QUERY_FIND_RESOURCE_BY_NAME = "SELECT resource_id, resource_name, resource_description FROM resource WHERE resource_name=?";
	public static final String QUERY_FIND_ALL_RESOURCE = "SELECT resource_id, resource_name, resource_description FROM resource ";

	
	public static final String MSG_CREATE_RESOURCE = "Resource created successfully !!" ;
	public static final String MSG_FAILED_CREATE_RESOURCE = "Failed to create resource !!" ;
	public static final String MSG_UPDATE_RESOURCE = "\n Resource successfully modified !!" ;
	public static final String MSG_FAILED_UPDATE_RESOURCE = "\n Resource modification failed !!" ;
	public static final String QUERY_RESOURCE_DELETE = "Resource successfully deleted !!" ;
	public static final String QUERY_FAILED_RESOURCE_DELETE = "Failed to delete resource !!" ;
	public static final String MSG_FAILLED_FIND_RESOURCE = "Resource search error !!";
	
	
	
	// Claim
	public static final String QUERY_CREATE_CLAIM = "INSERT INTO claim (reason, submission_date, confirmation_date, priority, status_claim, id_user, resource_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

	
	
	
	
	
}

