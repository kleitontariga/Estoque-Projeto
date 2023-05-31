package br.com.estoque.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque.estoque.model.Estoque;
import br.com.estoque.estoque.repository.EstoqueRepository;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository repository;

    public List<Estoque> findAll(){
        return repository.findAll();
    }

    public Estoque save(Estoque estoque) {
        return repository.save(estoque);
    }

    public void delete(Long idEstoque) {
        repository.deleteById(idEstoque);
    }

    public Optional<Estoque> findOne(Long idEstoque) {
        return repository.findById(idEstoque);
    }
}
