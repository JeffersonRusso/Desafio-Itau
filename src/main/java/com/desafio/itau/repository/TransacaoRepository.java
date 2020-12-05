package com.desafio.itau.repository;

import java.util.ArrayList;
import java.util.List;

import com.desafio.itau.model.Transacao;

public class TransacaoRepository implements CRUD<Transacao>  {
	
	public static List<Transacao> transacoes = new ArrayList<>();
	
	public List<Transacao> get() {
		return transacoes;
	}
	
	public void salvar(Transacao tsc)
	{
		transacoes.add(tsc);
	}
	public void deletar()
	{
		transacoes.clear();
	}

	@Override
	public void setTipoDeBanco(Transacao obj) {
		// TODO Auto-generated method stub
		
	}


}
