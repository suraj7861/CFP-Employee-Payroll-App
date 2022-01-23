package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.LoginDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public interface IEmployeePayrollService {

	/**
	 * Method: get employee details
	 */
	public List<EmployeePayrollData> getEmployeePayrollData(String token);

	/**
	 * Method: get employee detail by id
	 */
	public EmployeePayrollData getEmployeePayrollDataById(long empId, String token);

	/**
	 * Method: add employee details
	 */
	public ResponseDTO createEmployeePayrollData(@Valid EmployeePayrollDTO empPayrollDTO);

	/**
	 * Method: update employee details
	 */
	public ResponseDTO updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO, String token,long empID);

	/**
	 * Method: delete employee details
	 */
	public ResponseDTO deleteEmployeePayrollData(String token);

	/**
	 * Method: get employee details by department
	 */
	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department, String token);

	public ResponseDTO loginValidation(LoginDTO loginDTO);


	
}
