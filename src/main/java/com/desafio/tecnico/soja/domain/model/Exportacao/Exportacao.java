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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loteId", referencedColumnName = "id")
    private Lote lote;

    private String paisDestino;
    private String portoEmbarque;
    private LocalDate dataExportacao;
    private TransportStatus status;

    public Exportacao(ExportacaoDTO data, String portoEmbarque, Lote lote) {
        this.lote = lote;
        this.paisDestino = data.paisDestino();
        this.portoEmbarque = portoEmbarque;
        this.dataExportacao = data.dataExportacao();
        this.status = TransportStatus.EM_TRANSITO;
    }
}
