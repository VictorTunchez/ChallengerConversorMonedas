package com.conversormonedas.modelos;

public class Moneda{
    String nombre;
    double valor;

    public Moneda(Conversiones moneda) {
    }
    public Moneda() {
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
