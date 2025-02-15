package com.desafio.tecnico.soja.controllers;

import com.desafio.tecnico.soja.domain.model.Transporte.Transporte;
import com.desafio.tecnico.soja.dto.TransportDTO;
import com.desafio.tecnico.soja.dto.UpdateTransportStatusDTO;
import com.desafio.tecnico.soja.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transporte")
public class TransporteController {
    @Autowired
    private TransporteService transporteService;

    @GetMapping("/{id}")
    public ResponseEntity<Transporte> getTransporteById(@PathVariable(name = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(transporteService.getTransporteById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Transporte> createTransporte(@RequestBody TransportDTO data) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(transporteService.createTransporte(data));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Transporte> updateTransportStatus(@PathVariable(name="id") Long id,  @RequestBody UpdateTransportStatusDTO data) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.updateTransportStatus(id, data));
    }
}
