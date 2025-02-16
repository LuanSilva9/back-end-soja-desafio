package com.desafio.tecnico.soja.service;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import com.desafio.tecnico.soja.domain.model.User.User;
import com.desafio.tecnico.soja.domain.model.User.UserRole;
import com.desafio.tecnico.soja.domain.repository.Fazenda.FazendaRepository;
import com.desafio.tecnico.soja.domain.repository.User.UserRepository;
import com.desafio.tecnico.soja.dto.FazendaDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaService {
    @Autowired
    private FazendaRepository fazendaRepository;

    @Autowired UserService userService;

    @Transactional
    public List<Fazenda> getAllFazendas() {
        return this.fazendaRepository.findAll();
    }

    @Transactional
    public Fazenda getFazendaById(Long id) throws Exception {
        return this.fazendaRepository.findFazendaById(id).orElseThrow(()-> new RuntimeException("Fazenda não encontrada"));
    }

    @Transactional
    public Fazenda getFazendaByNome(String nome) throws Exception {
        return this.fazendaRepository.findFazendaByNome(nome).orElseThrow(()-> new RuntimeException("Fazenda não encontrada"));
    }

    @Transactional
    public Fazenda createFazenda(FazendaDTO data) throws Exception {
        User produtor = this.userService.getUserById(data.produtorId());

        if(produtor.getRole() != UserRole.PRODUTOR) {
            return null;
        }

        Fazenda newFazenda = new Fazenda(data, produtor);

        return this.fazendaRepository.save(newFazenda);
    }

    @Transactional
    public String cultivar(Long id, Float qnt) throws Exception {
        Fazenda fazenda = this.getFazendaById(id);

        if(qnt == 0) {
            throw new RuntimeException("Uma Quantidade de soja não foi passada");
        }

        fazenda.setQntSoja(fazenda.getQntSoja() + qnt);

        return qnt + "kg de soja foram plantados!";
    }
}
