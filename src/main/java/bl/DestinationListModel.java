package bl;

import data.Forecast;
import data.Destination;
import bl.sorting.SortH;
import bl.sorting.SortP;
import bl.sorting.SortT;
import net.OpenWeather;
import net.XML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import org.jdom2.JDOMException;

/**
 * 
 * @author timon_kaufmann
 */
public class DestinationListModel extends AbstractListModel<Destination> {

    private LinkedList<Destination> destinations = new LinkedList<>();

    public void add(Destination dest) {
        this.destinations.add(dest);
        this.fireIntervalAdded(this, destinations.size() - 1, destinations.size() - 1);
    }

    public void add(String destName) {
        OpenWeather access = OpenWeather.getInstance();
        Destination dest = access.getWeather(destName);
        this.add(dest);
    }
    
    public void addAll(List<String> destNames) {
        for (String destName : destNames) {
            this.add(destName);
        }
    }

    public void remove(int[] indexArray) {
        for (int i = indexArray.length - 1; i >= 0; i = (i - (int) Math.pow(i, 0))) {
            destinations.remove(indexArray[i]);
        }
        this.fireContentsChanged(this, 0, destinations.size() - 1);
    }

    @Override
    public int getSize() {
        return destinations.size();
    }

    @Override
    public Destination getElementAt(int index) {
        return destinations.get(index);
    }

    public LinkedList<Destination> getDestinations() {
        return destinations;
    }

    public void sortByTemperature() {
        Collections.sort(destinations, new SortT());
        this.fireContentsChanged(this, 0, destinations.size() - 1);
    }

    public void sortByPressure() {
        Collections.sort(destinations, new SortP());
        this.fireContentsChanged(this, 0, destinations.size() - 1);
    }

    public void sortByHumidity() {
        Collections.sort(destinations, new SortH());
        this.fireContentsChanged(this, 0, destinations.size() - 1);
    }

    public void saveDestinations() throws JDOMException, IOException {
        XML xmla = XML.getInstance();
        xmla.persistXML(destinations);
    }
    
    public void loadDestinations() throws JDOMException, IOException {
        XML xmla = XML.getInstance();
        this.addAll(xmla.loadFromXML());
    }
    
    public List<Forecast> getForecastOfDay(String day, int idx) {
        ArrayList<Forecast> forecasts = new ArrayList<>();
        for (Forecast forecast : destinations.get(idx).getList()) {
            if(forecast.getDt_txt().contains(day)) {
                forecasts.add(forecast);
            }
        }
        return forecasts;
    }

}
