package com.alan.crud.repository;

import com.alan.crud.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoReposiotry extends JpaRepository<Produto, Long> {
}
