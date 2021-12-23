package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollapp.model.EmployeeDetails;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<EmployeeDetails, Long> {

}
