
package data;

/**
 * 
 * @author timon_kaufmann
 */
public class Weather {
    private float temp;
    private float temp_min;
    private float temp_max;
    private int pressure;
    private int humidity;

    public Weather(float temp, float temp_min, float temp_max, int pressure, int humidity) {
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp-273.15f;
    }

    public float getTemp_min() {
        return temp_min-273.15f;
    }

    public float getTemp_max() {
        return temp_max-273.15f;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
    
    
}
