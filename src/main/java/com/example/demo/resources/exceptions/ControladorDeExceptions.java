package com.example.demo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.exceptions.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControladorDeExceptions {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<StandardError> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
		String error = "Recurso não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
