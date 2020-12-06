package com.desafio.itau.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.itau.model.Transacao;

@Service
public class TransacaoRepository implements CRUD<Transacao>  {
	
	// Guarda as transacoes
	public List<Transacao> transacoes = new ArrayList<>();
	
	//pega a lista de transacoes 
	public List<Transacao> getTransacoes() {		
		return transacoes; 
	}
	
	//salva a transacao em uma lista
	public void salvar(Transacao tsc){
		transacoes.add(tsc);
		
	}
	
	//deleta as transacoes
	public void deletar(){
		transacoes.clear();
	}
}
