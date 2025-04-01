package com.example.demo.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstatisticasResponse;
import com.example.demo.service.TransacaoServico;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

	private final TransacaoServico transacaoServico;
	
	public EstatisticasController(TransacaoServico servico) {
		this.transacaoServico = servico;
	}
	
	@GetMapping
	public ResponseEntity<EstatisticasResponse> getEstatitiscas(){
		
		DoubleSummaryStatistics statis = transacaoServico.getEstatiticas();
		
		return ResponseEntity.ok(new EstatisticasResponse(statis));
		
	}
}
