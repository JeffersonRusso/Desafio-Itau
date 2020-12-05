package com.desafio.itau.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.itau.model.Transacao;
import com.desafio.itau.repository.Banco;
import com.desafio.itau.repository.CRUD;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransacaoController {
	
	public CRUD<Transacao> banco = new Banco();
	
	@PostMapping
	public ResponseEntity<Transacao> post (@RequestBody Transacao tsc){	
		OffsetDateTime dataHora = OffsetDateTime.now();
		
		if(tsc.getValor() < 0 || tsc.getDataHora().isAfter(dataHora))
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		
		banco.salvar(tsc);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tsc);
	}
	
	@DeleteMapping
	public void delete (){
		banco.deletar();
	}
	

}
