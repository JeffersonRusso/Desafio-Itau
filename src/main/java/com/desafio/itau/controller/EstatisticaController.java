package com.desafio.itau.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.itau.model.Estatistica;
import com.desafio.itau.model.Transacao;
import com.desafio.itau.repository.TransacaoRepository;

@RestController
@RequestMapping("/estatistica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstatisticaController {
	
	//Repositorio com as transacoes realizadas
	private TransacaoRepository transacaoRepository = new TransacaoRepository();
	
	
	@GetMapping
	public ResponseEntity<Estatistica> getEstatistica(){	
		return null;
	}
}
