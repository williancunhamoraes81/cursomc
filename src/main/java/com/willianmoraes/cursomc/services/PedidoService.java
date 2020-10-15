package com.willianmoraes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willianmoraes.cursomc.domain.Categoria;
import com.willianmoraes.cursomc.domain.Cliente;
import com.willianmoraes.cursomc.domain.Pedido;
import com.willianmoraes.cursomc.repositories.PedidoRepository;
import com.willianmoraes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Integer id){
		Optional<Pedido> obj = repository.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id + ", Tipo: " + Pedido.class.getName()));
	}	
}
