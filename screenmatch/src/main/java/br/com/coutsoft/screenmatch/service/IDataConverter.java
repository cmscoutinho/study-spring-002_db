package br.com.coutsoft.screenmatch.service;

public interface IDataConverter {

    public <T> T getData(String json, Class<T> TClass);

}
