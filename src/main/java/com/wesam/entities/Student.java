package com.wesam.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	private String studentName;
	private LocalDate date;
	private Gender gender;
	@Embedded
	private Address address;
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (
			name="StudentCours",		
			joinColumns ={@JoinColumn(name="student_id")} ,
			inverseJoinColumns = {@JoinColumn(name="cours_id")})
	private List<Cours> cours;

}
