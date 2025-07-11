package com.conversormonedas.modelos;

import com.conversormonedas.repo.ObtenerConversiones;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void mostrarMenu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion =0;
        ObtenerConversiones obtenerConversiones = new ObtenerConversiones();
        while(opcion !=7){
            System.out.println("****************************************************");
            System.out.println("Sea bienvenido al conversor de moneda "+"\n\n");
            System.out.println("1) Dolar -> Peso Argentino");
            System.out.println("2) Peso Argentino -> Dolar");
            System.out.println("3) Dolar -> Real Brasileño");
            System.out.println("4) Real Brasileño -> Dolar");
            System.out.println("5) Dolar -> Peso Colombiano");
            System.out.println("6) Peso Colombiano -> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida: ");
            System.out.println("****************************************************"+"\n\n");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                     obtenerConversiones.convertir("USD","ARS");
                    break;
                case 2:
                    obtenerConversiones.convertir("ARS","USD");
                    break;
                case 3:
                    obtenerConversiones.convertir("USD","BRL");
                    break;
                case 4:
                    obtenerConversiones.convertir("BRL","USD");
                    break;
                case 5:
                    obtenerConversiones.convertir("USD","COP");
                    break;
                case 6:
                    obtenerConversiones.convertir("COP","USD");
                    break;
                case 7:
                    System.out.println("Saliendo.....");
                    System.out.println("Programa finalizado! ");
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
                    break;
            }
        }
        scanner.close();
    }
}

