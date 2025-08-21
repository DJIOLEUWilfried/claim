package com.kozao.services;

import java.util.List;

import com.kozao.models.User;

public interface UserService {

	int addUser(User user);

	int updateUserProfil(User user);

	int updatePassWord(String oldPassword, String newPassword);

	boolean findPassWord(String passWord);

	int disableUser(int id);

	int enableUser(int id);

	int deleteUser(int id);
	
	User login(String user_email);

	User findUserById(int id);

	User findUserByName(String name);

	User findUserByFirstName(String firstName);

	List<User> findAllUser();
	
	

}
