package com.kamustiago.kamus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.domain.Categoria;
import com.kamustiago.kamus.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	// Instanciei CategoriaRepository com a anotacao Autorired
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
