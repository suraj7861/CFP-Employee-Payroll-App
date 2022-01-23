package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.LoginDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping("/employee")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Slf4j

public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> loginDataValidation(@RequestBody LoginDTO loginDTO) {
		ResponseDTO response = employeePayrollService.loginValidation(loginDTO);
		log.debug("User Login input details: " + loginDTO.toString());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	/**
	 * @PostMapping : add Employee details in DB and generate token
	 * @param EmployeePayrollDTO
	 * @return : Added employee details and token
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
		ResponseDTO respDTO = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @return : employee details
	 */
	@RequestMapping(value = { "/getAll" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@RequestHeader String token) {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData(token);
		ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList, HttpStatus.ACCEPTED);
		log.debug("get all employee details: " + respDTO.toString());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @GetMapping : get Employee details from table
	 * @param : empId
	 * @return : return employee details using id
	 */
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") long empId,
			@RequestHeader String token) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId, token);
		ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful:", employeePayrollData, HttpStatus.ACCEPTED);
		log.debug("get employee details by id: " + respDTO.toString());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @PutMapping : edit details in the table
	 * @param EmployeePayrollDTO
	 * @return : return employee details
	 */

	@PutMapping("/update/{empID}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO,
			@RequestHeader String token, @PathVariable long empID) {
		ResponseDTO respDTO = employeePayrollService.updateEmployeePayrollData(empPayrollDTO, token, empID);
		log.debug("update employee details: " + respDTO.toString());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	/**
	 * @DeleteMapping : delete Employee details from table
	 * @param empId
	 * @return : return deleted Employee
	 */
	@DeleteMapping("/deleteEmployee{empID}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@RequestHeader String token) {
		ResponseDTO respDTO = employeePayrollService.deleteEmployeePayrollData(token);
		log.debug("delete employee details: " + respDTO.toString());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @param department
	 * @return : emp datails by departments and httpStatus
	 */
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department,
			@RequestHeader String token) {

		List<EmployeePayrollData> employeeList = null;
		employeeList = employeePayrollService.getEmployeesPayrollDataByDepartment(department, token);
		ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

}
