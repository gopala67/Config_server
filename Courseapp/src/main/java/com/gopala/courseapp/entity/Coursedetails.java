package com.gopala.courseapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "course_details")
public class Coursedetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "employeeid")
	private Long employeeid;
	@Column(name = "coursename")
	private String coursename;
	@Column(name = "skillset")
	private String skillset;
	@Column(name = "experience")
	private int experience;

}
