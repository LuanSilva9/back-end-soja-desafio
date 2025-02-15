package com.desafio.tecnico.soja.domain.repository.Lote;

import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
    Optional<Lote> findLoteById(Long id);
}
