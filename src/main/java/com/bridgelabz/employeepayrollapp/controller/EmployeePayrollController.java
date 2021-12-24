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
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

	/**
	 * @return : employee details
	 */
	@RequestMapping(value = { "/getAll" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Suraj", 25000));
		ResponseDTO respDTO = new ResponseDTO("Get call Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @GetMapping : get Employee details from table
	 * @param : empId
	 * @return : return employee details using id
	 */
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Kishor", 28000));
		ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @PostMapping : add Employee details in the table
	 * @param EmployeePayrollDTO
	 * @return : Added employee details
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(3, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Employee PayrollData:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @PutMapping : edit details in the table
	 * @param EmployeePayrollDTO
	 * @return : return employee details
	 */

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			                          @RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Update Employee PayrollData Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	/**
	 * @DeleteMapping : delete Employee details from table
	 * @param empId
	 * @return : return deleted Employee
	 */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Successful,Deleted Id:", +empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
