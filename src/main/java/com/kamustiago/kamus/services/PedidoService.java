package com.kamustiago.kamus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.domain.Pedido;
import com.kamustiago.kamus.repositories.PedidoRepository;
import com.kamustiago.kamus.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	// Instanciei PedidoRepository com a anotacao Autorired
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
				} 

	}

