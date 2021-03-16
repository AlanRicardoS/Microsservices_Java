package com.alan.crud.message;

import com.alan.crud.data.vo.ProdutoVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProdutoSendoMessage {

  public final RabbitTemplate rabbitTemplate;

  @Value("${crud.rabbitmq.exchange}")
  String exchange;

  @Value("${crud.rabbitmq.routingkey}")
  String routingkey;

  @Autowired
  public ProdutoSendoMessage(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(ProdutoVO produtoVO) {
    rabbitTemplate.convertAndSend(exchange, routingkey, produtoVO);
  }
}
