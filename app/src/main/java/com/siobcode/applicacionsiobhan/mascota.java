package com.siobcode.applicacionsiobhan;

public class mascota {

    private String nombre;
    private int foto;
    private int favorito;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public mascota(int foto,String nombre, int favorito) {
        this.nombre = nombre;
        this.foto = foto;
        this.favorito = favorito;
    }
}
