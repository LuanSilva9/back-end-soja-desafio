package com.desafio.tecnico.soja.service;

import com.desafio.tecnico.soja.domain.model.User.User;
import com.desafio.tecnico.soja.domain.repository.User.UserRepository;
import com.desafio.tecnico.soja.dto.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(Long id) throws Exception {
        return userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @Transactional
    public User createUser(UserDTO data) {
        User newUser = new User(data);

        return this.userRepository.save(newUser);
    }
}
