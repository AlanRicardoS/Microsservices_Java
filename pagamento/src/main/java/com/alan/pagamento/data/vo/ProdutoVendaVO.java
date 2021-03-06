package com.alan.pagamento.data.vo;

import com.alan.pagamento.entity.ProdutoVenda;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"id", "idProduto", "quantidade"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> implements Serializable {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("idProduto")
  private Long idProduto;

  @JsonProperty("quantidade")
  private Integer quantidade;

  public static ProdutoVendaVO create(ProdutoVenda prodoVenda){
    return new ModelMapper().map(prodoVenda, ProdutoVendaVO.class);
  }
}
