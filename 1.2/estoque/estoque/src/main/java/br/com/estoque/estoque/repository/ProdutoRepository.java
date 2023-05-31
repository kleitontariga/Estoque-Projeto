package br.com.estoque.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoque.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    public List<Produto> findByBarras(Long barras);
}