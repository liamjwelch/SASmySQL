package com.sas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sas.entity.Student;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	// adds a list of students to the Model
	@GetMapping("/welcome")
	public String welcomeHome(Model theModel) {


		return "mainMenu";
	}

}
