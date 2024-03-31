package com.example.springbootapidemo.repository;

import com.example.springbootapidemo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
