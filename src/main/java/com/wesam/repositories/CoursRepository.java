package com.wesam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesam.entities.Cours;
@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

}
