package br.ufsc.cursofs.AulaSpringBoot.controllers.exceptions;

import java.time.Instant;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<String> emptyResultDataAccessException(EmptyResultDataAccessException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationException(
			DataIntegrityViolationException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value = ObjectNaoEncontradoException.class)
	public ResponseEntity<StandardError> objectNaoEncontrado(ObjectNaoEncontradoException e, 
			HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND; 
		String path = request.getRequestURI();
		
		StandardError st = new StandardError(Instant.now(), status.value(), e.getMessage(), path);
		
		return ResponseEntity.status(status).body(st);
	}
	
}
