package com.example.marcos.bolaocopadomundo.model;

import java.util.List;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Usuario {

    private String id;
    private String email;
    private String nome;
    private List<Jogo> jogos;

    public Usuario() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}
