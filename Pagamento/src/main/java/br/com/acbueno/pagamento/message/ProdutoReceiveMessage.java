package br.com.acbueno.pagamento.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component; 
import br.com.acbueno.pagamento.data.vo.ProdutoVO;
import br.com.acbueno.pagamento.entity.Produto;
import br.com.acbueno.pagamento.repository.ProdutoRepository;

@Component
public class ProdutoReceiveMessage {

  private final ProdutoRepository produtoRepository;

  @Autowired
  public ProdutoReceiveMessage(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  } 

  @RabbitListener(queues = {"${crud.rabbitmq.queue}"})
  public void recevie(@Payload ProdutoVO produtoVO) {
    produtoRepository.save(Produto.create(produtoVO));
  }

}
