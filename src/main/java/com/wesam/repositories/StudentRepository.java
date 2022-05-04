package com.wesam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesam.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
