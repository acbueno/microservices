package br.com.acbueno.pagamento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.acbueno.pagamento.data.vo.VendaVO;
import br.com.acbueno.pagamento.entity.ProdutoVenda;
import br.com.acbueno.pagamento.entity.Venda;
import br.com.acbueno.pagamento.exception.ResourceNotFoundException;
import br.com.acbueno.pagamento.repository.ProdutoVendaRepository;
import br.com.acbueno.pagamento.repository.VendaRepository;

@Service
public class VendaService {

  private VendaRepository vendaRepository;

  private ProdutoVendaRepository produtoVendaRepository;

  @Autowired
  public VendaService(VendaRepository vendaRepository,
      ProdutoVendaRepository produtoVendaRepository) {
    this.vendaRepository = vendaRepository;
    this.produtoVendaRepository = produtoVendaRepository;
  }


  public VendaVO create(VendaVO vendaVO) {
    Venda venda = vendaRepository.save(Venda.create(vendaVO));

    List<ProdutoVenda> produtosSalvos = new ArrayList<>();
    vendaVO.getProdutos().forEach(p -> {
      ProdutoVenda pv = ProdutoVenda.create(p);
      pv.setVenda(venda);
      produtosSalvos.add(produtoVendaRepository.save(pv));
    });
    venda.setProdutos(produtosSalvos);

    return VendaVO.create(venda);
  }



  public Page<VendaVO> findAll(Pageable pageable) {
    var page = vendaRepository.findAll(pageable);
    return page.map(this::convertToVendaVO);
  }

  private VendaVO convertToVendaVO(Venda venda) {
    return VendaVO.create(venda);
  }

  public VendaVO findById(Long id) {
    var entity = vendaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Não existem registro com esse ID"));
    return VendaVO.create(entity);
  }



}
