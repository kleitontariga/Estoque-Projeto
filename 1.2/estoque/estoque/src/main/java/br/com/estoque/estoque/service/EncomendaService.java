package br.com.estoque.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque.estoque.model.Encomenda;
import br.com.estoque.estoque.repository.EncomendaRepository;

@Service
public class EncomendaService {
    @Autowired
    private EncomendaRepository repository;

    public List<Encomenda> findAll(){
        return repository.findAll();
    }

    public Encomenda save(Encomenda encomenda) {
        return repository.save(encomenda);
    }

    public void delete(Long idEncomenda) {
        repository.deleteById(idEncomenda);
    }

    public Optional<Encomenda> findOne(Long idEncomenda) {
        return repository.findById(idEncomenda);
    }
}
