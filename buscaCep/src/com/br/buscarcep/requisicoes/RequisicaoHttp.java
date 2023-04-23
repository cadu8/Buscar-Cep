package com.br.buscarcep.requisicoes;

import com.br.buscarcep.modelo.CepRecord;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoHttp {
    public CepRecord requisicao(String cep) throws IOException, InterruptedException {
        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        URI endereco = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), CepRecord.class);

    }

    public String requisicaoJson(String cep) throws IOException, InterruptedException {
        URI endereco = URI.create("http://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
