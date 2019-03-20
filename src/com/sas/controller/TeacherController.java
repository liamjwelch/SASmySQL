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

import com.sas.entity.Teacher;
import com.sas.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	// need to inject TeacherService
	@Autowired
	private TeacherService teacherService;

	
	// InitBinder... to convert trim input strngs
	// remove leading and trailing whitespace
	
	@InitBinder
	public void initBinder (WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	
	// create + update

	// delegates off to SaveTeacher
	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute("teacher") Teacher theTeacher, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "teacher-form";
		} else {

			// save the teacher using service

			teacherService.saveTeacher(theTeacher);

			// reloads original page with updated value
			return "redirect:/teacher/list";

		}
	}

	// delegates off to deleteCustomer

	@PostMapping("/search")
	public String searchTeachers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search teachers from the service
		List<Teacher> theTeachers = teacherService.searchTeachers(theSearchName);

		// add the teachers to model
		theModel.addAttribute("teachers", theTeachers);

		// reload the page
		return "list-teachers";

	}

	// adds a list of teachers to the Model
	@GetMapping("/list")
	public String listTeachers(Model theModel) {

		// get teachers from Service
		List<Teacher> theTeachers = teacherService.getTeachers();

		// add teachers to the model
		theModel.addAttribute("teachers", theTeachers);

		return "list-teachers";
	}

	// delete
	@GetMapping("/delete")
	public String deleteTeacher(@RequestParam("teacherID") int teacherID) {

		// delete the teacher using the service

		teacherService.deleteTeacher(teacherID);

		// reloads the original page with updated value

		return "redirect:/teacher/list";

	}

	// Shows forms

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("teacherID") int teacherID, Model theModel) {

		// get the teacher from the service

		Teacher theTeacher = teacherService.getTeacher(teacherID);

		// set the student as a model attribute to pre-populate the form
		theModel.addAttribute("teacher", theTeacher);

		// send over to our form
		return "teacher-form";

	}

	// displays the form for adding students
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form to data from Student
		Teacher theTeacher = new Teacher();

		theModel.addAttribute("teacher", theTeacher);

		return "teacher-form";

	}
}
