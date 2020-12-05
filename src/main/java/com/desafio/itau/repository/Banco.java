package com.desafio.itau.repository;

import java.util.ArrayList;
import java.util.List;

import com.desafio.itau.model.Transacao;

public class Banco implements CRUD<Transacao>  {
	
	public static List<Transacao> banco = new ArrayList<>();
	
	public void setTipoDeBanco(Transacao tsc) {
		
	}
	
	public List<Transacao> getTransacoes() {
		return banco;
	}
	
	public void salvar(Transacao tsc)
	{
		banco.add(tsc);
	}
	public void deletar()
	{
		banco.clear();
	}


}
