package br.com.acbueno.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundeException extends RuntimeException {

  private static final long serialVersionUID = -8039746486697203099L;
  
  public ResourceNotFoundeException(String excpetion) {
    super(excpetion);
  }
  

}
