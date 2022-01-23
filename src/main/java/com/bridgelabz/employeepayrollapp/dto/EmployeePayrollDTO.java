package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data

public @ToString class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$", message = "Employee name Invalid")
	@NotEmpty(message = "Employee name can not be null")
	private String name;

	@Min(value = 500, message = "minimun wage should be 500")
	private long salary;

	@Pattern(regexp = "male|female", message = "Gender needs to either male or female")
	private String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "startDate should not be null")
	@PastOrPresent(message = "start date should be Past or Today's date")
	private LocalDate startDate;

	@NotEmpty(message = "note can not be null")
	private String note;

	@NotEmpty(message = "profilePic can not be null")
	private String profilePic;

	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	@NotEmpty(message = "emailId can not be null")
	private String emailId;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z0-9#$@%&*\\$]{5,}$", message = "password is Invalid")
	@NotEmpty(message = "password can not be null")
	private String password;

	@NotEmpty(message = "departments should not be null")
	private List<String> departments;

}
