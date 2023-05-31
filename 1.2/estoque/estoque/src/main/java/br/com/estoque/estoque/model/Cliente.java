package br.com.estoque.estoque.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private long idCliente;
    
    @Column(length = 30, nullable = false, unique = true)
    private String nome;
    
    @Column(length = 20, nullable = false, unique = false)
    private String endereco;
    
    @Column(length = 20, nullable = false, unique = true)
    private String telefone;
    
    @OneToMany(mappedBy = "cliente")
    private List<Encomenda> encomendas;
    
    public long getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public List<Encomenda> getEncomendas() {
        return encomendas;
    }
    
    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
}
