package br.com.acbueno.crud.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.acbueno.crud.data.vo.ProdutoVO;
import br.com.acbueno.crud.entity.Produto;
import br.com.acbueno.crud.exception.ResourceNotFoundeException;
import br.com.acbueno.crud.message.ProdutoSendMessage;
import br.com.acbueno.crud.repository.ProdutoRepository;

@Service
public class ProdutoServices {

  private final ProdutoRepository produtoRepository;

  private final ProdutoSendMessage produtoSendMessage;

  @Autowired
  public ProdutoServices(ProdutoRepository produtoRepository, ProdutoSendMessage produtoSendMessage) {
    this.produtoRepository = produtoRepository;
    this.produtoSendMessage = produtoSendMessage;
  }

  public ProdutoVO create(ProdutoVO produtoVO) {
    ProdutoVO value = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
    produtoSendMessage.sendMessage(value);
    
    return value;
  }

  public Page<ProdutoVO> findAll(Pageable pageable) {
    var page = produtoRepository.findAll(pageable);
    return page.map(this::convertToProductVO);

  }

  private ProdutoVO convertToProductVO(Produto produto) {
    return ProdutoVO.create(produto);
  }

  public ProdutoVO findById(Long id) {
    var entity = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundeException("Regitro não encontado pelo id"));
    return ProdutoVO.create(entity);
  }

  public ProdutoVO update(ProdutoVO produtoVO) {

    final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());

    if (!optionalProduto.isPresent()) {
      new ResourceNotFoundeException("Registro não encontrado");
    }
    return ProdutoVO
        .create(produtoRepository.save(Produto.create(ProdutoVO.create(optionalProduto.get()))));
  }

  public void delete(Long id) {
    var entity = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundeException("Registro não encontrado"));

    produtoRepository.delete(entity);
  }



}
