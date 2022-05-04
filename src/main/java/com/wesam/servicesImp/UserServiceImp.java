package com.wesam.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesam.entities.User;
import com.wesam.repositories.UserRepository;
import com.wesam.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		User userRequest = findUserById(user.getId());
		userRequest.setUsername(user.getUsername());
		userRequest.setPassword(user.getPassword());
		userRequest.setRole(user.getRole());
		userRequest.setEnabled(user.isEnabled());
		userRepository.save(userRequest);
		return userRequest;
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User findUserById(long id) {
		return userRepository.findById(id).get();
	}

}
