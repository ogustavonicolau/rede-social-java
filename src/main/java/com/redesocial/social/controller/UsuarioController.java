package com.redesocial.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.social.model.Usuario;
import com.redesocial.social.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {

        usuario.setSenha(
            passwordEncoder.encode(usuario.getSenha())
        );
        return repository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }
}