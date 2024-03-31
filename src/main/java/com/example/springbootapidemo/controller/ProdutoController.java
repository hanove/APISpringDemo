package com.example.springbootapidemo.controller;

import com.example.springbootapidemo.entities.Produto;
import com.example.springbootapidemo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto addProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoToUpdate = produtoRepository.findById(id).orElse(null);
        if (produtoToUpdate != null) {
            produtoToUpdate.setNome(produto.getNome());
            produtoToUpdate.setPreco(produto.getPreco());
            produtoToUpdate.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(produtoToUpdate);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
