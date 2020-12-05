package com.desafio.itau.repository;

public interface CRUD<T> {

	public void salvar(T obj);
	public void deletar();
	public void setTipoDeBanco(T obj);
}
