package com.alan.crud.entity;

import com.alan.crud.data.vo.ProdutoVO;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String nome;
    @Column(nullable = false)
    private Integer estoque;
    @Column(nullable = false)
    private Double preco;

    public static Produto create(ProdutoVO produtoVO){
        return new ModelMapper().map(produtoVO, Produto.class);
    }
}
