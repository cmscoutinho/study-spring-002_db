package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.model.SeriesData;
import br.com.coutsoft.screenmatch.service.APIConsumer;
import br.com.coutsoft.screenmatch.service.DataConverter;

public class Main {
    public static void main(String[] args) {
        APIConsumer consumer = new APIConsumer();
        DataConverter converter = new DataConverter();
        System.out.println(converter.convert(consumer.consume("friends"), SeriesData.class));
    }
}
