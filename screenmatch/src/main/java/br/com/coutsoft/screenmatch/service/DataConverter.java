package br.com.coutsoft.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DataConverter implements IDataConverter {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> TClass) {
        try {
            return mapper.readValue(json, TClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> TClass) {
        try {
            var type = mapper.getTypeFactory().constructCollectionType(List.class, TClass);
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
