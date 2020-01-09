
package data;

import data.City;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author timon_kaufmann
 */

public class Destination {
    private City city;
    private Forecast[] list;
    private LinkedList<Forecast> dayForecasts;
    

    public Destination(City city, Forecast[] list) {
        this.city = city;
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public Forecast[] getList() {
        return list;
    }
    
    @Override
    public String toString() {
        return city.getName();
    }

    public List<Forecast> getDayForecasts() {
        return dayForecasts;
    }
    /**
     * Bei der Vorhersage der Nächsten 5 Tage bekam ich Hilfe von Julian Heil
     */
    public void createDayForecasts() {
        this.dayForecasts = new LinkedList<>();
        int idx = 0;
        String[] days = new String[6];
        for (Forecast forecast : list) {
            if (idx == 0) {
                days[idx] = forecast.getDt_txt().substring(0, 10);
                idx++;
            } else {
                if (!days[idx - 1].equals(forecast.getDt_txt().substring(0, 10))) {
                    days[idx] = forecast.getDt_txt().substring(0, 10);
                    idx++;
                }
            }
        }
        for(idx = 0; idx < days.length; idx++) {
            this.dayForecasts.add(this.getDayForecast(days[idx]));
        }
    }
    
    public Forecast getDayForecast(String day) {
        ArrayList<Forecast> filteredForecasts = new ArrayList<>();
        for (Forecast forecast : list) {
            if(forecast.getDt_txt().contains(day)) {
                if(Integer.parseInt(forecast.getDt_txt().substring(11, 13)) == 12) {
                    return forecast;
                }
                filteredForecasts.add(forecast);
            }
        }
        if(Integer.parseInt(filteredForecasts.get(0).getDt_txt().substring(11, 13))>12) {
            return filteredForecasts.get(0);
        }
        if(Integer.parseInt(filteredForecasts.get(filteredForecasts.size()-1).getDt_txt().substring(11, 13))<12) {
            return filteredForecasts.get(filteredForecasts.size()-1);
        }
        return null;
    }
    
    public List<Forecast> getForecastsOfDay(int day) {
        String date = this.dayForecasts.get(day).getDt_txt().substring(0,10);
        List<Forecast> forecasts = new ArrayList<>();
        for (Forecast forecast : list) {
            if(forecast.getDt_txt().contains(date)) {
                forecasts.add(forecast);
            }
        }
        return forecasts;
    }
}
