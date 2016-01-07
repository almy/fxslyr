package com.myftiu.jrasp.service.sl;

import com.google.gson.Gson;
import com.myftiu.jrasp.HelloController;
import com.myftiu.jrasp.model.sl.Departures;
import com.myftiu.jrasp.model.sl.SLInfo;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
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
    private final FXMLLoader loader;
    private static final Logger LOGGER = LoggerFactory.getLogger(SLService.class);


    public SLService(BlockingQueue<Departures> departuresBlockingQueue, FXMLLoader loader) {
        this.departuresBlockingQueue = departuresBlockingQueue;
        this.loader = loader;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // empty previous queue
                synchronized (departuresBlockingQueue) {
                    departuresBlockingQueue.clear();
                    final List<Departures> departuresList = fetchDepatures();
                    departuresList.forEach(departures -> departuresBlockingQueue.add(departures));
                    LOGGER.info("Calling runable");
                    updateText();
                }
                return null;
            }
        };

    }

    private void updateText() {
        LOGGER.info("Calling runnable of SLService");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("Updating new timetable of the busses");
                final HelloController helloController = loader.getController();
                final ListView busTable = helloController.getBusTable();
                final ObservableList<String> slBuses = FXCollections.observableArrayList();
                for (Departures departure : departuresBlockingQueue) {
                    slBuses.add(String.format("Autobuzi %s:  %s", departure.getLineNumber(), departure.getDisplayTime()));
                }
                busTable.setItems(slBuses);
            }
        });

    }

    private List<Departures> fetchDepatures() throws IOException {

        LOGGER.info("Calling fetchDepatures");
        final Gson gSon = new Gson();
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        final Response slResponse = client.target(SL_URL).request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);
        String responseString = slResponse.readEntity(String.class);
        SLInfo data = gSon.fromJson(responseString, SLInfo.class);
        final List<Departures> departuresList = data.getData().getBusGroups().get(0).getDepartures();
        return departuresList.stream().filter(d -> !d.getDestination().equalsIgnoreCase(SOFIA)).limit(5).collect(Collectors.toList());
    }
}
