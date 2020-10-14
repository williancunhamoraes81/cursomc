package com.willianmoraes.cursomc.domain;

import com.willianmoraes.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {

	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
