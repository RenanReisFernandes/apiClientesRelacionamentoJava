package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entities.Pessoa;
import com.example.demo.repositories.PessoaRepository;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {
	// ARRANGE --- ARRUMAR
	//ACT  ---- CHAMA CADA PEDAÇO QUE SERÁ TESTADO
	//ASSERT  ---- VERIFICA SE DEU TUDO CERTO
	
	@Mock
	private PessoaRepository pessoaRepository;
	
	@InjectMocks
	private PessoaService pessoaService;
	
	@Nested
	class insert{
		
		@Test
		@DisplayName("Deve criar pessoa com sucesso")
		void deveCriarPessoa() {
			//ARRANGE
			var input = new Pessoa(1L, "nome",22);
			
			//ACT
			var output = pessoaService.insert(input);
			
			//ASSERT
			assertNotNull(output);
			
		}
		
		@Test
		@DisplayName("Deve lançar excessão quando ocorrer erro")
		void deveLancarExcessaoQuandoOcorrerErro() {
			
			//ARRANGE
			doThrow(new RuntimeException()).when(pessoaRepository.save(any()));
			var input = new Pessoa(1L, "nome",22);
			
			//ACT
			var output = pessoaService.insert(input);
			
			//ASSERT
			assertNotNull(output);
		}
	}

}
