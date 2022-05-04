package com.wesam.servicesImp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesam.entities.Cours;
import com.wesam.entities.Teacher;
import com.wesam.repositories.TeacherRepository;
import com.wesam.services.CoursService;
import com.wesam.services.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	CoursService coursService;

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll() ;
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
		Teacher newTeacher = new Teacher();
		newTeacher.setTeacherName(teacher.getTeacherName());
		newTeacher.setGender(teacher.getGender());
		newTeacher.setAddress(teacher.getAddress());
		newTeacher.setCours(teacher.getCours().stream()
				.map(c->{
					Cours cours =c;
					if(cours.getCoursId()>0) {
						cours =coursService.findCoursById(cours.getCoursId());
					}
					cours.addTeacher(newTeacher);
					return cours;
				}).collect(Collectors.toList()));
				
		return teacherRepository.save(newTeacher);
	}

	@Override
	public void deleteTeacher(long id) {
		teacherRepository.deleteById(id);
		
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher getTeacher = findTeacherById(teacher.getTeacherId());
		if (getTeacher!=null) {
			getTeacher.setAddress(teacher.getAddress());
			getTeacher.setCours(teacher.getCours());
			getTeacher.setGender(teacher.getGender());
			getTeacher.setTeacherName(teacher.getTeacherName());
			teacherRepository.save(getTeacher);
		}
		return getTeacher;
	}

	@Override
	public Teacher findTeacherById(long id) {
		return teacherRepository.findById(id).get();
	}

}
