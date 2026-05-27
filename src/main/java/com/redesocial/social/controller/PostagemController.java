package com.redesocial.social.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.social.model.Postagem;
import com.redesocial.social.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemRepository repository;

    public PostagemController(PostagemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Postagem criar(@RequestBody Postagem postagem) {
        return repository.save(postagem);
    }

    @GetMapping
    public List<Postagem> listar() {
        return repository.findAll();
    }
}