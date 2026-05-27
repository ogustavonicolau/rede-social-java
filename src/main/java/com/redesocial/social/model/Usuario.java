package com.redesocial.social.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Curtida> curtidas;
}