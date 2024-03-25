package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.DTO.PessoaRequestDto;
import com.example.demo.DTO.PessoaResponseDto;
import com.example.demo.entities.Pessoa;
import com.example.demo.mapper.PessoaMapper;
import com.example.demo.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<PessoaResponseDto>> findAll() {
		List<Pessoa> list = pessoaService.findAll();
		List<PessoaResponseDto> pessoaResponseDtos = PessoaMapper.toPessoaResponseList(list);
		return ResponseEntity.ok().body(pessoaResponseDtos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaResponseDto> findById(@PathVariable Long id) {
		Optional<Pessoa> pessoa = Optional.ofNullable(pessoaService.findById(id));
		if (pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(PessoaMapper.toPessoaResponse(pessoa.get()));
	}

	@PostMapping
	public ResponseEntity<PessoaResponseDto> insert(@RequestBody PessoaRequestDto pessoaRequestDto) {
		Pessoa pessoa = PessoaMapper.toPessoa(pessoaRequestDto);
		Pessoa pessoaSalva = pessoaService.insert(pessoa);
		PessoaResponseDto pessoaResponseDto = PessoaMapper.toPessoaResponse(pessoaSalva);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaResponseDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaResponseDto> update(@PathVariable Long id, @RequestBody PessoaRequestDto pessoaRequestDto) {
		Pessoa pessoa = PessoaMapper.toPessoa(pessoaRequestDto);
		Pessoa pessoaSave = pessoaService.update(id, pessoa);
		PessoaResponseDto pessoaResponseDto = PessoaMapper.toPessoaResponse(pessoaSave);
		return ResponseEntity.ok().body(pessoaResponseDto);
	}
}
