package br.com.estoque.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoque.model.Estoque;


@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
    public List<Estoque> findByidEstoque(Long idEstoque);
}