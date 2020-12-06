package com.desafio.itau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.itau.model.Estatistica;
import com.desafio.itau.repository.TransacaoRepository;
import com.desafio.itau.service.CalEstatisticaService;

@RestController
@RequestMapping("/estatistica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstatisticaController {
	
	//repositorio de transacoes
	@Autowired
	private TransacaoRepository repository;
	
	//Calcular estatisticas
	private CalEstatisticaService calEst = new CalEstatisticaService();
	
	//pega estatistica de todas as transacoes validas ( dos ultimos x segundos )
	@GetMapping
	public ResponseEntity<Estatistica> get(){	
		
		return ResponseEntity.ok(calEst.calcular(repository.getTransacoes()));
	}
	
	// modificador das transacoes nos ultimos X segundos
	@PostMapping("/{milisegundos}")
	public void post(@PathVariable long milisegundos) {
		calEst.setIntervaloEmMilesegundos(milisegundos);
	}

}
