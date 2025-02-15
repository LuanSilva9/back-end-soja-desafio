package com.desafio.tecnico.soja.dto;

import com.desafio.tecnico.soja.domain.model.Lote.Quality;

import java.time.LocalDate;

public record LoteDTO(Long fazendaId, LocalDate dataColheita, Float quantidade, Quality qualidade) {
}
