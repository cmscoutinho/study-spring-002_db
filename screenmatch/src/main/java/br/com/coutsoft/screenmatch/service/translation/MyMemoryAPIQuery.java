package br.com.coutsoft.screenmatch.service.translation;

import br.com.coutsoft.screenmatch.service.APIConsumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;

public class MyMemoryAPIQuery {
    public static String getTranslation(String text) {
        ObjectMapper mapper = new ObjectMapper();

        MyMemoryAPIConsumer consumer = new MyMemoryAPIConsumer();

        String json = consumer.consume(text);

        TranslationData translation;
        try {
            translation = mapper.readValue(json, TranslationData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return translation.responseData().translatedText();
    }
}
