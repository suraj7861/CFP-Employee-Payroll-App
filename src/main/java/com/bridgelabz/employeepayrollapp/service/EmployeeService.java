package com.bridgelabz.employeepayrollapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.model.EmployeeDetails;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;

@Service
public class EmployeeService implements EmployeeServiceImpl{
	@Autowired
	private IEmployeePayrollRepository iemployeeRepository;
	

	/**
	 * get Employee details from table
	 * @param : empId
	 * @return : employeeService
	 */
	@Override
	public EmployeeDetails getEmpDetails(Long empId) {
		return iemployeeRepository.findById(empId).get();
	}
	
	/**
	 * add Employee details in the table
	 * @param EmployeeDetails
	 * @return : employeeService 
	 */
	@Override
	public EmployeeDetails addEmpDetails(EmployeeDetails employee) {
		return iemployeeRepository.save(employee);
	}
	
	/**
	 * edit details in the table
	 * @param EmployeeDetails
	 * @return : employeeService
	 */
	@Override
	public EmployeeDetails editEmpDetails(EmployeeDetails employee) {
		return iemployeeRepository.save(employee);
	}
	
	/**
	 * delete Employee details from table
	 * @param empId
	 * @return : employeeService
	 */
	@Override
	public EmployeeDetails deleteEmp(Long empId) {
		Optional<EmployeeDetails> isPresent = iemployeeRepository.findById(empId);
		if(isPresent.isPresent()) {
			iemployeeRepository.delete(isPresent.get());
			return isPresent.get();
		}
		
		return null;
	}
	
}
