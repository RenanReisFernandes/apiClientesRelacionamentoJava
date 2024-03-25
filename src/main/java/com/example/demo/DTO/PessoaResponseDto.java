package com.example.demo.DTO;

import java.util.Objects;

public class PessoaResponseDto {

	private String nome;
	private Integer idade;
	public PessoaResponseDto() {
		super();
	}
	public PessoaResponseDto(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
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
		return Objects.hash(idade, nome);
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
		return Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "PessoaResponseDto [nome=" + nome + ", idade=" + idade + "]";
	}
	
	
}
