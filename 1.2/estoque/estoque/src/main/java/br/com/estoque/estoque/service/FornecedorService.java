package br.com.estoque.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque.estoque.model.Fornecedor;
import br.com.estoque.estoque.repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> findAll(){
        return repository.findAll();
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void delete(Long idFornecedor) {
        repository.deleteById(idFornecedor);
    }

    public Optional<Fornecedor> findOne(Long idFornecedor) {
        return repository.findById(idFornecedor);
    }
}
