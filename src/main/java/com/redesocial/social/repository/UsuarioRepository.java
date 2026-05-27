package com.redesocial.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.social.model.Usuario;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}