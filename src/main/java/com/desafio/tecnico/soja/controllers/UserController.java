package com.desafio.tecnico.soja.controllers;

import com.desafio.tecnico.soja.domain.model.User.User;
import com.desafio.tecnico.soja.dto.UserDTO;
import com.desafio.tecnico.soja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserByIdParam(@PathVariable(name="id") Long id) throws Exception {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(data));
    }

}
