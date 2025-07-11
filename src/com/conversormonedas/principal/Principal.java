package com.conversormonedas.principal;

import com.conversormonedas.modelos.Menu;
import com.conversormonedas.repo.ObtenerConversiones;

import java.io.IOException;
import java.net.http.HttpClient;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Menu menu = new Menu();
        //menu.mostrarMenu();
        ObtenerConversiones obtenerConversiones = new ObtenerConversiones();
        obtenerConversiones.obtenerConversion("USD");

    }
}
