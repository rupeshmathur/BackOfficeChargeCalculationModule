package com.example.BODerivativesDummy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.BODerivativesDummy.Exceptions.QuantityOrPriceException;

@ControllerAdvice
public class TradeQtyOrPriceException {

	@ExceptionHandler
	public ResponseEntity<Object> qtyOrPriceException(QuantityOrPriceException quantityOrPriceException){
		return new ResponseEntity<>("Invalid quantity or price",HttpStatus.NOT_FOUND);
	}
}
