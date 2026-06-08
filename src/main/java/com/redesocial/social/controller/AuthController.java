package com.redesocial.social.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.social.dto.LoginRequest;
import com.redesocial.social.model.Usuario;
import com.redesocial.social.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Optional<Usuario> usuarioOptional =
                usuarioRepository.findByEmail(request.getEmail());

        if (usuarioOptional.isEmpty()) {
            return "Usuário não encontrado";
        }

        Usuario usuario = usuarioOptional.get();

        boolean senhaCorreta =
                passwordEncoder.matches(
                        request.getSenha(),
                        usuario.getSenha()
                );

        if (!senhaCorreta) {
            return "Senha incorreta";
        }

        return "Login realizado com sucesso!";
    }
}