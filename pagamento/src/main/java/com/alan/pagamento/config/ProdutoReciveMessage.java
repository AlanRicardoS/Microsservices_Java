package com.alan.pagamento.config;

import com.alan.pagamento.data.vo.ProdutoVO;
import com.alan.pagamento.entity.Produto;
import com.alan.pagamento.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoReciveMessage {

  private final ProdutoRepository produtoRepository;

  @Autowired
  public ProdutoReciveMessage(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  @RabbitListener(queues = {"${crud.rabbitmq.queue}"})
  public void revice(@Payload ProdutoVO produtoVO) {
    produtoRepository.save(Produto.create(produtoVO));
  }
}
