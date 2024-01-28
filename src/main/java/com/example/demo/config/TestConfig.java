package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Categoria;
import com.example.demo.entities.Pedido;
import com.example.demo.entities.Pessoa;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.PessoaRepository;
import com.example.demo.repositories.ProdutoRepository;

import enums.StatusPedido;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//INSTANCIANDO PESSOAS
		Pessoa pessoa1 = new Pessoa(null,"Renan", 37);
		Pessoa pessoa2 = new Pessoa(null,"Cristina",57);
		
		pessoaRepository.saveAll(Arrays.asList(pessoa1,pessoa2));
		
		//INSTANCIANDO PRODUTOS
		Produto prod1 = new Produto(null,"Batedeira","Batedeira boa!","http://fotofoto",130.00);
		Produto prod2 = new Produto(null,"Computador","Computador brabo","https://pcbom",5000.00);
		
		produtoRepository.saveAll(Arrays.asList(prod1,prod2));
		
		//INSTANCIANDO CATEGORIAS
		Categoria cat1 = new Categoria(null,"Brinquedos");
		Categoria cat2 = new Categoria(null, "Eletronicos");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		//INSTANCIANDO PEDIDOS
		Pedido pedido1 = new Pedido(null,Instant.parse("1986-12-05T23:35:07Z"),StatusPedido.PAGO, pessoa1);
		Pedido pedido2 = new Pedido(null, Instant.parse("1966-03-03T12:56:10Z"),StatusPedido.ENVIADO, pessoa2);
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		
		//ASSOCIANDO CATEGORIAS COM PRODUTOS
		prod1.getCategoria().add(cat2);
		prod1.getCategoria().add(cat1);
		prod2.getCategoria().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(prod1,prod2));
		
		
		
	}
}
