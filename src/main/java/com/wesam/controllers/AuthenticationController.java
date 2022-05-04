package com.wesam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesam.entities.User;
import com.wesam.securityCofig.AutenticationRequest;
import com.wesam.securityCofig.AutenticationResponse;
import com.wesam.securityCofig.JwtUtil;
import com.wesam.securityCofig.MyUserDetailsService;
import com.wesam.services.UserService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@PostMapping("/autenticate")
	public ResponseEntity<?> autenticate(@RequestBody AutenticationRequest request) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					request.getUsername(),request.getPassword()));
			
		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username or password",e);
		}
		final UserDetails userDetails = myUserDetailsService
				.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AutenticationResponse(jwt));
	}
	
	
	
	@PostMapping("/createUser")
	ResponseEntity<User> createUser(@RequestBody User user){
		try {
			String passEncoded = encoder.encode(user.getPassword());
			user.setPassword(passEncoded);
			User userSaved = userService.addUser(user);
			return new ResponseEntity<User>(userSaved,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
     
}
