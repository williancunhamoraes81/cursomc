package com.willianmoraes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	public Categoria insert(Categoria obj){
		obj.setId(null);	
		return repository.save(obj);	
	}
	
	public Categoria update(Categoria obj){	
		findById(obj.getId());
		return repository.save(obj);	
	}
	
	public void delete(Integer id){	
		findById(id);
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new com.willianmoraes.cursomc.services.exceptions.DataIntegrityViolationException("Não é possível excluir a categoria");
		}
	}
	
}
