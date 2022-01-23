package com.bridgelabz.employeepayrollapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Long> {

	public Optional<EmployeePayrollData> findByEmailId(String email_id);

//	@Query(value = "SELECT emp_id FROM employee_payroll WHERE email_id= :emailId AND password= :password", nativeQuery = true)
//	public long getUserDetails(String emailId, String password);

//	public List<EmployeePayrollData> findEmployeesByDepartment(String department);
	
//	@Query(value = "SELECT COUNT(emp_id) FROM employee_payroll WHERE email_id= :emailId AND password= :password", nativeQuery = true)
//	public long validation(String emailId, String password);

}
