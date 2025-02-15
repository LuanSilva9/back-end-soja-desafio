package com.desafio.tecnico.soja.dto;

import java.time.LocalDate;

public record ExportacaoDTO(Long lote, String paisDestino, String paisEmbarque, LocalDate dataExportacao) {
}
