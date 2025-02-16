package com.desafio.tecnico.soja.service;

import com.desafio.tecnico.soja.domain.model.Exportacao.Exportacao;
import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Lote.Quality;
import com.desafio.tecnico.soja.domain.model.Transporte.TransportStatus;
import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;
import com.desafio.tecnico.soja.domain.repository.Exportacao.ExportacaoRepository;
import com.desafio.tecnico.soja.domain.repository.Transporte.TransporteRepository;
import com.desafio.tecnico.soja.dto.ExportacaoDTO;
import com.desafio.tecnico.soja.dto.UpdateTransportStatusDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportacaoService {
    @Autowired
    private ExportacaoRepository exportacaoRepository;

    @Autowired
    private TransporteRepository  transporteRepository;

    @Autowired
    private LoteService loteService;
    @Autowired
    private TransporteService transporteService;

    @Transactional
    public Exportacao getExportacaoById(Long id) throws Exception {
        return exportacaoRepository.findExportacaoById(id).orElseThrow(() -> new RuntimeException("Exportação não encontrada"));
    }

    @Transactional
    public Exportacao createExportacao(ExportacaoDTO data) throws Exception {
        Lote lote = loteService.getLoteById(data.loteId());

        Boolean transporteConcluido = transporteRepository.existsTransporteByLoteIdAndStatus(data.loteId(), TransportStatus.ENTREGUE);

        if(!transporteConcluido) {
            throw new RuntimeException("O lote precisa ser transportado antes de ser exportado.");
        }

        Transporte transporte = transporteService.getTransporteByLote(lote);

        String portoEmbarque = transporte.getDestino();

        Exportacao newExportacao = new Exportacao(data, portoEmbarque, lote);

        return this.exportacaoRepository.save(newExportacao);
    }

    @Transactional
    public Exportacao updateTransportStatus(Long id, UpdateTransportStatusDTO data) throws Exception {
        Exportacao exportacao = this.getExportacaoById(id);

        exportacao.setStatus(data.status());

        return this.exportacaoRepository.save(exportacao);
    }
}
