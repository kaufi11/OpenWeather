
package main;


import gui.OpenWeatherGUI;

/**
 * 
 * @author timon_kaufmann
 */
public class Main {
    public static void main(String[] args) {
        try {
            OpenWeatherGUI gui = new OpenWeatherGUI();
            gui.setVisible(true);
        } catch (Exception ex) {
            System.err.println("Fehler");
        }
    }
}
