package com.temelt.issuemanagement.advice;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {
	private Date date;
	private String message;
}
