package com.kamustiago.kamus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.domain.Cliente;
import com.kamustiago.kamus.repositories.ClienteRepository;
import com.kamustiago.kamus.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	// Instanciei ClienteRepository com a anotacao Autorired
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
				} 

	}

