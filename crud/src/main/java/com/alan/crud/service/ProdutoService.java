package com.alan.crud.service;

import com.alan.crud.data.vo.ProdutoVO;
import com.alan.crud.entity.Produto;
import com.alan.crud.exception.ResourceNotFoundException;
import com.alan.crud.message.ProdutoSendoMessage;
import com.alan.crud.repository.ProdutoReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

  private final ProdutoReposiotry produtoReposiotry;
  private final ProdutoSendoMessage produtoSendoMessage;
  @Autowired
  public ProdutoService(ProdutoReposiotry produtoReposiotry, ProdutoSendoMessage produtoSendoMessage) {
    super();
    this.produtoReposiotry = produtoReposiotry;
    this.produtoSendoMessage = produtoSendoMessage;
  }

  public ProdutoVO create(ProdutoVO produtoVO) {
    ProdutoVO produtoVORetorno =
        ProdutoVO.create(produtoReposiotry.save(Produto.create(produtoVO)));
    produtoSendoMessage.sendMessage(produtoVO);
    return produtoVORetorno;
  }

  public Page<ProdutoVO> findAll(Pageable pageable) {
    var page = produtoReposiotry.findAll(pageable);
    return page.map(this::convertoToProdutoVO);
  }

  @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
  private ProdutoVO convertoToProdutoVO(Produto produto) {
    return ProdutoVO.create(produto);
  }

  public ProdutoVO findById(Long id) {
    var entity =
        produtoReposiotry
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    return ProdutoVO.create(entity);
  }

  public ProdutoVO update(ProdutoVO produtoVO) {
    final Optional<Produto> optionalProduto = produtoReposiotry.findById(produtoVO.getId());

    if (!optionalProduto.isPresent()) {
      new ResourceNotFoundException("No records found for this ID");
    }
    return ProdutoVO.create(produtoReposiotry.save(Produto.create(produtoVO)));
  }

  public void delete(Long id) {
    var entity =
        produtoReposiotry
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    produtoReposiotry.delete(entity);
  }
}
