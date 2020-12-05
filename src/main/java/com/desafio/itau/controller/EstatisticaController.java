package com.desafio.itau.controller;

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
	
	//Repositorio com as transacoes realizadas
	private TransacaoRepository transacaoRepository = new TransacaoRepository();
	
	//Service para calcular as estatisticas
	private CalEstatisticaService calEst = new CalEstatisticaService();
	
	
	@GetMapping
	public ResponseEntity<Estatistica> getEstatistica(){	
		calEst.calcular(transacaoRepository.getTransacoes());
		
		return ResponseEntity.ok(calEst.getEstatistica());
	}
	
	@PostMapping
	public void post(@PathVariable long milisegundos) {
		calEst.setIntervaloEmMilesegundos(milisegundos);
	}

}
