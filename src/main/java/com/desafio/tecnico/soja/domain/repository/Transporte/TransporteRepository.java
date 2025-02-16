package com.desafio.tecnico.soja.domain.repository.Transporte;


import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Transporte.TransportStatus;
import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {
    Boolean existsTransporteByLoteIdAndStatus(Long id, TransportStatus status);
    Optional<Transporte> findTransporteById(Long id);
    Optional<Transporte> findTransporteByLote(Lote lote);
}
