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

import com.wesam.entities.Student;
import com.wesam.repositories.StudentRepository;
import com.wesam.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/getStudent")
	ResponseEntity<List<Student>> listOfStudent() {
		try {
			List<Student> list = studentService.listStudent();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Desc", "List of Student");
			return new ResponseEntity<List<Student>>(list, headers, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("addStudent")
	ResponseEntity<Student> addStudent(@RequestBody Student student) {
		try {
			Student studentSaved = studentService.addStudent(student);
			return new ResponseEntity<Student>(studentSaved, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
