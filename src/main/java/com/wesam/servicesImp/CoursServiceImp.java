package com.wesam.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesam.entities.Cours;
import com.wesam.repositories.CoursRepository;
import com.wesam.services.CoursService;

@Service
public class CoursServiceImp  implements CoursService{
	@Autowired
	CoursRepository coursRepository;

	@Override
	public List<Cours> ListCours() {
		
		return coursRepository.findAll();
	}

	@Override
	public Cours addCours(Cours cours) {
		return coursRepository.save(cours);
	}

	@Override
	public void deleteCours(long id) {
		coursRepository.deleteById(id);
		
	}

	@Override
	public Cours updateCours(Cours cours) {
	Cours c =findCoursById(cours.getCoursId());
	   c.setCoursName(cours.getCoursName());
	   c.setCoursMaterial(cours.getCoursMaterial());
	   c.setStudent(cours.getStudent());
	   c.setTeacher(cours.getTeacher());
	   coursRepository.save(c);
		return c;
	}

	@Override
	public Cours findCoursById(long id) {
		return coursRepository.findById(id).get();
	}

}
