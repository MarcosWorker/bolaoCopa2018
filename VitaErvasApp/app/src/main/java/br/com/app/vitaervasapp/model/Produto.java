package br.com.app.vitaervasapp.model;

/**
 * Created by marcos on 13/01/18.
 */

public class Produto {

    private int id;
    private String nome;
    private String desc;
    private double preco;
    private int div;
    private int img;
    private int status;

    public Produto(int id, String nome, String desc, double preco, int div, int img, int status) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.div = div;
        this.img = img;
        this.status = status;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDiv() {
        return div;
    }

    public void setDiv(int div) {
        this.div = div;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
