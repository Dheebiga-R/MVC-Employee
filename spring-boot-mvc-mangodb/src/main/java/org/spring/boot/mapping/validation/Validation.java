package org.spring.boot.mapping.validation;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//validation Handler
@ControllerAdvice
public class Validation extends RuntimeException{
	
	@ExceptionHandler(UserIdNotfoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String UserIdNotvalidexception(UserIdNotfoundException ex,Model model){
	    model.addAttribute("errormess",ex.getMessage());
		return "error";
	}

}

