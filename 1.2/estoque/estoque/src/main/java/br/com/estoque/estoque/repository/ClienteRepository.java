package br.com.estoque.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoque.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    public List<Cliente> findByidCliente(Long idCliente);
}