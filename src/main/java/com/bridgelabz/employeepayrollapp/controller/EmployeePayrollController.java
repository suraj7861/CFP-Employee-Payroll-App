package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
	
	/**
	 * @return : return string and HttpStatus
	 */
	@RequestMapping(value = { "/getAll"})
	public ResponseEntity<String> getEmployeePayrollData(){
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	/**
	 * @GetMapping : get Employee details from table
	 * @param : empId
	 * @return : return employee id 
	 */
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId){
		return new ResponseEntity<String>("Get Call Success for Id: "+ empId, HttpStatus.OK);
	}
	
	/**
	 * @PostMapping : add Employee details in the table
	 * @param EmployeeDetails
	 * @return : Added employee details
	 */
	@PostMapping("/create")
	public ResponseEntity<String> getEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Created Employee Payroll Data for: "+ empPayrollDTO, HttpStatus.OK);
	}
	
	/**
	 * @PutMapping : edit details in the table
	 * @param EmployeeDetails
	 * @return : return employee details
	 */

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Updated Employee Payroll Data for: "+ empPayrollDTO, HttpStatus.OK);
	}
	
	/**
	 * @DeleteMapping : delete Employee details from table
	 * @param empId
	 * @return : return deleted Employee 
	 */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		return new ResponseEntity<String>("Delete call success for id: "+ empId, HttpStatus.OK);
	}
	
}


