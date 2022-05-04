package com.wesam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesam.entities.CoursMaterial;
import com.wesam.entities.User;
import com.wesam.services.CoursMaterialService;

@RestController
@RequestMapping("/coursMaterial")
public class CoursMaterialController {
	
	@Autowired
	CoursMaterialService coursMaterialService;
	
	
	@GetMapping("/getCoursMaterial")
	ResponseEntity<List<CoursMaterial>> getListOfCoursMaterial(){
		try {
			
			List<CoursMaterial> list = coursMaterialService.getAllMaterials();
			return new ResponseEntity<List<CoursMaterial>>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addCoursMaterial")
	ResponseEntity<CoursMaterial> addCoursMaterial(@RequestBody CoursMaterial coursMaterial){
		try {
			
			CoursMaterial crM = coursMaterialService.addCoursMaterial(coursMaterial);
			return new ResponseEntity<CoursMaterial>(crM, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateCoursMaterial")
	ResponseEntity<CoursMaterial> updateCoursMaterial(@RequestBody CoursMaterial updateCoursMaterial) {
		try {
			CoursMaterial coursMateriadUpdated = coursMaterialService.updateCoursMaterial(updateCoursMaterial);
			return new ResponseEntity<CoursMaterial>(coursMateriadUpdated, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/deleteCoursMaterial/{id}")
	ResponseEntity<?> deleteCoursMaterial(@PathVariable long id) {
		try {
			coursMaterialService.deleteCoursMaterial(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
