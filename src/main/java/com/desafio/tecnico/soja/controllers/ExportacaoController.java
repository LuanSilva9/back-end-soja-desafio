package com.desafio.tecnico.soja.controllers;

import com.desafio.tecnico.soja.domain.model.Exportacao.Exportacao;
import com.desafio.tecnico.soja.dto.ExportacaoDTO;
import com.desafio.tecnico.soja.dto.UpdateTransportStatusDTO;
import com.desafio.tecnico.soja.service.ExportacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exportacao")
public class ExportacaoController {
    @Autowired
    private ExportacaoService exportacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Exportacao> getExportacaoById(@PathVariable(name="id") Long id) throws Exception {
        return ResponseEntity.ok().body(exportacaoService.getExportacaoById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Exportacao> createExportacao(@RequestBody ExportacaoDTO data) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(exportacaoService.createExportacao(data));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Exportacao> updateTransportStatus(@PathVariable(name="id") Long id, @RequestBody UpdateTransportStatusDTO data) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(exportacaoService.updateTransportStatus(id, data));
    }
}
