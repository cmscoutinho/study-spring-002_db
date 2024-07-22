package br.com.coutsoft.screenmatch.service.translation;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyMemoryAPIConsumer {

    private final String BASE_URL = "https://api.mymemory.translated.net/get?q=";
    private final String LANG_PAIR = URLEncoder.encode("en|pt-br");

    public String consume(String entry) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(BASE_URL + URLEncoder.encode(entry) + "&langpair=" + LANG_PAIR)).
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

