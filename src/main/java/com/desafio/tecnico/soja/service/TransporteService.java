package com.desafio.tecnico.soja.service;

import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;
import com.desafio.tecnico.soja.domain.repository.Transporte.TransporteRepository;
import com.desafio.tecnico.soja.dto.TransportDTO;
import com.desafio.tecnico.soja.dto.UpdateTransportStatusDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransporteService {
    @Autowired
    private TransporteRepository transporteRepository;

    @Autowired
    private LoteService loteService;

    @Transactional
    public Transporte getTransporteById(Long id) throws Exception {
        return transporteRepository.findTransporteById(id).orElseThrow(() -> new RuntimeException("Esse transporte não existe!"));

    }

    @Transactional
    public Transporte createTransporte(TransportDTO data) throws Exception {
        Lote lote = loteService.getLoteById(data.loteId());

        Transporte newTransporte = new Transporte(data, lote);

        return this.transporteRepository.save(newTransporte);
    }

    @Transactional
    public Transporte updateTransportStatus(Long id, UpdateTransportStatusDTO data) throws Exception {
        Transporte transporte = this.getTransporteById(id);

        transporte.setStatus(data.status());

        return transporteRepository.save(transporte);
    }
}
