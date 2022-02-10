package com.example.BODerivativesDummy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.BODerivativesDummy.Exceptions.DateInvalidException;
import com.example.BODerivativesDummy.Exceptions.EventRuleDeleteException;
import com.example.BODerivativesDummy.Exceptions.QuantityOrPriceException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = DateInvalidException.class)
	public ResponseEntity<Object> eventRuleDateException(DateInvalidException dateInvalid) {
		return new ResponseEntity<>("Charge start date cannot be greater then charge end date", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = QuantityOrPriceException.class)
	public ResponseEntity<Object> qtyOrPriceException(QuantityOrPriceException quantityOrPriceException) {
		return new ResponseEntity<>("Invalid quantity or price", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EventRuleDeleteException.class)
	public ResponseEntity<Object> eventRuleDeleteException(EventRuleDeleteException eventRuleDeleteException) {
		return new ResponseEntity<>("Event Rule is in Use , kindly delete the charges first" , HttpStatus.NOT_FOUND);
	}
}
