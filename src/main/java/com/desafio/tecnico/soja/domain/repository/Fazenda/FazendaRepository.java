package com.desafio.tecnico.soja.domain.repository.Fazenda;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    Optional<Fazenda> findFazendaById(Long id);
    Optional<Fazenda> findFazendaByNome(String nome);
}
