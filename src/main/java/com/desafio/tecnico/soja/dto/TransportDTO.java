package com.desafio.tecnico.soja.dto;

import com.desafio.tecnico.soja.domain.model.Transporte.TransportStatus;

import java.time.LocalDate;

public record TransportDTO(Long loteId, String origem, String destino, LocalDate dataSaida, LocalDate dataChegada) {
}
