package br.com.estoque.estoque.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    private long idEstoque;
    
    @Column(length = 30, nullable = false, unique = true)
    private Short quantidade;
    
    @OneToMany(mappedBy = "estoqueEntity")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "estoque")
    private List<Fornecedor> fornecedores;

    @OneToMany(mappedBy = "estoque")
    private List<Encomenda> encomendas;

    public long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
}
