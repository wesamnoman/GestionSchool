package com.wesam.servicesImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesam.entities.Cours;
import com.wesam.entities.Student;
import com.wesam.repositories.StudentRepository;
import com.wesam.services.CoursService;
import com.wesam.services.StudentService;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	  StudentRepository studentRepository; 
	@Autowired
	  CoursService coursService;  

	@Override
	public List<Student> listStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		Student s =new Student();
		s.setStudentName(student.getStudentName());
		s.setAddress(student.getAddress());
		s.setDate(student.getDate());
		s.setGender(student.getGender());
		s.setCours(student.getCours().stream()
				.map(c->{
					Cours cours =c;
					if(cours.getCoursId()>0) {
						cours =coursService.findCoursById(cours.getCoursId());
					}
					cours.addStudent(s);
					return cours;
				}).collect(Collectors.toList()));
				
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Student s = findStudentById(student.getStudentId());
		s.setAddress(student.getAddress());
		s.setCours(student.getCours());
		s.setDate(student.getDate());
		s.setGender(student.getGender());
		s.setStudentName(student.getStudentName());
		studentRepository.save(s);
		return s;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student findStudentById(long id) {
		
		return studentRepository.findById(id).get();
	}

}
