package com.conferencedemo.controller;

import java.util.List;

import com.conferencedemo.dao.EmployeeDAO;
import com.conferencedemo.model.Employee;
import com.conferencedemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to RestTemplate Demo.";
	}

	// URL - http://localhost:8080/listEmployees
	@RequestMapping(value = "listEmployees", method = RequestMethod.GET) // or use @GetMapping
	public java.util.List<Employee> listEmployees() {
		return employeeService.findAll();
	}

	@RequestMapping(value = "insertEMP" , method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee emp){
		return employeeDAO.addEmployee(emp);
	}

	@RequestMapping(value = "updateEMP", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Employee updateEmployee(@RequestBody Employee emp){
		return employeeDAO.updateEmployee(emp);
	}
	
	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	 public void deleteEmployee(@PathVariable("empNo") String empNo) {
	 	employeeDAO.deleteEmployee(empNo); 
	}
}