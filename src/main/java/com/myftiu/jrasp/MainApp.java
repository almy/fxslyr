package com.myftiu.jrasp;

import com.myftiu.jrasp.model.yr.Weatherdata;
import com.myftiu.jrasp.model.sl.Departures;
import com.myftiu.jrasp.service.yr.YRClient;
import com.myftiu.jrasp.service.sl.SLService;
import com.myftiu.jrasp.service.yr.YRService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainApp extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private BlockingQueue<Departures> departuresBlockingQueue = new LinkedBlockingQueue<>();
    private SLService slService;
    private YRService yrService;
    private final FXMLLoader loader = new FXMLLoader();
    private static String YR_API_URL = "http://www.yr.no/place/Sweden/Stockholm/Stockholm/forecast.xml";

    final Lock lock = new ReentrantLock();
    final Condition consume  = lock.newCondition();


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        startWorkers();

        LOGGER.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/hello.fxml";
        LOGGER.debug("Loading FXML for main view from: {}", fxmlFile);

        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        LOGGER.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 320, 240);
        scene.getStylesheets().add("/styles/styles.css");

        stage.initStyle(StageStyle.UNDECORATED);
        //stage.setFullScreen(true);
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();


    }

    private void startWorkers() {
        yrService = new YRService(loader);
        yrService.setExecutor(executorService);
        yrService.setPeriod(Duration.hours(24));
        yrService.start();

        slService = new SLService(departuresBlockingQueue, loader);
        slService.setExecutor(executorService);
        slService.setPeriod(Duration.minutes(1));
        slService.start();

    }


}
