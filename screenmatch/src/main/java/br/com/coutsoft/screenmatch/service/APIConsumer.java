package br.com.coutsoft.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumer {

    private final String BASE_URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=337e4e55";

    public String consume(String entry) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(BASE_URL + entry.replace(" ", "+") + API_KEY)).
                build();

        String json = "";
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body().toString();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return json;
    }
}
