package br.com.estoque.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoque.model.Encomenda;


@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda,Long> {
    public List<Encomenda> findByidEncomenda(Long idEncomenda);
}