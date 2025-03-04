package com.example;

import java.util.concurrent.CompletableFuture;

import org.apache.pulsar.client.api.PulsarClientException;

//import org.apache.pulsar.shade.org.apache.avro.data.Json;


public class Main {
    public static void main(String[] args) throws PulsarClientException {
        
        TestCDCConsumer cdc = new TestCDCConsumer();
        CompletableFuture<String> message = cdc.CDCBuilder();
        //System.out.print(message);

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
