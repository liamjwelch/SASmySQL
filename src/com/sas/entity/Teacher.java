/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "teacher_sas")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
    private int teacherID;
	
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
	
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=160000, message="must be less than or equal to 160,000")
	@Column(name = "salary")
    private int salary;
    
    //full constructor
    public Teacher (int teacherID, String firstName, String lastName, String address, String city, String country, String phoneNumber, int salary){
        this.teacherID = teacherID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.salary = salary;        
    }
    
    //to print all students 
    public Teacher (String firstName, String lastName, String address, String city, String country, String phoneNumber, int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.salary = salary;        
    }
    
    //to test
    public Teacher (String firstName, String lastName, String address, String city, String country, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }    
    
    
    //find student based on ID
    public Teacher(int teacherID) {
        this.teacherID = teacherID;
    }
    
    //constructor with no arguments
    public Teacher() {
        
    }    
    
    //getters and setters

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    
    
}
