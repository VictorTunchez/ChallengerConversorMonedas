package com.conversormonedas.repo;

import com.conversormonedas.modelos.Conversiones;
import com.conversormonedas.modelos.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObtenerConversiones {

    public void obtenerConversion(String monedaBase) throws IOException, InterruptedException {
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
            System.out.println("Moneda: " + entry.getKey() + " - Valor: " + entry.getValue());
        }
    }
}
