package com.desafio.tecnico.soja.dto;

import com.desafio.tecnico.soja.domain.model.Transporte.TransportStatus;

import java.time.LocalDate;

public record ExportacaoDTO(Long loteId, String paisDestino, String paisEmbarque, LocalDate dataExportacao, TransportStatus status) {
}
