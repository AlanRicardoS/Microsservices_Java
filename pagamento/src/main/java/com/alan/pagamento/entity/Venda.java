package com.alan.pagamento.entity;

import lombok.*;

import javax.persistence.Entity;
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

    private Long id;
    private Date data;

    private List<ProdutoVenda> produtos;

    private Double valorTotal;
}
