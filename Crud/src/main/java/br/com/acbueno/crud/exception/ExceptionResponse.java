package br.com.acbueno.crud.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

  private static final long serialVersionUID = 3645930336835855260L;
  
  private Date date;
  
  private String message;
  
  private String datails;

}
