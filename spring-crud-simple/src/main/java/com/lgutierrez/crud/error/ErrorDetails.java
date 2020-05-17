package com.lgutierrez.crud.error;

import java.util.Date;

public class ErrorDetails {

	private String errorCode;
	private Date timestamp;
	private String message;
	private String details;
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String errorCode, Date timestamp, String message, String details) {
		super();
		this.errorCode = errorCode;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	
}
