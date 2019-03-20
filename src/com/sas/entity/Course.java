/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author liamj
 */
@Entity
@Table(name = "course_sas")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int courseID;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "course_name")
	private String courseName;

	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=8, message="must be less than or equal to 8")
	@Column(name = "credit")
	private int credit;
	
	
	//  ManyToOne
	
	@OneToMany (mappedBy = "course")
	private Set<Result> results;

	public Course() {

	}

	public Course(int courseID, String courseName, int credit) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
	}

	public Course(String courseName, int credit) {
		this.courseName = courseName;
		this.credit = credit;
	}

	public Course(int courseID) {
		this.courseID = courseID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

//	public Set<Result> getResults() {
//		return results;
//	}
//
//	public void setResults(Set<Result> results) {
//		this.results = results;
//	}

	
}
