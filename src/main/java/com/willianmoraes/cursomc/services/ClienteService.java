package com.willianmoraes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willianmoraes.cursomc.domain.Categoria;
import com.willianmoraes.cursomc.domain.Cliente;
import com.willianmoraes.cursomc.repositories.ClienteRepository;
import com.willianmoraes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Integer id){
		Optional<Cliente> obj = repository.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id + ", Tipo: " + Categoria.class.getName()));
	}	
}
