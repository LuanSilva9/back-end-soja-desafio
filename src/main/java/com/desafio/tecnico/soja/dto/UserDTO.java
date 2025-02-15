package com.desafio.tecnico.soja.dto;

import com.desafio.tecnico.soja.domain.model.User.UserRole;

public record UserDTO(String nome, UserRole role) {
}
