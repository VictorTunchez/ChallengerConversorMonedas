package com.conversormonedas.principal;

import com.conversormonedas.modelos.Menu;
import java.io.IOException;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.mostrarMenu();
//        ObtenerConversiones obtenerConversiones = new ObtenerConversiones();
//        obtenerConversiones.obtenerCambio("USD","ARS");
//        obtenerConversiones.convertir();

    }
}
