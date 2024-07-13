package br.com.coutsoft.screenmatch.main;

import br.com.coutsoft.screenmatch.service.APIConsumer;

public class Main {
    public static void main(String[] args) {
        APIConsumer consumer = new APIConsumer();
        System.out.println(consumer.consume("friends"));
    }
}
