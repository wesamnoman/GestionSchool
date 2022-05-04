package com.wesam;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wesam.entities.User;
import com.wesam.repositories.UserRepository;
@SpringBootApplication
public class GestionSchoolApplication {

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(GestionSchoolApplication.class, args);
			
	}
}
