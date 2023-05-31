package br.com.estoque.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque.estoque.model.Produto;
import br.com.estoque.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public void delete(Long barras) {
        repository.deleteById(barras);
    }

    public Optional<Produto> findOne(Long barras) {
        return repository.findById(barras);
    }
}
