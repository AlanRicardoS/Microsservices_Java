package com.alan.pagamento.entity;

import com.alan.pagamento.data.vo.ProdutoVendaVO;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProdutoVenda implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 10)
  private Long idProduto;

  @Column(nullable = false, length = 10)
  private Integer quantidade;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_venda")
  private Venda venda;
  public static ProdutoVenda create(ProdutoVendaVO produtoVendaVO){
    return new ModelMapper().map(produtoVendaVO, ProdutoVenda.class);
  }
}
