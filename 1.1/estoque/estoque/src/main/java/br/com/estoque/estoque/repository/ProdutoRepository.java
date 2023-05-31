package br.com.estoque.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estoque.estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    public List<Produto> findByIDProdutos(Long name);
}
