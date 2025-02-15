package com.desafio.tecnico.soja.service;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.repository.Lote.LoteRepository;
import com.desafio.tecnico.soja.dto.LoteDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoteService {
    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private FazendaService fazendaService;

    @Transactional
    public Lote getLoteById(Long id) throws Exception {

        return loteRepository.findLoteById(id).orElseThrow(()-> new RuntimeException("Lote não encontrado"));
    }

    @Transactional
    public Lote createLote(LoteDTO data) throws Exception {
        Fazenda fazenda = fazendaService.getFazendaById(data.fazendaId());

        Lote newLote = new Lote(data, fazenda);

        return this.loteRepository.save(newLote);
    }

}
