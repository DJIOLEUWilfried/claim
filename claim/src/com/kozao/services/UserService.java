package com.kozao.services;

import java.util.List;

import com.kozao.models.User;

public interface UserService {

	int addUser(User user);

	int updateUserProfil(User user);

	int updatePassWord(String oldPassword, String newPassword);

	boolean findPassWord(String passWord);

	int disableUser(int userId);

	int enableUser(int userId);

	int deleteUser(int userId);
	
	User login(String userEmail);

	User findUserById(int userId);

	User findUserByName(String userUame);

	User findUserByFirstName(String userFirstName);

	List<User> findAllUser();	

}
