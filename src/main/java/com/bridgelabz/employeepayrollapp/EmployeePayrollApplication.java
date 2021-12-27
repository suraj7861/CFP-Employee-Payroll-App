package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
=======

>>>>>>> 5982d5f0003f07fb7dd7601dfdb6170792ee136b

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

	public static void main(String[] args) {
		System.out.println("Welcome To Employee Payroll Application");
		ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("Employee Payroll App Started in {} Environment",context.getEnvironment().getProperty("environment"));
<<<<<<< HEAD
=======
		
		
>>>>>>> 5982d5f0003f07fb7dd7601dfdb6170792ee136b
	}

}
