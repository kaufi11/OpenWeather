package net;

import data.Destination;
import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author timon_kaufmann
 */
public class OpenWeather {

    private static OpenWeather theInstance;
    
    private Gson gson;

    private static String URI = "https://api.openweathermap.org/data/2.5/";
    private static String PATH = "forecast";
    private static String APPID = "c8eb9bb61ff3c0317dbfc135f1db91be";

    private Client client;

    public OpenWeather() {
        this.client = ClientBuilder.newClient();
        this.gson = new Gson();
    }

    public static synchronized OpenWeather getInstance() {
        if (theInstance == null) {
            theInstance = new OpenWeather();
        }
        return theInstance;
    }

    public Destination getWeather(String cityName) {
        Response res = client.target(URI)
                .path(PATH)
                .queryParam("APPID", APPID)
                .queryParam("q", cityName)
                .request(MediaType.APPLICATION_JSON)
                .get();
        
        Destination dest = gson.fromJson(res.readEntity(String.class), Destination.class);
        
        dest.createDayForecasts();
        

        return dest;
    }
}
