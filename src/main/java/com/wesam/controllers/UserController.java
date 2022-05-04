package com.wesam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesam.entities.User;
import com.wesam.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getCours")
	ResponseEntity<List<User>> listOfUsers() {
		try {
			List<User> list = userService.getUsers();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Desc", "list of coures");
			return new ResponseEntity<List<User>>(list, headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PutMapping("/updateUser")
	ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			User userUpdated = userService.updateUser(user);
			return new ResponseEntity<User>(userUpdated, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/deleteUser/{id}")
	ResponseEntity<?> deleteUser(@PathVariable long id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	
	

}
