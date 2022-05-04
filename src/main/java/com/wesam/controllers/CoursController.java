package com.wesam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesam.entities.Cours;
import com.wesam.services.CoursService;

@RestController
@RequestMapping("/cours")
@CrossOrigin(origins = "http://localhost:4200")
public class CoursController {

	@Autowired
	CoursService coursService;

	@GetMapping("/getCours")
	ResponseEntity<List<Cours>> listOfCours() {
		try {
			List<Cours> list = coursService.ListCours();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Desc", "list of coures");
			return new ResponseEntity<List<Cours>>(list, headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/createCours")
	ResponseEntity<Cours> addCours(@RequestBody Cours cours){
		try {
			Cours coursSaved = coursService.addCours(cours);
			return new ResponseEntity<Cours>(coursSaved, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/updateCours")
	ResponseEntity<Cours> updateCours(@RequestBody Cours cours) {
		try {
			Cours coursUpdated = coursService.updateCours(cours);
			return new ResponseEntity<Cours>(coursUpdated, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/deleteCours/{id}")
	ResponseEntity<?> deleteCours(@PathVariable long id) {
		try {
			coursService.deleteCours(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
