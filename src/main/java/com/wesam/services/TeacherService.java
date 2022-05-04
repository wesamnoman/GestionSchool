package com.wesam.services;

import java.util.List;

import com.wesam.entities.Teacher;

public interface TeacherService {
	
	List<Teacher> getAllTeachers();
	Teacher addTeacher (Teacher teacher);
	void deleteTeacher(long id);
	Teacher updateTeacher(Teacher teacher);
	Teacher findTeacherById(long id);

}
