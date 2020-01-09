/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 
 * @author timon_kaufmann
 */
public class Icons {
    private static Icons theInstance;
    private LinkedList<ImageIcon> iconsDay;
    private LinkedList<ImageIcon> iconsNight;

    public Icons() throws MalformedURLException, IOException {
        iconsDay = new LinkedList<>();
        iconsNight = new LinkedList<>();
        BufferedImage img;
        for(int i = 1; i < 5; i++) {
            img = ImageIO.read(new URL("http://openweathermap.org/img/wn/0"+i+"d@2x.png"));
            iconsDay.add(new ImageIcon(img));
            img = ImageIO.read(new URL("http://openweathermap.org/img/wn/0"+i+"n@2x.png"));
            iconsNight.add(new ImageIcon(img));
        }
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/09d@2x.png"));
        iconsDay.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/09n@2x.png"));
        iconsNight.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/10d@2x.png"));
        iconsDay.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/10n@2x.png"));
        iconsNight.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/11d@2x.png"));
        iconsDay.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/11n@2x.png"));
        iconsNight.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/13d@2x.png"));
        iconsDay.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/13n@2x.png"));
        iconsNight.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/50d@2x.png"));
        iconsDay.add(new ImageIcon(img));
        img = ImageIO.read(new URL("http://openweathermap.org/img/wn/50n@2x.png"));
        iconsNight.add(new ImageIcon(img));
    }
    
    public static synchronized Icons getInstance() throws IOException {
        if(theInstance == null) {
            theInstance = new Icons();
        }
        return theInstance;
    }

    public LinkedList<ImageIcon> getIconsDay() {
        return iconsDay;
    }

    public LinkedList<ImageIcon> getIconsNight() {
        return iconsNight;
    }
}
