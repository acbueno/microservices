package br.com.acbueno.auth.data;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserVO implements Serializable {

  private static final long serialVersionUID = 4341957099071132859L;

  private String userName;
  private String password;

}
