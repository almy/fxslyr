package com.myftiu.jrasp.service;

import org.glassfish.jersey.client.ClientConfig;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;

/**
 * Service class for interacting with yr.no. Uses the SimpleHttpClient to make HTTP GET
 * requests.
 *
 * @author Samuel Nilsson
 */
public class YrClient {

   private static String YR_API_URL = "http://www.yr.no/place/Sweden/Stockholm/Stockholm/forecast.xml";


   /**
    * Will make a HTTP GET request to the YR.no API endpoint for getting location
    * forecasts and the parse the response as XML.
    *
    * @param latitude
    * @param longitude
    * @param altitude
    * @return XML document with response data
    */
   public Document getLocationForecast(String latitude, String longitude, String altitude) {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder;
      Document doc;
      String data = "";

      try {
         dBuilder = dbFactory.newDocumentBuilder();
      } catch (ParserConfigurationException e) {
         throw new RuntimeException("Something has gone terribly wrong.");
      }

      try {
          ClientConfig clientConfig = new ClientConfig();
          Client client = ClientBuilder.newClient(clientConfig);

         final WebTarget target = client.target(YR_API_URL);
         doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(data.getBytes("utf-8"))));
      } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException("Failed to load data!");
      }

      return doc;
   }
}