package com.redesocial.social.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.social.model.Curtida;
import com.redesocial.social.repository.CurtidaRepository;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    private final CurtidaRepository repository;

    public CurtidaController(CurtidaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Curtida curtir(@RequestBody Curtida curtida) {
        return repository.save(curtida);
    }

    @GetMapping
    public List<Curtida> listar() {
        return repository.findAll();
    }
}