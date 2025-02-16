package com.desafio.tecnico.soja.domain.model.Transporte;

import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.dto.TransportDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "transporte")
@Table(name = "transporte")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loteId", referencedColumnName = "id")
    private Lote lote;

    private String origem;
    private String destino;
    private LocalDate dataSaida;
    private LocalDate dataChegada;
    private TransportStatus status;

    public Transporte(TransportDTO data, Lote lote) {
        this.lote = lote;
        this.origem = lote.getFazenda().getNome();
        this.destino = data.destino();
        this.dataSaida = data.dataSaida();
        this.dataChegada = data.dataChegada();
        this.status = TransportStatus.EM_TRANSITO;
    }
}
