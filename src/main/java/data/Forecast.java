
package data;

import data.Description;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author timon_kaufmann
 */
public class Forecast {
    private int dt;
    private String dt_txt;
    private Weather main;
    private Description[] weather;
    
    private static DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Forecast(int dt, String dt_txt, Weather main, Description[] weather) {
        this.dt = dt;
        this.dt_txt = dt_txt;
        this.main = main;
        this.weather = weather;
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.parse(dt_txt, dtf);
    }

    public int getDt() {
        return dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public Weather getMain() {
        return main;
    }

    public Description[] getWeather() {
        return weather;
    }
    
    
}
