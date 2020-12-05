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
import com.desafio.itau.repository.CRUD;
import com.desafio.itau.repository.TransacaoRepository;

/*
 * O objeto Json quando eviado, retornava uma hora com o UTF-0, eu não sei exatamente se esta errado o resultado ou esse é o resultado esperado.
 * EX, se for enviado o OFFSETDATATIME com o valor "2020-12-05T17:47:24.4492173-03:00 o retorno é 2020-12-05T20:47:24.4492173Z
 * Ele cancela o UTF-3 e soma a diferença no corpo, fazendo com que a hora apareça sem o UTF
 * 
 *  UPDATE >> Deixei o atributo datHora com .now, o bug foi corrigido
 */

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransacaoController {
	
	//Repositorio para salvar as transacoes
	public CRUD<Transacao> banco = new TransacaoRepository();
	
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
