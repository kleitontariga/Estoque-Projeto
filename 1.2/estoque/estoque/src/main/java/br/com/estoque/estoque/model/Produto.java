package br.com.estoque.estoque.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @Column(length = 30, nullable = false, unique = true)
    private Long barras;
    
    
    private String nome;
    
    @Column(nullable = false, unique = false)
    private Short quantidade;
    
    @Column(nullable = false, unique = false)
    private Date datavalidade;
    
    @Column(nullable = false, unique = false)
    private String fornecedorId;

    public String getFornecedorId() {
        return fornecedorId;
    }
    
    public void setFornecedorId(String fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedorEntity;

    private String estoqueId;

    public String getEstoqueId() {
        return estoqueId;
    }
    
    public void setEstoqueId(String estoqueId) {
        this.estoqueId = estoqueId;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoqueEntity;
    
    private String encomendaId;
    
    public String getEncomendaId() {
        return encomendaId;
    }
    
    public void setEncomendaId(String encomendaId) {
        this.encomendaId = encomendaId;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_encomenda")
    private Encomenda encomendaEntity;

    public Long getBarras() {
        return barras;
    }
    
    public void setBarras(Long barras) {
        this.barras = barras;
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

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }
}
