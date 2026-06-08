package com.redesocial.social.dto;

public class LoginResponse {

    private String mensagem;
    private String email;

    public LoginResponse(String mensagem, String email) {
        this.mensagem = mensagem;
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getEmail() {
        return email;
    }


}