package br.com.acbueno.pagamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.acbueno.pagamento.data.vo.ProdutoVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

  private static final long serialVersionUID = 7598512427152650949L;

  @Id
  private Long id;

  @Column(name = "estoque", nullable = false, length = 10)
  private Integer estoque;

  public static Produto create(ProdutoVO produtoVO) {
    return new ModelMapper().map(produtoVO, Produto.class);
  }

}
