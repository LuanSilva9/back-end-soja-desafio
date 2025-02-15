package com.desafio.tecnico.soja.controllers;

import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.dto.LoteDTO;
import com.desafio.tecnico.soja.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lote")
public class LoteController {
    @Autowired
    private LoteService loteService;

    @GetMapping("/{id}")
    public ResponseEntity<Lote> getLoteById(@PathVariable(name="id") Long id) throws Exception {
        return ResponseEntity.ok().body(loteService.getLoteById(id));
    }

    @GetMapping("/fazenda/{nome_fazenda}")
    public ResponseEntity<List<Lote>> getLotesByFazenda(@PathVariable(name="nome_fazenda") String nome_fazenda) throws Exception {
        return ResponseEntity.ok().body(loteService.getLoteByFazenda(nome_fazenda));
    }

    @PostMapping("/create")
    public ResponseEntity<Lote> createLote(@RequestBody LoteDTO data) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(loteService.createLote(data));
    }
}
