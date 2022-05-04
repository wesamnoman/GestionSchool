package com.wesam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wesam.entities.Address;
import com.wesam.entities.Cours;
import com.wesam.entities.CoursMaterial;
import com.wesam.entities.Gender;
import com.wesam.entities.Student;
import com.wesam.entities.Teacher;
import com.wesam.repositories.CoursMaterialRepository;
import com.wesam.repositories.CoursRepository;
import com.wesam.repositories.StudentRepository;
import com.wesam.repositories.TeacherRepository;

@SpringBootTest
class GestionSchoolApplicationTests {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CoursRepository coursRepository;
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	CoursMaterialRepository coursMaterialRepository;
	
	@Test
	void addStudent() {
		long id1 =1;
		long id2 =2;
		long id3 =3;
		long id4 =4;
		long id5 =5;
		long id6 =6;
		Cours c1= coursRepository.findById(id1).get();
		Cours c2 = coursRepository.findById(id2).get();
		Cours c3 = coursRepository.findById(id3).get();
		Cours c4= coursRepository.findById(id4).get();
		Cours c5 = coursRepository.findById(id5).get();
		Cours c6 = coursRepository.findById(id6).get();
		Cours cours1 = Cours.builder()
				.coursName("Java")
				.build();
		Cours cours2 = Cours.builder()
				.coursName("Angular")
				.build();
		Cours cours3 = Cours.builder()
				.coursName("Html")
				.build();
		Cours cours4 = Cours.builder()
				.coursName("Sql")
				.build();
		Cours cours5 = Cours.builder()
				.coursName("english")
				.build();
		Cours cours6 = Cours.builder()
				.coursName("Spanish")
				.build();
		List<Cours> listCours = List.of(cours1,cours2,cours3, cours4, cours5, cours6);
		//coursRepository.saveAll(listCours);
		
		Address address =Address.builder()
				.city("Pamplona")
				.number(31007)
				.street("Sancho El fuerte")
				.build();
		Student student =Student.builder()
				.address(address)
				.gender(Gender.MALE)
				.studentName("Ikram")
				.date(LocalDate.of(1999, 01, 01))
				.cours(List.of(cours3,cours4))
				.build();
		studentRepository.save(student);
		
		
		
		Teacher teacher =Teacher.builder()
				.address(address)
				.gender(Gender.MALE)
				.teacherName("Eduardo")
				.cours(List.of(c4,c5,c6))
				.build();
	//   teacherRepository.save(teacher);
		
		CoursMaterial coursMaterial =CoursMaterial.builder()
				.coursMaterialUrl("http://facebook.com")
			    .cours(c6)
				.build();
		//coursMaterialRepository.save(coursMaterial);
		
		
	}
	
	@Test
	void getCours() {
		List<Cours> list = coursRepository.findAll();
		System.out.println(list);
	}
	

	@Test
	void contextLoads() {
	}
	
	

}
