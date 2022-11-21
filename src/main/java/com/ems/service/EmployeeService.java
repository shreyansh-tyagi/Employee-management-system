package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
		
	}

	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmployeeById(int id) {
		repo.deleteById(id);
	}
}
