package com.kamustiago.kamus;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kamustiago.kamus.domain.Categoria;
import com.kamustiago.kamus.domain.Cidade;
import com.kamustiago.kamus.domain.Cliente;
import com.kamustiago.kamus.domain.Endereco;
import com.kamustiago.kamus.domain.Estado;
import com.kamustiago.kamus.domain.Produto;
import com.kamustiago.kamus.domain.enums.TipoCliente;
import com.kamustiago.kamus.repositories.CategoriaRepository;
import com.kamustiago.kamus.repositories.CidadeRepository;
import com.kamustiago.kamus.repositories.ClienteRepository;
import com.kamustiago.kamus.repositories.EnderecoRepository;
import com.kamustiago.kamus.repositories.EstadoRepository;
import com.kamustiago.kamus.repositories.ProdutoRepository;

@SpringBootApplication
public class KamusApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(KamusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2= new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria silva", "maria@gmail.com", "5464565645", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("345956", "336945425"));
		
		Endereco e1 = new Endereco(null,"Rua flores", "300", "apto 303","Jardim", "7232925", cli1, c1);
		Endereco e2 = new Endereco(null,"Avenida matos", "105", "sala 800","centro", "669804", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
