package com.example;

import org.apache.pulsar.client.api.PulsarClient;

import java.util.concurrent.CompletableFuture;

import org.apache.pulsar.client.api.Producer;
//import org.apache.pulsar.client.api.ProducerBuilder;
import org.apache.pulsar.client.api.Schema;
//import org.apache.pulsar.common.schema.SchemaType;
//import org.json.JSONObject;
import org.apache.pulsar.client.api.PulsarClientException;

//import java.util.concurrent.TimeUnit;


public class PulsarProducer{

        public void send (CompletableFuture<String> message) throws PulsarClientException {

        // Step 1: Create a Pulsar client
        String serviceUrl = "pulsar://localhost:6650";
        PulsarClient client = PulsarClient.builder()
                .serviceUrl(serviceUrl)
                .build();

        // Step 2: Create a producer
        String topicName = "persistent://public/test-ns/test-topic";
        Producer<PulsarJsonSchema> producer = client.newProducer(Schema.JSON(PulsarJsonSchema.class))
                .topic(topicName)
                .create();

        // Create an instance of your JSON class
        //CompletableFuture<String> message = null;
        PulsarJsonSchema myJson = new PulsarJsonSchema();
        JsonConvert value = new JsonConvert();
        myJson.setSensorID(value.getSensorIdValue(message));
        myJson.setCoordinate(value.getCoordinateValue(message));
        myJson.setStatus(value.getStatusValue(message));

        // Send the message
        producer.newMessage().value(myJson).send();

        // Close the producer and client
        producer.close();
        client.close();
        }
}

