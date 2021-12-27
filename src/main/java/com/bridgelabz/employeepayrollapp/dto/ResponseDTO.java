package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

/**
 * @Data : Auto Generate Setters, Getters and ToString 
 */
public @Data class ResponseDTO {

	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}


}
