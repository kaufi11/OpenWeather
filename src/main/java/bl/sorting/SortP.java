
package bl.sorting;

import data.Destination;
import java.util.Comparator;

/**
 * 
 * @author timon_kaufmann
 */
public class SortP implements Comparator<Destination>{

    @Override
    public int compare(Destination d1, Destination d2) {
        if(d1.getList()[0].getMain().getPressure()> d2.getList()[0].getMain().getPressure())
            return 1;
        if(d1.getList()[0].getMain().getPressure()< d2.getList()[0].getMain().getPressure())
            return -1;
        return 0;
    }
}
