package com.desafio.tecnico.soja.domain.repository.Lote;

import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoteRepository extends JpaRepository<Lote, Long> {
    Optional<Lote> findLoteById(Long id);
}
