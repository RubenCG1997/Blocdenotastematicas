package com.iescamas.blocdenotastemticas.Modelo;

import java.io.Serializable;

public class Tematicas implements Serializable {

    private int img;
    private String texto;
    private int color;

    public Tematicas() {}

    public Tematicas(int img, String texto,int color) {
        this.img = img;
        this.texto = texto;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
