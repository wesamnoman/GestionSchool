package com.wesam.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesam.entities.CoursMaterial;
import com.wesam.repositories.CoursMaterialRepository;
import com.wesam.services.CoursMaterialService;

@Service
public class CoursMaterialServiceImp implements CoursMaterialService{
     @Autowired
     CoursMaterialRepository coursMaterialRepository;
     
	@Override
	public List<CoursMaterial> getAllMaterials() {
		
		return coursMaterialRepository.findAll();
	}

	@Override
	public CoursMaterial addCoursMaterial(CoursMaterial coursMaterial) {
		// TODO Auto-generated method stub
		return coursMaterialRepository.save(coursMaterial);
	}

	@Override
	public CoursMaterial updateCoursMaterial(CoursMaterial coursMaterial) {
		CoursMaterial crMaterial = findCoursMaterialById(coursMaterial.getCoursMaterialId());
		crMaterial.setCoursMaterialUrl(coursMaterial.getCoursMaterialUrl());
		crMaterial.setCours(coursMaterial.getCours());
		return crMaterial;
	}

	@Override
	public void deleteCoursMaterial(long id) {
       coursMaterialRepository.deleteById(id);
		
	}

	@Override
	public CoursMaterial findCoursMaterialById(long id) {
		
		return coursMaterialRepository.findById(id).get();
	}

}
