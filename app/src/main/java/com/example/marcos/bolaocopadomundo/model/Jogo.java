package com.example.marcos.bolaocopadomundo.model;

public class Jogo {

    private String time1;
    private int placarTime1;
    private int imgTime1;
    private String time2;
    private int placarTime2;
    private int imgTime2;
    private String rodada;
    private String fase;
    /**
     * se jogo ainda n aconteceu = 0
     * se time1 vencer = 1
     * se time2 vencer = 2
     * se der empate = 3
     */
    private String resultado;
    private String data;
    private String hora;

    public Jogo() {}

    public Jogo(String time1,
                int placarTime1,
                int imgTime1,
                String time2,
                int placarTime2,
                int imgTime2,
                String rodada,
                String fase,
                String resultado,
                String data,
                String hora) {
        this.time1 = time1;
        this.placarTime1 = placarTime1;
        this.imgTime1 = imgTime1;
        this.time2 = time2;
        this.placarTime2 = placarTime2;
        this.imgTime2 = imgTime2;
        this.rodada = rodada;
        this.fase = fase;
        this.resultado = resultado;
        this.data = data;
        this.hora = hora;
    }

    public int getImgTime1() {
        return imgTime1;
    }

    public void setImgTime1(int imgTime1) {
        this.imgTime1 = imgTime1;
    }

    public int getImgTime2() {
        return imgTime2;
    }

    public void setImgTime2(int imgTime2) {
        this.imgTime2 = imgTime2;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public int getPlacarTime1() {
        return placarTime1;
    }

    public void setPlacarTime1(int placarTime1) {
        this.placarTime1 = placarTime1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public int getPlacarTime2() {
        return placarTime2;
    }

    public void setPlacarTime2(int placarTime2) {
        this.placarTime2 = placarTime2;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
