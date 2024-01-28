package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant data;
	private StatusPedido statusPedido;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa cliente;
	
	
	public Pedido() {}
	public Pedido(Long id, Instant data, StatusPedido statusPedido, Pessoa cliente) {
		this.id=id;
		this.data=data;
		this.statusPedido=statusPedido;
		this.cliente=cliente;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	
	public Instant getData() {
		return data;
	}
	public void setData(Instant data) {
		this.data=data;
	}
	
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido=statusPedido;
	}
	
	public Pessoa getPessoa() {
		return cliente;
	}
	public void setPessoa(Pessoa pessoa) {
		this.cliente = pessoa;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", pessoa=" + cliente + "]";
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
