package com.wesam.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cours {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private long coursId;
private String coursName;
//@JsonManagedReference
@JsonIgnore
@ManyToMany(mappedBy = "cours", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
private List<Teacher> teacher;
//@JsonManagedReference
@ManyToMany(mappedBy = "cours", fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
@JsonIgnore
private List<Student> student;
@JsonManagedReference
@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
private List<CoursMaterial>coursMaterial;

public void addTeacher(Teacher t) {
    this.teacher.add(t);  
}
public void addStudent(Student s) {
    this.student.add(s);  
}

}
