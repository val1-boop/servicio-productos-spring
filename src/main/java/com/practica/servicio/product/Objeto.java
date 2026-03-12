package com.practica.servicio.product;

public class Objeto {

    private int id;
    private double precio;
    private String nombre;
    private String categoria;

    public Objeto(int id, double precio, String nombre, String categoria) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}


