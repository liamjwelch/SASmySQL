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

import com.sas.entity.Course;
import com.sas.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	// need to inject courseService
	@Autowired
	private CourseService courseService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// functions

	// adds a list of students to the Model
	@GetMapping("/list")
	public String listCourses(Model theModel) {

		// get Courses from the Service
		List<Course> courses = courseService.getCourses();

		// add students to the model
		theModel.addAttribute("courses", courses);

		// return the form

		return "list-courses";

	}

	@PostMapping("/save")
	public String saveCourse(@Valid @ModelAttribute("course") Course theCourse, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "course-form";
		} else {
			// save the student using service

			courseService.saveCourse(theCourse);

			// reloads original page with updated value
			return "redirect:/course/list";

		}
	}
	// delegates off to deleteCustomer

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("courseID") int courseID) {

		// delete the student using the service

		courseService.deleteCourse(courseID);

		// reloads the original page with updated value

		return "redirect:/course/list";

	}

	@PostMapping("/search")
	public String searchStudents(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search students from the service
		List<Course> theCourses = courseService.searchCourses(theSearchName);

		// add the students to model
		theModel.addAttribute("courses", theCourses);

		// reload the page
		return "list-courses";

	}

	// Shows forms

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseID") int courseID, Model theModel) {

		// get the student from the service

		Course theCourse = courseService.getCourse(courseID);

		// set the student as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);

		// send over to our form
		return "course-form";

	}

	// displays the form for adding students
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form to data from Student
		Course theCourse = new Course();

		theModel.addAttribute("course", theCourse);

		return "course-form";

	}
}
