package com.desafio.tecnico.soja.domain.repository.Transporte;

import com.desafio.tecnico.soja.domain.model.Transporte.TransportStatus;
import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransporteRepository extends JpaRepository<Transporte, Long> {
    Boolean existsTransporteByLoteIdAndStatus(Long id, TransportStatus status);
    Optional<Transporte> findTransporteById(Long id);
}
