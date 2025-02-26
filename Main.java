package com.example;

import java.util.concurrent.CompletableFuture;


public class Main {
    public static void main(String[] args) {
        TestCDCConsumer cdc = new TestCDCConsumer();
        CompletableFuture<String> message = cdc.CDCBuilder();
        System.out.print(message);
   }
}
