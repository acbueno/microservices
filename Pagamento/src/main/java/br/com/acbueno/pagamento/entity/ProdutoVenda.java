package br.com.acbueno.pagamento.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.modelmapper.ModelMapper;

import br.com.acbueno.pagamento.data.vo.ProdutoVO;
import br.com.acbueno.pagamento.data.vo.ProdutoVendaVO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto_venda")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProdutoVenda implements Serializable {
  
  private static final long serialVersionUID = 3112254847071383266L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "id_produto", nullable = false, length = 10)
  private Long idProduto;
  
  @Column(name = "quantidade", nullable = false, length = 10)
  private Integer quantidade;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_venda")
  private Venda venda;
  
  public static ProdutoVenda create(ProdutoVendaVO produtoVendaVO) {
    return new ModelMapper().map(produtoVendaVO, ProdutoVenda.class);
  }

}
