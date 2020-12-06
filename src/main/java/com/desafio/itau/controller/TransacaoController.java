package com.desafio.itau.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.itau.model.Transacao;
import com.desafio.itau.repository.TransacaoRepository;

/*
 * O objeto Json quando eviado, retornava a hora com UTF-0, eu nao sei exatamente se estava errado ou o resultado esperado e esse.
 * EX: se for enviado o OFFSETDATATIME com o valor "2020-12-05T17:47:24.4492173-03:00 o retorno é 2020-12-05T20:47:24.4492173Z
 * Ele cancela o UTF-3 e soma a diferença no Json
 * 
 *  UPDATE >> Deixei o atributo dataHora como offSetDataTime.now(), o bug foi corrigido, porém o campo é preenchido automaticamente
 */

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransacaoController {
	
	//repositorio de transacoes
	@Autowired
	public TransacaoRepository repository;
	
	
	//Cria uma transacao
	@PostMapping
	public ResponseEntity<Transacao> post (@RequestBody Transacao tsc){	
		
		//verifica se a transacao é valida
		if(tsc.getValor() < 0 || tsc.getDataHora().isAfter(OffsetDateTime.now()) || tsc.getDataHora() == null)
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		
		//salva a transacao
		repository.salvar(tsc);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//Deleta todas as transacoes
	@DeleteMapping
	public void delete (){
		repository.deletar();
	}
}
