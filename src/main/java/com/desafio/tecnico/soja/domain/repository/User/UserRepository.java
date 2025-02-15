package com.desafio.tecnico.soja.domain.repository.User;

import com.desafio.tecnico.soja.domain.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
}
