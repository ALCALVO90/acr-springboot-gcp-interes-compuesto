package com.example.appengine.springboot.entities;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.appengine.springboot.models.InteresCompuestoConstructorModel;

@ControllerAdvice
public class InteresCompuestoExceptionHandlerEntity extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String errorMessage = "The parameters need to be numeric";
		return handleExceptionInternal(ex, InteresCompuestoConstructorModel.getResultFromError(errorMessage), headers,
				status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, InteresCompuestoConstructorModel.getResultFromError(ex.getMessage()),
				headers, status, request);
	}

}
