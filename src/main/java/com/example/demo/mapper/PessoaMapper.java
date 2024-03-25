package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

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
		pessoaRequestDto.setNome(pessoa.getNome());
		pessoaRequestDto.setIdade(pessoa.getIdade());
		return pessoaRequestDto;
	}
	
	public static List<PessoaResponseDto> toPessoaResponseList(List<Pessoa> pessoas){
		List<PessoaResponseDto> responses = new ArrayList<>();
		for(Pessoa pessoa: pessoas) {
			responses.add(toPessoaResponse(pessoa));
		}
		return responses;
	}
}
