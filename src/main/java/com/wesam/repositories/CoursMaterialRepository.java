package com.wesam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesam.entities.CoursMaterial;

@Repository
public interface CoursMaterialRepository extends JpaRepository<CoursMaterial, Long> {

}
