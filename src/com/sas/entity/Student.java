package com.sas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student_sas")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentID;

	
	
	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "address")
	private String address;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "city")
	private String city;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "country")
	private String country;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotNull(message="is required")
	@Size(min=1, max=25)
	@Column(name = "major")
	private String major;
	
//	//ManyToOne
	
	//name of the variable in the table you are joining it to
	
	@OneToMany(mappedBy = "student")
	private Set<Result> results;

	// constructors
	public Student(int studentID, String firstName, String lastName, String address, String city, String country,
			String phoneNumber, String major) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.major = major;
	}

	public Student(String firstName, String lastName, String address, String city, String country, String phoneNumber,
			String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.major = major;
	}

	public Student(int studentID) {
		this.studentID = studentID;
	}

	public Student() {

	}

	/// getters setters
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
//
//	public Set<Result> getResults() {
//		return results;
//	}
//
//	public void setResults(Set<Result> results) {
//		this.results = results;
//	}

	

}