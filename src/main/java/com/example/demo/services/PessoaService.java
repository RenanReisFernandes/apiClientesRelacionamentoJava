package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pessoa;
import com.example.demo.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.get();
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public Pessoa update(Long id, Pessoa pessoa) {
		Pessoa entidade = pessoaRepository.getReferenceById(id);
		updateDados(entidade, pessoa);
		return pessoaRepository.save(entidade);
	}
	
	public void updateDados(Pessoa entidade, Pessoa pessoa) {
		entidade.setNome(pessoa.getNome());
		entidade.setIdade(pessoa.getIdade());
	}

}
