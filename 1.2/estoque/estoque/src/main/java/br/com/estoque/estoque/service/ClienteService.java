package br.com.estoque.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque.estoque.model.Cliente;
import br.com.estoque.estoque.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Long idCliente) {
        repository.deleteById(idCliente);
    }

    public Optional<Cliente> findOne(Long idCliente) {
        return repository.findById(idCliente);
    }
}
