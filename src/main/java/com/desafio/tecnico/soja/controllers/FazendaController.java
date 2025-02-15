package com.desafio.tecnico.soja.controllers;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import com.desafio.tecnico.soja.dto.FazendaDTO;
import com.desafio.tecnico.soja.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
    @Autowired
    private FazendaService fazendaService;

    @GetMapping("/all")
    public ResponseEntity<List<Fazenda>> getAllFazendas() {
        return ResponseEntity.ok().body(fazendaService.getAllFazendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fazenda> getFazendaById(@PathVariable(name="id") Long id) throws Exception {
        return ResponseEntity.ok().body(fazendaService.getFazendaById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Fazenda> createFazenda(@RequestBody FazendaDTO data) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(fazendaService.createFazenda(data));
    }
}
