package com.institute.exceptions;

	import java.time.LocalDateTime;
	import java.util.Arrays;
	import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.TypeMismatchException;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.HttpMediaTypeNotSupportedException;
	import org.springframework.web.HttpRequestMethodNotSupportedException;
	import org.springframework.web.bind.MissingPathVariableException;
	import org.springframework.web.bind.MissingServletRequestParameterException;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.context.request.WebRequest;
	import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

	@ControllerAdvice
	public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

		@Override
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			String message=ex.getMessage();
			LocalDateTime timestamp=LocalDateTime.now();
			List<String> details=Arrays.asList("Wrong method name","Not supported");
			ApiErrors errorrs=new ApiErrors(message,timestamp,status,details);
			return ResponseEntity.status(status).body(errorrs);
		}

		@Override
		protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			String message=ex.getMessage();
			LocalDateTime timestamp=LocalDateTime.now();
			List<String> details=Arrays.asList("Wrong media type ","Irrelevant");
			ApiErrors errorrs=new ApiErrors(message,timestamp,status,details);
			return ResponseEntity.status(status).body(errorrs);
		}

		@Override
		protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
				HttpStatus status, WebRequest request) {
			String message=ex.getMessage();
			LocalDateTime timestamp=LocalDateTime.now();
			List<String> details=Arrays.asList("Missing Path Variable","Not supported");
			ApiErrors errorrs=new ApiErrors(message,timestamp,status,details);
			return ResponseEntity.status(status).body(errorrs);
		}

		@Override
		protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			String message=ex.getMessage();
			LocalDateTime timestamp=LocalDateTime.now();
			List<String> details=Arrays.asList("No Request param","missing param");
			ApiErrors errorrs=new ApiErrors(message,timestamp,status,details);
			return ResponseEntity.status(status).body(errorrs);
		}

		@Override
		protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
				HttpStatus status, WebRequest request) {
			String message=ex.getMessage();
			LocalDateTime timestamp=LocalDateTime.now();
			List<String> details=Arrays.asList("Type Mismatch","wrong type");
			ApiErrors errorrs=new ApiErrors(message,timestamp,status,details);
			return ResponseEntity.status(status).body(errorrs);
		}
	@ExceptionHandler(InstanceNotFoundException.class)
		protected ResponseEntity<Object> handleBookException(InstituteNotFoundException ex)
		{
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList("Institute is not available");
		ApiErrors errorrs=new ApiErrors(message,timestamp,HttpStatus.BAD_REQUEST,details);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorrs);
		}
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleOtherException(Exception ex)
	{
	String message=ex.getMessage();
	LocalDateTime timestamp=LocalDateTime.now();
	List<String> details=Arrays.asList("Institute is not available");
	ApiErrors errorrs=new ApiErrors(message,timestamp,HttpStatus.INTERNAL_SERVER_ERROR,details);
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorrs);
	}
	}

