package com._e552516.checkpoint5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com._e552516.checkpoint5.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}