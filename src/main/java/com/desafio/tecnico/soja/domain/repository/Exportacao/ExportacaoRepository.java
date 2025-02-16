package com.desafio.tecnico.soja.domain.repository.Exportacao;

import com.desafio.tecnico.soja.domain.model.Exportacao.Exportacao;
import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExportacaoRepository extends JpaRepository<Exportacao, Long> {
    Optional<Exportacao> findExportacaoById(Long id);
    Optional<Exportacao> findExportacaoByLote(Lote lote);
}
