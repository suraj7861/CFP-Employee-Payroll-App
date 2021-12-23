package com.bridgelabz.employeepayrollapp.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.model.EmployeeDetails;
@Service
public interface EmployeeServiceImpl {
	/**
	 * Method :   get Employee details from table
	 */
	public EmployeeDetails getEmpDetails(Long empId);
	
	/**
	 * Method :  add Employee details in the table
	 */
	public EmployeeDetails addEmpDetails(EmployeeDetails employee);
	
	/**
	 * Method :  edit details in the table
	 */
	public EmployeeDetails editEmpDetails(EmployeeDetails employee);
	
	/**
	 * Method :   delete Employee details from table
	 */
	public EmployeeDetails deleteEmp(Long empId);

}
