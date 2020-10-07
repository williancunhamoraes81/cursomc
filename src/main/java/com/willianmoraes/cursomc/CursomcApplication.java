package com.willianmoraes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.willianmoraes.cursomc.domain.Categoria;
import com.willianmoraes.cursomc.domain.Cidade;
import com.willianmoraes.cursomc.domain.Cliente;
import com.willianmoraes.cursomc.domain.Endereco;
import com.willianmoraes.cursomc.domain.Estado;
import com.willianmoraes.cursomc.domain.Produto;
import com.willianmoraes.cursomc.domain.enums.TipoCliente;
import com.willianmoraes.cursomc.repositories.CategoriaRepository;
import com.willianmoraes.cursomc.repositories.CidadeRepository;
import com.willianmoraes.cursomc.repositories.ClienteRepository;
import com.willianmoraes.cursomc.repositories.EnderecoRepository;
import com.willianmoraes.cursomc.repositories.EstadoRepository;
import com.willianmoraes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Autowired
	CategoriaRepository repositoryCategoria;
	
	@Autowired
	ProdutoRepository repositoryProduto;
	
	@Autowired
	EstadoRepository repositoryEstado;
	
	@Autowired
	CidadeRepository repositoryCidade;

	@Autowired
	ClienteRepository repositoryCliente;
	
	@Autowired
	EnderecoRepository repositoryEndereco;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		repositoryCategoria.saveAll(Arrays.asList(cat1, cat2));
		repositoryProduto.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2= new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Guarulhos", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		repositoryEstado.saveAll(Arrays.asList(est1,est2));
		repositoryCidade.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Willian Moraes", "willian.moraes@totvs.com.br", "29509641847", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("985470720","24020303"));
		
		Endereco end1 = new Endereco(null, "Rua Martins Fontes", "265", "N/A", "Jardim América", "07194120", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua Libano", "482", "N/A", "Jardim São Francisco", "07195040", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		repositoryCliente.save(cli1);
		repositoryEndereco.saveAll(Arrays.asList(end1, end2));
	}

}
