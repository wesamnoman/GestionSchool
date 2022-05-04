package com.wesam.services;

import java.util.List;

import com.wesam.entities.CoursMaterial;

public interface CoursMaterialService {
	
	
	List<CoursMaterial> getAllMaterials();
	CoursMaterial addCoursMaterial (CoursMaterial coursMaterial);
	CoursMaterial updateCoursMaterial (CoursMaterial coursMaterial);
	void deleteCoursMaterial(long id);
	CoursMaterial findCoursMaterialById(long id);

}
