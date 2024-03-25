package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.PessoaRequestDto;
import com.example.demo.DTO.PessoaResponseDto;
import com.example.demo.entities.Pessoa;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PessoaMapper {
	
	private final ModelMapper mapper = new ModelMapper();
	
	public Pessoa toPessoa(PessoaRequestDto pessoaRequestDto) {
		return mapper.map(pessoaRequestDto, Pessoa.class);
	}
	
	public PessoaResponseDto toPessoaResponseDto(Pessoa pessoa) {
		return mapper.map(pessoa, PessoaResponseDto.class);
	}
	
	public List<PessoaResponseDto> toPessoaResponseDtos(List<Pessoa> pessoas){
		return pessoas.stream()
				.map(this::toPessoaResponseDto)
				.collect(Collectors.toList());
	}
	
/*	
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
	
	*/
}
