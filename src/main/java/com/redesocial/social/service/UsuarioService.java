package com.redesocial.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.redesocial.social.model.Usuario;
import com.redesocial.social.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    public Usuario criar(Usuario usuario) {

        usuario.setSenha( 
            passwordEncoder.encode(usuario.getSenha())
        );

        return repository.save(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }
}
