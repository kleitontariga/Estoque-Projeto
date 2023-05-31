package br.com.estoque.estoque.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    private Long idproduto;
    @Column(length = 30, nullable = false,unique = true)
    private String nome;
    @Column(length = 30, nullable = false,unique = false)
    private Short quantidade;
    @Column(nullable = false,unique = false)
    private String fornecedor;
    @Column(length = 30, nullable = false,unique = false)
    private Date datavalidade;
    @Column( nullable = false,unique = false)
    
    public Long getIdproduto() {
        return idproduto;
    }
    public void setIdproduto(Long idproduto) {
        this.idproduto = idproduto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Short getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Date getDatavalidade() {
        return datavalidade;
    }
    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }
    
}
