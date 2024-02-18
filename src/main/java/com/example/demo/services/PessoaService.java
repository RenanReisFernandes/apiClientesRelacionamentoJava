package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pessoa;
import com.example.demo.repositories.PessoaRepository;
import com.example.demo.resources.exceptions.DatabaseException;
import com.example.demo.services.exceptions.RecursoNaoEncontradoException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	//findAll
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	//findById
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(()-> new RecursoNaoEncontradoException(id));
	}
	//save
	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	//delete
	public void delete(Long id) {
		try {
			pessoaRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	//update
	public Pessoa update(Long id, Pessoa pessoa) {
		try {
			Pessoa entidade = pessoaRepository.getReferenceById(id);
			updateDados(entidade, pessoa);
			return pessoaRepository.save(entidade);
		}catch(EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException(id);
		}
	}
	
	public void updateDados(Pessoa entidade, Pessoa pessoa) {
		entidade.setNome(pessoa.getNome());
		entidade.setIdade(pessoa.getIdade());
	}

}
