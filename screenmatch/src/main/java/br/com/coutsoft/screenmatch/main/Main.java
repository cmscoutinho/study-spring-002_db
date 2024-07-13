package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.model.SeasonData;
import br.com.coutsoft.screenmatch.model.SeriesData;
import br.com.coutsoft.screenmatch.service.APIConsumer;
import br.com.coutsoft.screenmatch.service.DataConverter;

public class Main {

        private APIConsumer consumer = new APIConsumer();
        private DataConverter converter = new DataConverter();
    public void main() {

        String entry = "friends&season=2";
        String json = consumer.consume(entry);
        System.out.println(converter.getData(json, SeasonData.class));
    }
}
