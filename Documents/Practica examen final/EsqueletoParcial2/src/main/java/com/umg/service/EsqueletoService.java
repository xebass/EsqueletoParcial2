/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.service;

import com.umg.model.EsqueletoModel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EsqueletoService {

    private static final String API_URL = "https://rest-umg-2026-teqcru.onrender.com/api/libros";
    private final HttpClient client = HttpClient.newHttpClient();

    // 1. GET: Obtener todos los registros
    public List<EsqueletoModel> obtenerEsqueletoModel() throws Exception {
        // PASO 1: HttpRequest.newBuilder().uri(URI.create(API_URL)).header("Accept", "application/json").GET().build();
        // PASO 2: HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // PASO 3: Validar (response.statusCode() == 200) -> retornar parsearListaBaseModel(response.body());
        return new ArrayList<>();
    }

    // 2. POST: Guardar registro (/create)
    public boolean guardarBaseModel(EsqueletoModel libro) throws Exception {
        // PASO 1: String json = modeloToJson(libro);
        // PASO 2: HttpRequest.newBuilder().uri(URI.create(API_URL + "/create")).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
        // PASO 3: HttpResponse<String> response = client.send(request, ...);
        // PASO 4: Retornar (response.statusCode() == 200 || 201);
        return false;
    }

    // 3. PUT: Actualizar registro (/update/:id)
    public boolean actualizarBaseModel(int id, EsqueletoModel libro) throws Exception {
        // PASO 1: String json = modeloToJson(libro);
        // PASO 2: HttpRequest.newBuilder().uri(URI.create(API_URL + "/update/" + id)).header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(json)).build();
        // PASO 3: HttpResponse<String> response = client.send(request, ...);
        // PASO 4: Retornar (response.statusCode() == 200 || 204);
        return false;
    }

    // 4. DELETE: Eliminar registro (/delete/:id)
    public boolean eliminarBaseModel(int id) throws Exception {
        // PASO 1: HttpRequest.newBuilder().uri(URI.create(API_URL + "/delete/" + id)).DELETE().build();
        // PASO 2: HttpResponse<String> response = client.send(request, ...);
        // PASO 3: Retornar (response.statusCode() == 200 || 204);
        return false;
    }

    // =========================================================================
    // AUXILIARES PARSEO JSON NATIVo
    // =========================================================================

    private String modeloToJson(EsqueletoModel libro) {
        // TODO: String.format con formato JSON {"titulo":"%s", ...}
        return "";
    }

    private List<EsqueletoModel> parsearListaBaseModel(String json) {
        // TODO: Iterar objetos con Matcher de regex para armar la List<BaseModel>
        return new ArrayList<>();
    }
}