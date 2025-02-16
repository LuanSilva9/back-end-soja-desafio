package com.desafio.tecnico.soja.dto;

import com.desafio.tecnico.soja.domain.model.Exportacao.Exportacao;
import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;

public record LoteRastreadoDTO(Lote lote, Transporte transporte, Exportacao exportacao) {
}
