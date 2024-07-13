package br.com.coutsoft.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter {

    ObjectMapper mapper = new ObjectMapper();

    public <T> T convert(String json, Class<T> TClass) {
        try {
            return mapper.readValue(json, TClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
