package com.desafio.tecnico.soja.domain.repository.Lote;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Lote.Quality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
    Optional<Lote> findLoteById(Long id);
    Optional<List<Lote>> findLoteByFazenda(Fazenda fazenda);
    Optional<List<Lote>> findLoteByQualidade(Quality qualidade);
}
