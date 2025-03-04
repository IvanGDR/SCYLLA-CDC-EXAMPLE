package com.example;

import java.util.concurrent.CompletableFuture;

import org.apache.pulsar.client.api.PulsarClientException;


public class Main {
    public static void main(String[] args) throws PulsarClientException {

        TestCDCConsumer cdc = new TestCDCConsumer();
        CompletableFuture<String> message = cdc.CDCBuilder();

        System.out.print("in Main Method" + message);

        //while message is not null
        while (true) {
            if (message != null) {
                PulsarProducer producer = new PulsarProducer();
                System.out.println("Producing" + message);
                producer.send(message);
            }
        }
    }
}
