package com.desafio.tecnico.soja.domain.model.User;

import com.desafio.tecnico.soja.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private UserRole role;

    public User(UserDTO data) {
        this.nome = data.nome();
        this.role = data.role();
    }
}
