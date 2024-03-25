package com.example.demo.mapper;

import com.example.demo.DTO.PessoaRequestDto;
import com.example.demo.DTO.PessoaResponseDto;
import com.example.demo.entities.Pessoa;

public class PessoaMapper {
	
	public static Pessoa toPessoa(PessoaRequestDto pessoaRequestDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(pessoaRequestDto.getIdade());
		pessoa.setNome(pessoaRequestDto.getNome());
		return pessoa;
	}

	public static PessoaResponseDto toPessoaResponse(Pessoa pessoa) {
		PessoaResponseDto pessoaRequestDto = new PessoaResponseDto();
		pessoaRequestDto.setIdade(pessoa.getIdade());
		pessoaRequestDto.setNome(pessoa.getNome());
		return pessoaRequestDto;
	}
}
