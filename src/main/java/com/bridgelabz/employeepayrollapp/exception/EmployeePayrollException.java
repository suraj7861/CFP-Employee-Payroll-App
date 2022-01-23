package com.bridgelabz.employeepayrollapp.exception;

import org.springframework.http.HttpStatus;

/**
 * custom Exception
 */
public class EmployeePayrollException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	private String statusmessage;

	public EmployeePayrollException(String message) {
		super(message);

	}

	public EmployeePayrollException(HttpStatus httpStatus, String statusmessage) {
		super(statusmessage);
		this.httpStatus = httpStatus;
		this.statusmessage = statusmessage;
	}
}
