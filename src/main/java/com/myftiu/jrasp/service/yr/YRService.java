package com.myftiu.jrasp.service.yr;

import com.myftiu.jrasp.HelloController;
import com.myftiu.jrasp.model.yr.Time;
import com.myftiu.jrasp.model.yr.Weatherdata;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author by ali myftiu on 28/12/15.
 */
public class YRService extends ScheduledService<Void> {

    private final FXMLLoader loader;

    private static final Logger LOGGER = LoggerFactory.getLogger(YRService.class);

    public YRService(FXMLLoader loader) {
        this.loader = loader;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                final Weatherdata weatherdata = findData();
                final HelloController helloController = loader.getController();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                LocalDateTime sunrise = LocalDateTime.parse(weatherdata.getSun().getRise(), formatter);
                LocalDateTime sunset = LocalDateTime.parse(weatherdata.getSun().getSet(), formatter);
                //Setting metadata
                helloController.getCityId().setText("Stockholm " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                helloController.getSunText().setText(sunrise.getHour() + ":" + sunrise.getMinute() + " - " + sunset.getHour() + ":" + sunrise.getMinute() );
                final List<Time> dailyForecast = weatherdata.getForecast().getTabular().getTime().subList(0, 4);
                final GridPane forecastGrid = helloController.getForecast();

                updateText(dailyForecast, forecastGrid);

                return null;
            }
        };
    }

    private void updateText(List<Time> dailyForecast, GridPane forecastGrid) {
        LOGGER.info("Calling runnable of Forecast");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                int j = 0;
                LOGGER.info("Updating daily forecast");
                for(Time forecastTime: dailyForecast) {
                    String url_path;
                    if(forecastTime.getSymbol().getVar().contains("/")) {
                        String[] path = forecastTime.getSymbol().getVar().split("/");
                        url_path = path[1];
                    } else {
                        url_path = forecastTime.getSymbol().getVar();
                    }
                    final String url = "/images/icons/"+ url_path + ".png";
                    final Image image = new Image(getClass().getResourceAsStream(url));
                    final ImageView imageView = new ImageView(image);
                    final LocalDateTime from_period = LocalDateTime.parse(forecastTime.getFrom(), formatter);
                    final LocalDateTime to_period = LocalDateTime.parse(forecastTime.getTo(), formatter);
                    Node period = new Label(from_period.format(DateTimeFormatter.ofPattern("HH:mm")) + " " + to_period.format(DateTimeFormatter.ofPattern("HH:mm")));
                    forecastGrid.add(imageView, 0, j);
                    forecastGrid.add(period, 1, j++);
                    Node temp = new Label(forecastTime.getTemperature().getValue().toString() + "ºC " + forecastTime.getSymbol().getName());
                    forecastGrid.add(temp, 1 ,j++);
                }
            }
        });

    }


    private Weatherdata findData() throws IOException, XMLStreamException, JAXBException {
        YRClient yrClient = new YRClient();
        Document doc = yrClient.getLocationForecast();
        JAXBContext jaxbContext = JAXBContext.newInstance(Weatherdata.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Weatherdata customer = (Weatherdata) jaxbUnmarshaller.unmarshal(doc);
        return customer;
    }

}
