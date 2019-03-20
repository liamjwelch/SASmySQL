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
import com.sas.entity.Result;
import com.sas.entity.Student;
import com.sas.service.CourseService;
import com.sas.service.ResultService;
import com.sas.service.StudentService;

@Controller
@RequestMapping("/result")
public class ResultController {

	@Autowired
	private ResultService resultService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// functions

	// add a list of results to the model

	@GetMapping("/list")
	public String listResults(Model theModel) {

		// get the results from the service

		List<Result> theResults = resultService.getResults();

		// add results to the model

		theModel.addAttribute("results", theResults);

		// return jsp

		return "list-results";

	}

	// delegates off to SaveResult
	@PostMapping("/save")
	public String saveResult(@Valid @ModelAttribute("result") Result theResult, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "result-form";
		} else {
			// save the result using service

			resultService.saveResult(theResult);

			// reloads original page with updated value
			return "redirect:/result/list";

		}

	}

	// delegates off to deleteCustomer

	@GetMapping("/delete")
	public String deleteResult(@RequestParam("resultID") int resultID) {

		// delete the student using the service

		resultService.deleteResult(resultID);

		// reloads the original page with updated value

		return "redirect:/result/list";

	}

	// Shows forms

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("resultID") int resultID, Model theModel) {

		// get the student from the service

		Result theResult = resultService.getResult(resultID);
//		Course course = courseService.getCourse(courseID);
//		Student student = studentService.getStudent(studentID);

		// set the student as a model attribute to pre-populate the form
		theModel.addAttribute("result", theResult);
//		theModel.addAttribute("courseID", course);
//		theModel.addAttribute("studentID", student);

		// send over to our form
		return "result-form-add";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create a list from which to receive course/student details
		Result theResult = new Result();
		List<Result> theResults = resultService.getResults();

		theModel.addAttribute("courseList", this.courseService.getCourses());
		theModel.addAttribute("studentList", this.studentService.getStudents());
		theModel.addAttribute("result", theResult);
		theModel.addAttribute("results", theResults);

		return "result-form";

	}

}
