package com.desafio.itau.model;

import java.time.OffsetDateTime;


//Bean de Transacao, a transacao recebe um JSON ( POST ) com o valor e hora ( offsetDateTime)
// valor     -> valor da transacao com 2 numeros depois da virgula
// dataHora - > data no padrão ISO 8601


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
