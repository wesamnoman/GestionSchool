package com.wesam.services;

import java.util.List;

import com.wesam.entities.Student;

public interface StudentService {
	
	List<Student> listStudent();
	Student addStudent(Student student);
	Student updateStudent(Student student);
	void deleteStudent(long id);
	Student findStudentById(long id);

}
