package com.janequiz.quizeducacional.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice

public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("error","Parâmetro inválido");
		errorResponse.put("message","O valor '" + ex.getValue() + "' não é válido para o parâmetro '" + ex.getName() + "' . ");
		errorResponse.put("path", ex.getParameter().getExecutable().toString());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		
		
		
	}

}
