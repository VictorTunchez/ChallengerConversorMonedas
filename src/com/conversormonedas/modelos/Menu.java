package com.conversormonedas.modelos;

import java.util.Scanner;

public class Menu {

    public void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion =0;
        while(opcion !=7){
            System.out.println("****************************************************");
            System.out.println("Sea bienvenido al conversor de moneda "+"\n\n");
            System.out.println("1) Dolar -> Peso Argentino");
            System.out.println("2) Peso Argentino -> Dolar");
            System.out.println("3) Dola -> Real Brasileño");
            System.out.println("4) Real Brasileño -> Dolar");
            System.out.println("5) Dolar -> Peso Colombiano");
            System.out.println("6) Peso Colombiano -> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida: ");
            System.out.println("****************************************************"+"\n\n");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Programa finalizado.....");
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
                    break;
            }
        }
        scanner.close();
    }
}

