package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/home")
	public String home() {
		return "EmployeeIndex";
	}

	@GetMapping("/addemp")
	public String addEmp() {
		return "AddEmployee";
	}
	
	@PostMapping("/insertEmployeeData")
	public String empInsertData(@ModelAttribute Employee e) {
		System.out.println(e);
		service.addEmp(e);
		return "redirect:/";
	}
}
