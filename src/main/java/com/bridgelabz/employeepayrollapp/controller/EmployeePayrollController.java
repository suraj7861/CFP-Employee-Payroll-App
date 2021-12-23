package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.EmployeeDetails;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * @GetMapping : get Employee details from table
	 * @param : empId
	 * @return : employeeService
	 */
	@GetMapping("/details/{empId}")
	public EmployeeDetails getEmployees(@PathVariable String empId) {
		return employeeService.getEmpDetails(Long.parseLong(empId));
	}
	
	/**
	 * @PostMapping : add Employee details in the table
	 * @param EmployeeDetails
	 * @return : employeeService 
	 */
	@PostMapping("/postDetails")
	public EmployeeDetails addEmployees(@RequestBody EmployeeDetails employeeDetails) {
		return employeeService.addEmpDetails(employeeDetails);
	}
	
	/**
	 * @PutMapping : edit details in the table
	 * @param EmployeeDetails
	 * @return : employeeService
	 */
	@PutMapping("/edit")
	public EmployeeDetails editEmployees(@RequestBody EmployeeDetails employeeDetails) {
		return employeeService.editEmpDetails(employeeDetails);
	}
	
	/**
	 * @DeleteMapping : delete Employee details from table
	 * @param empId
	 * @return : employeeService
	 */
	@DeleteMapping("/details/{empId}")
	public EmployeeDetails deleteEmployee(@PathVariable String empId) {
		return this.employeeService.deleteEmp(Long.parseLong(empId));
	}
	
}


