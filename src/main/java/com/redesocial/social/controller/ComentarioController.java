package com.redesocial.social.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.social.model.Comentario;
import com.redesocial.social.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioRepository repository;

    public ComentarioController(ComentarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Comentario criar(@RequestBody Comentario comentario) {
        return repository.save(comentario);
    }

    @GetMapping
    public List<Comentario> listar() {
        return repository.findAll();
    }
}