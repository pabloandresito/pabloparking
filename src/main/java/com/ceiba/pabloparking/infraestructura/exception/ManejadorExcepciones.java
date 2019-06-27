package com.ceiba.pabloparking.infraestructura.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorObligatorio;

@ControllerAdvice
public class ManejadorExcepciones extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleConflictRuntimeException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
	
	@ExceptionHandler(value = { ExcepcionDuplicidad.class })
    protected ResponseEntity<String> handleConflictExcepcionDuplicidad(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(ex.getMessage());
    }
	
	@ExceptionHandler(value = { ExcepcionSinDatos.class })
    protected ResponseEntity<String> handleConflictExcepcionSinDatos(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
	
	@ExceptionHandler(value = { ExcepcionValorInvalido.class })
    protected ResponseEntity<String> handleConflictExcepcionValorInvalido(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
	
	@ExceptionHandler(value = { ExcepcionValorObligatorio.class })
    protected ResponseEntity<String> handleConflictExcepcionValorObligatorio(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
