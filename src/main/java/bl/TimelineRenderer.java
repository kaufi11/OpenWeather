/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import data.Forecast;
import net.Icons;
import java.awt.Component;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @author timon_kaufmann
 */
public class TimelineRenderer implements TableCellRenderer {

    private Icons iconAccess;

    public TimelineRenderer() throws IOException {
        iconAccess = Icons.getInstance();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Forecast forecast = (Forecast) value;
        
        if (row == 0) {
            label.setText(String.format("%.2f°C", forecast.getMain().getTemp()));
            return label;
        }

        String icon = forecast.getWeather()[0].getIcon();
        switch(icon) {
            // day icons
            case "01d":
                label.setIcon(iconAccess.getIconsDay().get(0));
                break;
            case "02d":
                label.setIcon(iconAccess.getIconsDay().get(1));
                break;
            case "03d":
                label.setIcon(iconAccess.getIconsDay().get(2));
                break;
            case "04d":
                label.setIcon(iconAccess.getIconsDay().get(3));
                break;
            case "09d":
                label.setIcon(iconAccess.getIconsDay().get(4));
                break;
            case "10d":
                label.setIcon(iconAccess.getIconsDay().get(5));
                break;
            case "11d":
                label.setIcon(iconAccess.getIconsDay().get(6));
                break;
            case "13d":
                label.setIcon(iconAccess.getIconsDay().get(7));
                break;
            case "50d":
                label.setIcon(iconAccess.getIconsDay().get(8));
                break;
            // night icons
            case "01n":
                label.setIcon(iconAccess.getIconsNight().get(0));
                break;
            case "02n":
                label.setIcon(iconAccess.getIconsNight().get(1));
                break;
            case "03n":
                label.setIcon(iconAccess.getIconsNight().get(2));
                break;
            case "04n":
                label.setIcon(iconAccess.getIconsNight().get(3));
                break;
            case "09n":
                label.setIcon(iconAccess.getIconsNight().get(4));
                break;
            case "10n":
                label.setIcon(iconAccess.getIconsNight().get(5));
                break;
            case "11n":
                label.setIcon(iconAccess.getIconsNight().get(6));
                break;
            case "13n":
                label.setIcon(iconAccess.getIconsNight().get(7));
                break;
            case "50n":
                label.setIcon(iconAccess.getIconsNight().get(8));
                break;
        }
        return label;
    }

}
