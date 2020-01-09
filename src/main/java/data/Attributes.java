
package data;

/**
 * 
 * @author timon_kaufmann
 */
public class Attributes {
    private float temp;
    private int pressure;
    private int humidity;

    public Attributes() {
    }

    public Attributes(float temp, int pressure, int humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
    
    
}
