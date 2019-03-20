package com.sas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sas.entity.Student;
import com.sas.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	// need to inject StudentService
	@Autowired
	private StudentService studentService;

	// InitBinder... to convert trim input strngs
	// remove leading and trailing whitespace
	
	@InitBinder
	public void initBinder (WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	
	// functions

	// adds a list of students to the Model
	@GetMapping("/list")
	public String listStudents(Model theModel) {

		// get Students from Service
		List<Student> theStudents = studentService.getStudents();

		// add students to the model
		theModel.addAttribute("students", theStudents);

		return "list-students";
	}

	// delegates off to SaveCustomer
	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "student-form";
		} else {
			// save the student using service

			studentService.saveStudent(theStudent);

			// reloads original page with updated value
			return "redirect:/student/list";

		}
	}

	// delegates off to deleteCustomer

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentID") int studentID) {

		// delete the student using the service

		studentService.deleteStudent(studentID);

		// reloads the original page with updated value

		return "redirect:/student/list";

	}

	@PostMapping("/search")
	public String searchStudents(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search students from the service
		List<Student> theStudents = studentService.searchStudents(theSearchName);

		// add the students to model
		theModel.addAttribute("students", theStudents);

		// reload the page
		return "list-students";

	}

	// Shows forms

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentID") int studentID, Model theModel) {

		// get the student from the service

		Student theStudent = studentService.getStudent(studentID);

		// set the student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);

		// send over to our form
		return "student-form";

	}

	// displays the form for adding students
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form to data from Student
		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "student-form";

	}
}
