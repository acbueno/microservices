package br.com.acbueno.crud.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import br.com.acbueno.crud.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id", "nome", "estoque", "preco"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {
  
  private static final long serialVersionUID = -8724950758173364739L;
  
  @Getter
  @Setter
  @JsonProperty("id")
  private Long id;
  @Getter
  @Setter
  @JsonProperty("nome")
  private String nome;
  
  @Getter
  @Setter
  @JsonProperty("estoque")
  private int estoque;
  @Getter
  @Setter
  @JsonProperty("preco")
  private Double preco;
  
  public static ProdutoVO create(Produto produto) {
    return new ModelMapper().map(produto, ProdutoVO.class);
  }

}
