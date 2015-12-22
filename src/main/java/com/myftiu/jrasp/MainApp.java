package com.myftiu.jrasp;

import com.myftiu.jrasp.model.Departures;
import com.myftiu.jrasp.service.SLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainApp extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private BlockingQueue<Departures> departuresBlockingQueue = new LinkedBlockingQueue<>();
    private SLService slService;

    final Lock lock = new ReentrantLock();
    final Condition consume  = lock.newCondition();


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        startWorkers();
        test();

        LOGGER.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/hello.fxml";
        LOGGER.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        LOGGER.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 400, 200);
        scene.getStylesheets().add("/styles/styles.css");

        //stage.setFullScreen(true);
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();

    }

    private void startWorkers() {
        slService = new SLService(departuresBlockingQueue);
        slService.setExecutor(executorService);
        slService.setPeriod(Duration.minutes(1));
        slService.start();

    }

    private void test() throws InterruptedException {
        while (true) {
            synchronized (departuresBlockingQueue) {
                departuresBlockingQueue.wait();
            }
            LOGGER.info("Size of the queue is {}", departuresBlockingQueue.size());
            lock.unlock();
        }
    }
}
