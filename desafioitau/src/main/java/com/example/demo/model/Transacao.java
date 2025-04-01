package com.example.demo.model;

import java.time.OffsetDateTime;

public class Transacao {

	
	private double valor;
	private OffsetDateTime dataHora;
	
	public Transacao(final double valor, final OffsetDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	
	public double getValor() {
		return valor;
	}
	
	
	
}
