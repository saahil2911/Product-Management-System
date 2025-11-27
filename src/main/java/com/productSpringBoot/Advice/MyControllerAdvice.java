package com.productSpringBoot.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productSpringBoot.Exception.DataAlreadyExistsException;
import com.productSpringBoot.Exception.NoDataFoundException;
import com.productSpringBoot.Exception.NoNullDataException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<String> handlenoData(NoDataFoundException n){
		return new ResponseEntity<String>( n.getErrorCode() + " No Data Is Present, Please Insert Some Data ",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataAlreadyExistsException.class)
	public ResponseEntity<String> handleNullData(DataAlreadyExistsException d){
		return new ResponseEntity<String>(d.getErrorCode() + " ID Already Exists, Please Enter New Data!!!! ",HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NoNullDataException.class)
	public ResponseEntity<String> handleNullField(NoNullDataException nf){
		return new ResponseEntity<String>(nf.getErrorCode() +" Field Cannot be Null, Please Enter Valid Inputs!! ",HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
