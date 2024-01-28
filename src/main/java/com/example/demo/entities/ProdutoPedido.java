package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.example.demo.entities.pk.ProdutoPedidoPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto_pedido")
public class ProdutoPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdutoPedidoPk id;
	
	private Integer quantidade;
	private Double preco;
	
	public ProdutoPedido() {}
	public ProdutoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade=quantidade;
		this.preco=preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	public void setPedido(Pedido pedido) {
		this.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produto produto) {
		this.setProduto(produto);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade=quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco=preco;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoPedido other = (ProdutoPedido) obj;
		return Objects.equals(id, other.id);
	}

	
}