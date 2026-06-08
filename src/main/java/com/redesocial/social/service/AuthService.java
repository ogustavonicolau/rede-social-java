package com.redesocial.social.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.redesocial.social.dto.LoginRequest;
import com.redesocial.social.dto.LoginResponse;
import com.redesocial.social.model.Usuario;
import com.redesocial.social.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioOptional.isEmpty()) {
            return new LoginResponse(
                "Usuário não encontrado",
                null
            );
        }

        Usuario usuario = usuarioOptional.get();

        boolean senhaCorreta = passwordEncoder.matches(request.getSenha(), usuario.getSenha());

        if (!senhaCorreta) {
            return new LoginResponse(
                "Senha incorreta",
                null
            );
        }

        return new LoginResponse(
            "Login realizado com sucesso",
            usuario.getEmail()
        );
    }
}