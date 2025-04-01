package com.example.demo.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.stereotype.Service;

import com.example.demo.model.Transacao;

@Service
public class TransacaoServico {
	
	private final Queue<Transacao> transacoes = new ConcurrentLinkedDeque<>();
	
	public void addTransacao(Transacao trans) {
		transacoes.add(trans);
	}
	
	public void limparTransacao() {
		transacoes.clear();
	}

	public DoubleSummaryStatistics getEstatiticas() {
		OffsetDateTime dtAtual = OffsetDateTime.now();
		
		return transacoes.stream()
				//.filter(t -> t.getDataHora().isAfter(dtAtual.minusSeconds(60)))
				.mapToDouble(Transacao::getValor)
				.summaryStatistics();
	}
}



