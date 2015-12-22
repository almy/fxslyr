package com.myftiu.jrasp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myftiu.jrasp.model.Departures;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

/**
 * @author by ali myftiu on 22/12/15.
 */
public class SLService extends ScheduledService<Void> {

    private BlockingQueue<Departures> departuresBlockingQueue;
    private static final String SL_URL = "http://sl.se/api/sv/RealTime/GetDepartures/1302";
    private static final String SOFIA = "Sofia";


    public SLService(BlockingQueue<Departures> departuresBlockingQueue) {
        this.departuresBlockingQueue = departuresBlockingQueue;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // empty previous queue
                departuresBlockingQueue.clear();
                final List<Departures> departuresList = fetchDepatures();
                departuresList.forEach(departures -> departuresBlockingQueue.add(departures));
                departuresBlockingQueue.notify();
                return null;
            }
        };

    }


    private List<Departures> fetchDepatures() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        final Response slResponse = client.target(SL_URL).request(MediaType.APPLICATION_JSON_TYPE).get();
        String responseString = slResponse.readEntity(String.class);
        final List<Departures> list = objectMapper.readValue(responseString, new TypeReference<List<Departures>>() {});
        return list.stream().filter(d -> !d.getDestination().equalsIgnoreCase(SOFIA)).collect(Collectors.toList());
    }
}
