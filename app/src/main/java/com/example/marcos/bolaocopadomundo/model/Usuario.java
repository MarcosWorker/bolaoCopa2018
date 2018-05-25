package com.example.marcos.bolaocopadomundo.model;

import java.util.List;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Usuario {

    private String id;
    private String uid;
    private String email;
    private String nome;
    private int pontuacao;

    public Usuario() {}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    private List<Jogo> jogos;

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
