package br.com.acbueno.crud.message;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import br.com.acbueno.crud.data.vo.ProdutoVO;

@Component
public class ProdutoSendMessage {
  
  
  private final static Logger LOOGER = Logger.getLogger(ProdutoSendMessage.class);
 
  @Value("${crud.rabbitmq.exchange}")
  String exchange;
  
  @Value("${crud.rabbitmq.routingkey}")
  String routingkey;
  
  public final RabbitTemplate rabbitTemplate;

  @Autowired
  public ProdutoSendMessage(RabbitTemplate rabbitTemplate) {
      LOOGER.info("Value config exchange: " + exchange);
      this.rabbitTemplate = rabbitTemplate;
  }
  
  public void sendMessage(ProdutoVO produtoVO) {
      rabbitTemplate.convertAndSend(exchange,routingkey,produtoVO);
  }
  
}
