package com.desafio.itau.model;

import java.time.OffsetDateTime;

public class Transacao {
	
	private double valor;
	
	private OffsetDateTime dataHora = OffsetDateTime.now();
    
	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
