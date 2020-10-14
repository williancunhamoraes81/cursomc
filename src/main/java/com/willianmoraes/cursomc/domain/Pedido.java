package com.willianmoraes.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date instante;
	
	private Pagamento pagamento;
	
	private Cliente cliente;
	
	private Endereco enderecoDeEntrega;
	
	
	public Pedido() {
		
	}


	public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	

}
