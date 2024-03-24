package com.example.demo.DTO;

import java.util.Objects;

public class PessoaResponseDto {

	private Long id;
	private String nome;
	private Integer idade;
	public PessoaResponseDto() {
		super();
	}
	public PessoaResponseDto(Long id, String nome, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
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
		PessoaResponseDto other = (PessoaResponseDto) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "PessoaResponseDto [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	
}
