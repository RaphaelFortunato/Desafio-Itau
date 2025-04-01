package com.example.demo.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DesafioitauApplication;
import com.example.demo.dto.TransacaoRequest;
import com.example.demo.model.Transacao;
import com.example.demo.service.TransacaoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    private final DesafioitauApplication desafioitauApplication;
	
	private final TransacaoServico servicoTransacaoServico;
	
	public TransacaoController(TransacaoServico servico, DesafioitauApplication desafioitauApplication) {
		this.servicoTransacaoServico = servico;
		this.desafioitauApplication = desafioitauApplication;
	}
	
	@PostMapping
	public ResponseEntity<Void> criarTransacao(@Valid @RequestBody TransacaoRequest transacaoRequest){
	
		if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now()) || transacaoRequest.getValor() <= 0) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		servicoTransacaoServico.addTransacao(new Transacao(transacaoRequest.getValor(), transacaoRequest.getDataHora() ));
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTransacao(){
		servicoTransacaoServico.limparTransacao();
		return ResponseEntity.ok().build();
	}

}
