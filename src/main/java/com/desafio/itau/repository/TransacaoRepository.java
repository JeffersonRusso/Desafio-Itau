package com.desafio.itau.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.itau.model.Transacao;

@Service
public class TransacaoRepository implements CRUD<Transacao>  {
	
	public List<Transacao> transacoes = new ArrayList<>();
	
	public List<Transacao> getTransacoes() {		
		return transacoes;
	}
	
	public void salvar(Transacao tsc){
		transacoes.add(tsc);
		
	}
	public void deletar(){
		transacoes.clear();
	}
}
