package br.com.acbueno.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.acbueno.crud.data.vo.ProdutoVO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Produto implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 706636631063438353L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;
  
  @Column(name = "nome", nullable = false , length = 255)
  @Getter
  @Setter
  private String nome;
  
  @Column(name = "estoque", nullable = false, length = 10)
  @Getter
  @Setter
  private int estoque;
  
  @Column(name = "preco", nullable = false, length = 10)
  @Getter
  @Setter
  private Double preco;
  
  public static Produto create(ProdutoVO produtoVO) {
    return new ModelMapper().map(produtoVO, Produto.class);
  }

}
