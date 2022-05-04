package com.wesam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesam.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
