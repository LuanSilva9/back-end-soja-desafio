package com.desafio.tecnico.soja.domain.repository.Exportacao;

import com.desafio.tecnico.soja.domain.model.Exportacao.Exportacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExportacaoRepository extends JpaRepository<Exportacao, Long> {
    Optional<Exportacao> findExportacaoById(Long id);
}
