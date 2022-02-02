package com.example.BODerivativesDummy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.BODerivativesDummy.Exceptions.DateInvalidException;

@ControllerAdvice
public class DateExceptionController {

	@ExceptionHandler
	public ResponseEntity<Object> dateException(DateInvalidException dateInvalid) {
		return new ResponseEntity<>("Invalid Dates",HttpStatus.NOT_FOUND);
		
	}
}
