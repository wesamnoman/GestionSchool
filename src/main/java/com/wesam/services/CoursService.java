package com.wesam.services;

import java.util.List;

import com.wesam.entities.Cours;

public interface CoursService {
	
	List<Cours>ListCours();
	Cours addCours(Cours cours);
	void deleteCours(long id);
	Cours updateCours(Cours cours);
	Cours findCoursById(long id);

}
