package com.rest.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
    private String message;
    private String details;
	public ErrorDetails(Date date, String message, String description) {
		super();
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDetails(String details) {
		this.details = details;
	}
    
    

}
