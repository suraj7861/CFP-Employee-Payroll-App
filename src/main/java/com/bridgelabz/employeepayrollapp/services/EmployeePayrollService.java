package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.LoginDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository employeeRepository;

	@Autowired
	TokenUtil tokenUtil;

	@Autowired
	ModelMapper modelmapper1;

	@Override
	public ResponseDTO loginValidation(LoginDTO loginDTO) {
		String token;
		Optional<EmployeePayrollData> isPresent = employeeRepository.findByEmailId(loginDTO.getEmailId());
		if (isPresent.isPresent()) {
			String pass = isPresent.get().getPassword();
			if (pass.equals(loginDTO.getPassword())) {
				// long empId = employeeRepository.getUserDetails(loginDTO.getEmailId(),
				// loginDTO.getPassword());
				token = tokenUtil.createToken(isPresent.get().getEmployeeId());
				return new ResponseDTO("Employee is found", token, HttpStatus.OK);
			} else {
				throw new EmployeePayrollException(HttpStatus.BAD_REQUEST, "Password is Wrong");
			}
		} else {
			throw new EmployeePayrollException(HttpStatus.BAD_REQUEST, "Email ID or password is wrong");
		}
	}

	/**
	 * post employee details
	 * 
	 * @return : Employee details with id
	 */
	@Override
	public ResponseDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		Optional<EmployeePayrollData> isPresent = employeeRepository.findByEmailId(empPayrollDTO.getEmailId());
		if (isPresent.isPresent()) {
			throw new EmployeePayrollException(HttpStatus.BAD_REQUEST, "employee details Already Added");
		} else {

			EmployeePayrollData contact = modelmapper1.map(empPayrollDTO, EmployeePayrollData.class);
			employeeRepository.save(contact);
			String token1 = tokenUtil.createToken(contact.getEmployeeId());
			return new ResponseDTO("Contact Succefully Added", token1, HttpStatus.OK);
		}
	}

	/**
	 * get employee details
	 * 
	 * @return : Employee details
	 */
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData(String token) {

		Long id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = employeeRepository.findById(id);
		if (isEmployeePresent.isPresent()) {
			List<EmployeePayrollData> getallemployees = employeeRepository.findAll();
			return getallemployees;
		} else {
			throw new EmployeePayrollException(HttpStatus.BAD_REQUEST, "Token is not valid!!");
		}
	}

	/**
	 * get employee details
	 * 
	 * @return : Employee detail using id
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(long empId, String token) {
		Long id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = employeeRepository.findById(id);
		if (isEmployeePresent.isPresent()) {
			return employeeRepository.findById(empId)
					.orElseThrow(() -> new EmployeePayrollException("employee ID Not Found"));
		} else
			throw new EmployeePayrollException("Not Valid Token");
	}

	/**
	 * update employee details
	 * 
	 * @return : updated Employee details
	 */
	@Override
	public ResponseDTO updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO, String token, long empID) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empID, token);
		Long id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = employeeRepository.findById(id);
		if (isEmployeePresent.isPresent()) {
			empData.updateEmployeePayroll(empPayrollDTO);
			employeeRepository.save(isEmployeePresent.get());
			return new ResponseDTO("Contact Succefully Updated", empData, HttpStatus.ACCEPTED);
		} else {
			throw new EmployeePayrollException(HttpStatus.BAD_REQUEST, "Token is not valid!!");
		}

	}

	/**
	 * Call delete method
	 */
	@Override
	public ResponseDTO deleteEmployeePayrollData(String token) {
		Long id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = employeeRepository.findById(id);
		if (isEmployeePresent.isPresent()) {
			employeeRepository.delete(isEmployeePresent.get());
		}
		return new ResponseDTO("Deleted Successful,Deleted Id:", id, HttpStatus.ACCEPTED);

	}

	@Override
	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department, String token) {
//		Long id = tokenUtil.decodeToken(token);
//		Optional<EmployeePayrollData> isEmployeePresent = employeeRepository.findById(id);
//		if (isEmployeePresent.isPresent()) {
//			return employeeRepository.findEmployeesByDepartment(department);
//		} else
//			throw new EmployeePayrollException("Not Valid Token");
		return null;
	}

}
