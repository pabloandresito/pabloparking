package com.ceiba.pabloparking.infraestructura.controller.dto;

public class ResponseApi {
	
	private String message;

	public ResponseApi(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
