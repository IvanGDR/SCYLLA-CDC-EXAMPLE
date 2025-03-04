package com.example;

import java.util.concurrent.CompletableFuture;
import org.json.JSONObject;

//import io.netty.util.concurrent.CompleteFuture;



public class JsonConvert {

    /*

    TestCDCConsumer cdc = new TestCDCConsumer();
    CompletableFuture<String> message = cdc.CDCBuilder();
    //String jsonString = message.toString();
    //JSONObject jsonObject = new JSONObject(jsonString);
    */

    public String getSensorIdValue(CompletableFuture<String> message) {
        String jsonString = message.toString();
        JSONObject jsonObject = new JSONObject(jsonString);
        String sensor_id = jsonObject.getString("sensor_id");
        //System.out.print(sensor_id);
        return sensor_id;
    }

    public int getCoordinateValue(CompletableFuture<String> message) {
        String jsonString = message.toString();
        JSONObject jsonObject = new JSONObject(jsonString);
        int coordinate = jsonObject.getInt("coordinate");
        //System.out.print(coordinate);
        return coordinate;
    }

    public String getStatusValue(CompletableFuture<String> message) {
        String jsonString = message.toString();
        JSONObject jsonObject = new JSONObject(jsonString);
        String status = jsonObject.getString("status");
        //System.out.print(status);
        return status;
    }

    /*
    public String getStatusValue() {
        String status = jsonObject.getString("status");
        //System.out.print(status);
        return status;
    }
    */
}
