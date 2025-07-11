package com.conversormonedas.repo;

import com.conversormonedas.modelos.Conversiones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ObtenerConversiones {
    Scanner scanner = new Scanner(System.in);
    private double valorCambio = 0.0;

    private Double obtenerCambio(String monedaBase, String monedaCambio) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/f779d51461157ba4341aa331/latest/"+monedaBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = String.valueOf(response.body());
        Conversiones conversiones = gson.fromJson(json, Conversiones.class);

            for (Map.Entry<String, Double> entry : conversiones.conversion_rates().entrySet()) {
                if(monedaCambio.equalsIgnoreCase(entry.getKey())){
                    valorCambio = entry.getValue();
                    break;
                }
            }

        return valorCambio;
    }

    public void convertir(String monedaBase, String monedaCambio) throws IOException, InterruptedException{
        try{
            obtenerCambio(monedaBase,monedaCambio);
            Double valor = 0.0;
            System.out.println("Ingrese el valor que deseas convertir: ");
            valor = scanner.nextDouble();
            System.out.println( "El valor "+valor+"["+monedaBase+"]"+" corresponde al valor final de -->> "+valor * valorCambio+"["+monedaCambio+"]\n\n");
        }catch(InputMismatchException e){
            System.out.println("No se reconoce la entrada, ingrese un valor numerico");
            scanner.nextLine();
        }catch (NullPointerException e){
            System.out.println("No se pudo obtener la conversion para: "+monedaBase);
        }catch (Exception e){
            System.out.println("Ocurrio un error inesperado! "+e.getMessage());
        }
    }
}
