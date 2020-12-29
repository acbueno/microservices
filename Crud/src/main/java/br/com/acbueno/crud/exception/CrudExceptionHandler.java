package br.com.acbueno.crud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CrudExceptionHandler extends ResponseEntityExceptionHandler {
  
  public final ResponseEntity<ExceptionResponse> handlerBadRequestsException(Exception ex, WebRequest request){
    ExceptionResponse expExceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    
    return new ResponseEntity<ExceptionResponse>(expExceptionResponse, HttpStatus.BAD_REQUEST);
  }

}
