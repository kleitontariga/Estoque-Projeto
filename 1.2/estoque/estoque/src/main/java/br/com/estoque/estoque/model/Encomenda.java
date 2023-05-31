package br.com.estoque.estoque.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "encomendas")
public class Encomenda {
    @Id
    private long idEncomenda;
    
    @Column(length = 30, nullable = false, unique = true)
    private Date data;
    
    @Column(nullable = false, unique = false)
    private short quantidade;
    
    @OneToMany(mappedBy = "encomendaEntity")
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;

    public long getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(long idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
