package com.desafio.tecnico.soja.service;

import com.desafio.tecnico.soja.domain.model.Exportacao.Exportacao;
import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Lote.Quality;
import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;
import com.desafio.tecnico.soja.domain.repository.Exportacao.ExportacaoRepository;
import com.desafio.tecnico.soja.domain.repository.Lote.LoteRepository;
import com.desafio.tecnico.soja.domain.repository.Transporte.TransporteRepository;
import com.desafio.tecnico.soja.dto.LoteDTO;
import com.desafio.tecnico.soja.dto.LoteRastreadoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoteService {
    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private FazendaService fazendaService;

    @Autowired
    private TransporteRepository transporteRepository;
    @Autowired
    private ExportacaoRepository exportacaoRepository;

    @Transactional
    public Lote getLoteById(Long id) throws Exception {

        return loteRepository.findLoteById(id).orElseThrow(()-> new RuntimeException("Lote não encontrado"));
    }

    @Transactional
    public List<Lote> getLoteByFazenda(String nomeFazenda) throws Exception {
        Fazenda fazenda = fazendaService.getFazendaByNome(nomeFazenda);

        List<Lote> lotes = loteRepository.findLoteByFazenda(fazenda).orElse(Collections.emptyList());

        return lotes;
    }

    @Transactional
    public Lote createLote(LoteDTO data) throws Exception {
        Fazenda fazenda = fazendaService.getFazendaById(data.fazendaId());

        if(fazenda.getQntSoja() < data.quantidade()) {
            throw new RuntimeException("Quantidade de Soja da fazenda insuficiente, plante mais!");
        }

        Lote newLote = new Lote(data, fazenda);

        fazenda.setQntSoja(fazenda.getQntSoja() - data.quantidade());

        return this.loteRepository.save(newLote);
    }

    @Transactional
    public LoteRastreadoDTO rastrear(Long id) throws Exception {
        Lote lote = this.getLoteById(id);

        Transporte transporte = transporteRepository.findTransporteByLote(lote).orElse(null);
        Exportacao exportacao = exportacaoRepository.findExportacaoByLote(lote).orElse(null);

        LoteRastreadoDTO newLoteRastreado = new LoteRastreadoDTO(lote, transporte, exportacao);

        if(transporte == null || exportacao == null) {
            throw new RuntimeException("O Lote em questão ainda nao foi transportado e nem exportado, logo nao existem informacoes de rastreio!");
        }

        return newLoteRastreado;
    }

    @Transactional
    public List<Lote> getLotesByQualidade(Quality qualidade) {
        List<Lote> lotesPorQualidade = this.loteRepository.findLoteByQualidade(qualidade).orElse(Collections.emptyList());

        return lotesPorQualidade;
    }

}
