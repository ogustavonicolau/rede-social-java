package com.redesocial.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.social.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
    
}