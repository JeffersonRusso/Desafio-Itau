package com.desafio.itau.service;

import java.time.Instant;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import com.desafio.itau.model.Estatistica;
import com.desafio.itau.model.Transacao;



public class CalEstatisticaService {
	
	//Criacao da Model Estatistica para receber os valores processados por DoubleSummaryStatistics
	private Estatistica estatistica = new Estatistica();
	
	//Invertalo em ms que Calcular usa para selecionar as transacoes que iram fazer parte do JSON
	private long intervaloEmMilessegundos = 60000;
	
	
	public void calcular(List<Transacao> tsc) {	
		
	DoubleSummaryStatistics estatisticas = new DoubleSummaryStatistics();
	
	Instant instante = Instant.now();
	
		for (Transacao transacao : tsc) {
			//IF responsavel por permitir apenas a passagem das transacoes que foram postas nos ultimos X intervalo 
			if(instante.toEpochMilli() - transacao.getDataHora().toInstant().toEpochMilli() < intervaloEmMilessegundos)
				estatisticas.accept(transacao.getValor());	
		}
		
		
		estatistica.setAvg(estatisticas.getAverage());
		estatistica.setSum(estatisticas.getSum());
		estatistica.setMax(estatisticas.getMax());
		estatistica.setMin(estatisticas.getMin());
		estatistica.setCount( (int) estatisticas.getCount());
		
		// setMin e setMax estavam retornando  "Infinity" quando nao encontrava um nenhuma transacao
		// entao atribui o valor 0 para corrigir esse problema
		if(estatistica.getCount() == 0) {
			estatistica.setMax(0);
			estatistica.setMin(0);
		}
			
	}
	
	public Estatistica getEstatistica() {
		return this.estatistica;
	}
	
	//Mudar o INTERVALO DE COMPARAÇÕES
	public void setIntervaloEmMilesegundos(long intervalo) {
		this.intervaloEmMilessegundos = intervalo;
	}
}