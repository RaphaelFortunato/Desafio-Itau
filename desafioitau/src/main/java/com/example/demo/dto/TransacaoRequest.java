package com.example.demo.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransacaoRequest {

	@NotNull
	private double valor;
	
	@NotNull
	private OffsetDateTime dataHora;
	
	
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	
	public double getValor() {
		return valor;
	}
	
	
	
}
