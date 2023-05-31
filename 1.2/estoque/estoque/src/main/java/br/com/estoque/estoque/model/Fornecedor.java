package br.com.estoque.estoque.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    private long idFornecedor;
    
    @Column(length = 30, nullable = false, unique = true)
    private String nome;
    
    @Column(length = 20, nullable = false, unique = false)
    private String endereco;
    
    @Column(length = 30, nullable = false, unique = true)
    private String telefone;
    
    @Column(nullable = false, unique = false)
    private String cnpj;
    
    @OneToMany(mappedBy = "fornecedorEntity")
    private List<Produto> produto;
    
    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
