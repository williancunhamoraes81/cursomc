package com.willianmoraes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willianmoraes.cursomc.domain.Categoria;
import com.willianmoraes.cursomc.repositories.CategoriaRepository;
import com.willianmoraes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Integer id){
		Optional<Categoria> obj = repository.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id + ", Tipo: " + Categoria.class.getName()));
	}	
}
