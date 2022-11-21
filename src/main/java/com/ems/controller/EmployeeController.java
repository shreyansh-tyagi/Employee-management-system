package com.ems.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/home")
	public String home(Model m) {
		List<Employee> emp = service.getAllEmployee();
		m.addAttribute("emp", emp);
		return "EmployeeIndex";
	}

	@GetMapping("/addemp")
	public String addEmp() {
		return "AddEmployee";
	}

	@PostMapping("/insertEmployeeData")
	public String empInsertData(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added successfully..");
		return "redirect:/home";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, Model m) {

		Employee e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "Add";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Details updated successfully..");
		return "redirect:/home";
	}

	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session) {
		service.deleteEmployeeById(id);
		session.setAttribute("msg", "Employee Deleted successfully..");
		return "redirect:/home";
	}

}
