package com.alan.pagamento.entity;

import com.alan.pagamento.data.vo.ProdutoVO;
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
public class Produto implements Serializable {

  @Id
  private Long id;

  @Column(nullable = false)
  private Integer estoque;

  public static Produto create(ProdutoVO produtoVO) {
    return new ModelMapper().map(produtoVO, Produto.class);
  }
}
