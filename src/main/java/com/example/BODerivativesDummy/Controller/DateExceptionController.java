package com.example.BODerivativesDummy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.BODerivativesDummy.Exceptions.DateInvalidException;

@ControllerAdvice
public class DateExceptionController {

	@ExceptionHandler
	public ResponseEntity<Object> eventRuleDateException(DateInvalidException dateInvalid) {
		return new ResponseEntity<>("Charge start date cannot be greater then charge end date",HttpStatus.NOT_FOUND);
		
	}
}
