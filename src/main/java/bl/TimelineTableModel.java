/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import data.Forecast;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author timon_kaufmann
 */
public class TimelineTableModel extends AbstractTableModel{

    private ArrayList<Forecast> forecasts = new ArrayList<>();
    private ArrayList<String> colNames = new ArrayList<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    
    public void update(List<Forecast> forecasts) {
        this.forecasts.clear();
        this.colNames.clear();
        this.forecasts.addAll(forecasts);
        for (Forecast forecast : forecasts) {
            colNames.add(forecast.getDateTime().format(dtf));
        }
        this.fireTableDataChanged();
        this.fireTableStructureChanged();
    }
    
    @Override
    public int getRowCount() {
        if(forecasts == null) return 0;
        return 2;
    }

    @Override
    public int getColumnCount() {
        if(colNames.size() == 0) {
            return 0;
        }
        return colNames.size();
    }

    @Override
    public String getColumnName(int column) {
        if(colNames.size() == 0) {
            return "test";
        }
        return colNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(colNames.size() > 0) {
            return forecasts.get(columnIndex);
        }
        return 1f;
    }
    
}
