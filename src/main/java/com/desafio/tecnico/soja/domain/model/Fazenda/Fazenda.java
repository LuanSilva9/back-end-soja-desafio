package com.desafio.tecnico.soja.domain.model.Fazenda;

import com.desafio.tecnico.soja.domain.model.User.User;
import com.desafio.tecnico.soja.dto.FazendaDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="fazenda")
@Table(name="fazenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fazenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacao;

    @OneToOne
    @JoinColumn(name = "produtorId", referencedColumnName = "id")
    private User produtor;

    private Float areaCultivada;

    public Fazenda(FazendaDTO data, User produtor) {
        this.nome = data.nome();
        this.localizacao = data.localizacao();
        this.produtor = produtor;
        this.areaCultivada = data.areaCultivada();
    }
}
