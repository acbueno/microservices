package br.com.acbueno.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

  private static final long serialVersionUID = 3588877350481691847L;

  public ResourceNotFoundException(String message) {
    super(message);
  }

}
