package com.wesam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesam.entities.Cours;
import com.wesam.entities.Teacher;
import com.wesam.services.CoursService;
import com.wesam.services.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	@Autowired
	CoursService cousService;

	@GetMapping("/getTeachers")
	ResponseEntity<List<Teacher>> getTeachers() {
		
		try {
			List<Teacher> list = teacherService.getAllTeachers();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Descriptions", "list of teachers");
			HttpStatus status = HttpStatus.FOUND;
			return new ResponseEntity<List<Teacher>>(list, headers, status);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/addTeacher")
	ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		try {
			Teacher tr = teacherService.addTeacher(teacher);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Descriptions", "adding teacher");
			HttpStatus status = HttpStatus.CREATED;
			return new ResponseEntity<Teacher>(tr, headers, status);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
