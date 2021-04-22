package com.demo.config.validation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;


@RestControllerAdvice
public class ErrorHandler  {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDto> handle(MethodArgumentNotValidException exception) {
		List<ErrorDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorDto erro = new ErrorDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
	
	 @ExceptionHandler(FeignException.class)
	    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
	        response.setStatus(e.status());
	        return "feignError";
	 }
	 
	 @ExceptionHandler(DataIntegrityViolationException.class)
	 public String handleConstraintException(DataIntegrityViolationException e, HttpServletResponse
			 response) {
		 response.setStatus(400);
	     return "User with this data already exists";
	 }
}
