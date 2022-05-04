package com.wesam.services;

import java.util.List;

import com.wesam.entities.User;

public interface UserService {
	
	List<User> getUsers();
	User addUser(User user);
	User updateUser (User user);
	void deleteUser(long id);
	User findUserById(long id);

}
