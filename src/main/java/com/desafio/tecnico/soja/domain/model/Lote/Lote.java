package com.desafio.tecnico.soja.domain.model.Lote;

import com.desafio.tecnico.soja.domain.model.Fazenda.Fazenda;
import com.desafio.tecnico.soja.dto.LoteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "lote")
@Table(name = "lote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fazendaId", referencedColumnName = "id")
    private Fazenda fazenda;

    private LocalDate dataColheita;
    private Float quantidade;
    private Quality qualidade;

    public Lote(LoteDTO data, Fazenda fazenda) {
        this.fazenda = fazenda;
        this.dataColheita = data.dataColheita();
        this.quantidade = data.quantidade();
        this.qualidade = data.qualidade();
    }
}
