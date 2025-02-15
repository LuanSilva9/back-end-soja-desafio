package com.desafio.tecnico.soja.domain.model.Exportacao;

import com.desafio.tecnico.soja.domain.model.Lote.Lote;
import com.desafio.tecnico.soja.domain.model.Transporte.TransportStatus;
import com.desafio.tecnico.soja.dto.ExportacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "exportacao")
@Table(name="exportacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Exportacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "loteId", referencedColumnName = "id")
    private Lote lote;

    private String paisDestino;
    private String paisEmbarque;
    private LocalDate dataExportacao;
    private TransportStatus status;

    public Exportacao(ExportacaoDTO data, Lote lote) {
        this.lote = lote;
        this.paisDestino = data.paisDestino();
        this.paisEmbarque = data.paisEmbarque();
        this.dataExportacao = data.dataExportacao();
        this.status = data.status();
    }
}
