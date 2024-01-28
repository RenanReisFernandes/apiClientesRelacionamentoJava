package com.example.demo.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String imagemUrl;
	private Double preco;
	
	@ManyToAny
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name="produto_id")
	, inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();
	
	public Produto() {}
	public Produto(Long id, String nome, String descricao, String imagemUrl, Double preco) {
		this.id=id;
		this.nome=nome;
		this.descricao=descricao;
		this.imagemUrl=imagemUrl;
		this.preco=preco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}
	
	public String getImagemUrl() {
		return imagemUrl;
	}
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl=imagemUrl;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco=preco;
	}
	
	public Set<Categoria> getCategoria(){
		return categorias;
	}
	

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", imagemUrl=" + imagemUrl
				+ ", preco=" + preco + ", categorias=" + categorias + "]";
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
