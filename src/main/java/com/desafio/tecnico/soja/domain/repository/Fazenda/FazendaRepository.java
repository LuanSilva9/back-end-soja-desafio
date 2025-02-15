package com.desafio.tecnico.soja.domain.repository.Fazenda;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    Optional<Fazenda> findFazendaById(Long id);
}
