package com.alan.pagamento.entity;

import com.alan.pagamento.data.vo.VendaVO;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Venda  implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @DateTimeFormat(pattern = "MM/dd/yyyy")
  @Column(nullable = false)
  private Date data;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.REFRESH)
  private List<ProdutoVenda> produtos;

  @Column(nullable = false, length = 10)
  private Double valorTotal;

  public static Venda create(VendaVO vendaVO){
    return new ModelMapper().map(vendaVO, Venda.class);
  }
}
