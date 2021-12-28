package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	/**
	 * Method: get employee details
	 */
	public List<EmployeePayrollData> getEmployeePayrollData();

	/**
	 * Method: get employee detail by id
	 */
	public EmployeePayrollData getEmployeePayrollDataById(int empId);

	/**
	 * Method: add employee details
	 */
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	/**
	 * Method: update employee details
	 */
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

	/**
	 * Method: delete employee details
	 */
	public void deleteEmployeePayrollData(int empId);

	/**
	 * Method: get employee details by department
	 */
	List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);
}
