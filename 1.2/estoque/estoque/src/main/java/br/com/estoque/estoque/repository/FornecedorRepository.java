package br.com.estoque.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoque.model.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {
    public List<Fornecedor> findByidFornecedor(Long idFornecedor);
}