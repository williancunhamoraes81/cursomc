package com.willianmoraes.cursomc.domain.enums;

import java.util.Date;

import com.willianmoraes.cursomc.domain.Pagamento;
import com.willianmoraes.cursomc.domain.Pedido;

public class PagamentoComBoleto extends Pagamento {

	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
	
}
