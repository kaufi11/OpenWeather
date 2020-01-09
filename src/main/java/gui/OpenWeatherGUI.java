/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Destination;
import bl.DestinationListModel;
import data.Forecast;
import bl.TimelineRenderer;
import bl.TimelineTableModel;
import java.awt.Dimension;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.JDOMException;

/**
 * 
 * @author timon_kaufmann
 */
public class OpenWeatherGUI extends javax.swing.JFrame {

    private DestinationListModel dlm;
    private TimelineTableModel ttm;
    private TimelineRenderer renderer;

    private int selectedDay;

    private DateTimeFormatter dtf;

    /**
     * Creates new form WeatherGUI
     */
    public OpenWeatherGUI() {
        initComponents();
        this.setResizable(true);
        dtf = DateTimeFormatter.ofPattern("dd.MM");
        dlm = new DestinationListModel();
        ttm = new TimelineTableModel();
        try {
            renderer = new TimelineRenderer();
        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectedDay = 0;
        btDay0.setEnabled(false);
        listDestinations.setModel(dlm);
        tableTimeline.setRowHeight(50);
        tableTimeline.setModel(ttm);
        tableTimeline.setDefaultRenderer(Object.class, renderer);
        try {
            dlm.loadDestinations();
        } catch (JDOMException ex) {
            System.err.println("Fehler");
        } catch (IOException ex) {
            System.err.println("Fehler");
        }
    }

    public void updateDataDisplay(Destination dest) {
        if (listDestinations.getSelectedValue() != null) {
            tfDateTime.setText(dest.getDayForecasts().get(selectedDay).getDt_txt());
            tfTemp.setText(String.format("%.2f°C", dest.getDayForecasts().get(selectedDay).getMain().getTemp()));
            tfTempMin.setText(String.format("%.2f°C", dest.getDayForecasts().get(selectedDay).getMain().getTemp_min()));
            tfTempMax.setText(String.format("%.2f°C", dest.getDayForecasts().get(selectedDay).getMain().getTemp_max()));
            tfPressure.setText(dest.getDayForecasts().get(selectedDay).getMain().getPressure() + "");
            tfHumidity.setText(dest.getDayForecasts().get(selectedDay).getMain().getHumidity() + "%");
            this.updateDayChooser(dest);
            ttm.update(dest.getForecastsOfDay(this.selectedDay));
        } else {
            this.resetDataDisplay();
        }
        repaint();
    }
    
    public void updateDayChooser(Destination dest) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eee");
        int idx = 0;
        for (Forecast forecast : dest.getDayForecasts()) {
            switch(idx) {
                case 0:
                    btDay0.setText("Heute");
                    break;
                case 1:
                    btDay1.setText(forecast.getDateTime().format(dtf));
                    break;
                case 2:
                    btDay2.setText(forecast.getDateTime().format(dtf));
                    break;
                case 3:
                    btDay3.setText(forecast.getDateTime().format(dtf));
                    break;
                case 4:
                    btDay4.setText(forecast.getDateTime().format(dtf));
                    break;
                case 5:
                    btDay5.setText(forecast.getDateTime().format(dtf));
                    break;
            }
            idx++;
        }
    }

    public void updateDayChooserEnable() {
        btDay0.setEnabled(true);
        btDay1.setEnabled(true);
        btDay2.setEnabled(true);
        btDay3.setEnabled(true);
        btDay4.setEnabled(true);
        btDay5.setEnabled(true);
        switch (this.selectedDay) {
            case 0:
                btDay0.setEnabled(false);
                break;
            case 1:
                btDay1.setEnabled(false);
                break;
            case 2:
                btDay2.setEnabled(false);
                break;
            case 3:
                btDay3.setEnabled(false);
                break;
            case 4:
                btDay4.setEnabled(false);
                break;
            case 5:
                btDay5.setEnabled(false);
                break;
        }
    }

    public void resetDataDisplay() {
        tfDateTime.setText("");
        tfTemp.setText("");
        tfTempMin.setText("");
        tfTempMax.setText("");
        tfPressure.setText("");
        tfHumidity.setText("");
    }

    public void saveDestinations() throws JDOMException, IOException {
        dlm.saveDestinations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDestinations = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDestinations = new javax.swing.JList<>();
        panelWeather = new javax.swing.JPanel();
        panelSelectedWeather = new javax.swing.JPanel();
        panelCurrentWeather = new javax.swing.JPanel();
        panelData = new javax.swing.JPanel();
        lbDateTime = new javax.swing.JLabel();
        tfDateTime = new javax.swing.JTextField();
        lbTemp = new javax.swing.JLabel();
        tfTemp = new javax.swing.JTextField();
        lbTempMin = new javax.swing.JLabel();
        tfTempMin = new javax.swing.JTextField();
        lbTempMax = new javax.swing.JLabel();
        tfTempMax = new javax.swing.JTextField();
        lbPressure = new javax.swing.JLabel();
        tfPressure = new javax.swing.JTextField();
        lbHumidity = new javax.swing.JLabel();
        tfHumidity = new javax.swing.JTextField();
        panelDayChooser = new javax.swing.JPanel();
        btDay0 = new javax.swing.JButton();
        btDay1 = new javax.swing.JButton();
        btDay2 = new javax.swing.JButton();
        btDay3 = new javax.swing.JButton();
        btDay4 = new javax.swing.JButton();
        btDay5 = new javax.swing.JButton();
        panelTimeline = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTimeline = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menuDestinations = new javax.swing.JMenu();
        miAddDestination = new javax.swing.JMenuItem();
        miRemove = new javax.swing.JMenuItem();
        miSortBy = new javax.swing.JMenu();
        miSortByTemp = new javax.swing.JMenuItem();
        miSortByPres = new javax.swing.JMenuItem();
        miSortByHum = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelDestinations.setLayout(new java.awt.GridLayout(1, 1));

        listDestinations.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDestinationsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listDestinations);

        panelDestinations.add(jScrollPane1);

        getContentPane().add(panelDestinations, java.awt.BorderLayout.WEST);

        panelWeather.setLayout(new java.awt.BorderLayout());

        panelSelectedWeather.setPreferredSize(new java.awt.Dimension(220, 160));
        panelSelectedWeather.setLayout(new java.awt.BorderLayout());

        panelCurrentWeather.setLayout(new java.awt.BorderLayout());

        panelData.setLayout(new java.awt.GridLayout(6, 2));

        lbDateTime.setText("Datum");
        panelData.add(lbDateTime);

        tfDateTime.setEditable(false);
        panelData.add(tfDateTime);

        lbTemp.setText("Temperatur");
        panelData.add(lbTemp);

        tfTemp.setEditable(false);
        panelData.add(tfTemp);

        lbTempMin.setText("Temperatur min");
        panelData.add(lbTempMin);

        tfTempMin.setEditable(false);
        panelData.add(tfTempMin);

        lbTempMax.setText("Temperatur max");
        panelData.add(lbTempMax);

        tfTempMax.setEditable(false);
        panelData.add(tfTempMax);

        lbPressure.setText("Druck");
        panelData.add(lbPressure);

        tfPressure.setEditable(false);
        panelData.add(tfPressure);

        lbHumidity.setText("Feuchtigkeit");
        panelData.add(lbHumidity);

        tfHumidity.setEditable(false);
        panelData.add(tfHumidity);

        panelCurrentWeather.add(panelData, java.awt.BorderLayout.CENTER);

        panelSelectedWeather.add(panelCurrentWeather, java.awt.BorderLayout.CENTER);

        panelDayChooser.setLayout(new java.awt.GridLayout(1, 6));

        btDay0.setText("Heute");
        btDay0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay0ActionPerformed(evt);
            }
        });
        panelDayChooser.add(btDay0);

        btDay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay1ActionPerformed(evt);
            }
        });
        panelDayChooser.add(btDay1);

        btDay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay2ActionPerformed(evt);
            }
        });
        panelDayChooser.add(btDay2);

        btDay3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay3ActionPerformed(evt);
            }
        });
        panelDayChooser.add(btDay3);

        btDay4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay4ActionPerformed(evt);
            }
        });
        panelDayChooser.add(btDay4);

        btDay5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay5ActionPerformed(evt);
            }
        });
        panelDayChooser.add(btDay5);

        panelSelectedWeather.add(panelDayChooser, java.awt.BorderLayout.SOUTH);

        panelWeather.add(panelSelectedWeather, java.awt.BorderLayout.CENTER);

        panelTimeline.setBorder(javax.swing.BorderFactory.createTitledBorder("Timeline"));
        panelTimeline.setLayout(new java.awt.GridLayout(1, 1));

        tableTimeline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableTimeline);

        panelTimeline.add(jScrollPane2);

        panelWeather.add(panelTimeline, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelWeather, java.awt.BorderLayout.CENTER);

        menuDestinations.setText("Orte");

        miAddDestination.setText("Hinzufügen");
        miAddDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddDestinationActionPerformed(evt);
            }
        });
        menuDestinations.add(miAddDestination);

        miRemove.setText("Entfernen");
        miRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoveActionPerformed(evt);
            }
        });
        menuDestinations.add(miRemove);

        miSortBy.setText("Sortieren");

        miSortByTemp.setText("Temperatur");
        miSortByTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortByTempActionPerformed(evt);
            }
        });
        miSortBy.add(miSortByTemp);

        miSortByPres.setText("Druck");
        miSortByPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortByPresActionPerformed(evt);
            }
        });
        miSortBy.add(miSortByPres);

        miSortByHum.setText("Feuchtigkeit");
        miSortByHum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortByHumActionPerformed(evt);
            }
        });
        miSortBy.add(miSortByHum);

        menuDestinations.add(miSortBy);

        menuBar.add(menuDestinations);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddDestinationActionPerformed
        DestinationGUI dialog = new DestinationGUI(this, true);
        dialog.setVisible(true);
        if (dialog.isOk()) {
            dlm.add((dialog.getDestinationName()));
        }
    }//GEN-LAST:event_miAddDestinationActionPerformed

    private void listDestinationsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDestinationsValueChanged
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_listDestinationsValueChanged

    private void miSortByTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortByTempActionPerformed
        if (listDestinations.getSelectedValue() != null) {
            dlm.sortByTemperature();
            listDestinations.setSelectedValue(null, false);
            this.updateDataDisplay(listDestinations.getSelectedValue());
        }
    }//GEN-LAST:event_miSortByTempActionPerformed

    private void miSortByPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortByPresActionPerformed
        if (listDestinations.getSelectedValue() != null) {
            dlm.sortByPressure();
            listDestinations.setSelectedValue(null, false);
            this.updateDataDisplay(listDestinations.getSelectedValue());
        }
    }//GEN-LAST:event_miSortByPresActionPerformed

    private void miSortByHumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortByHumActionPerformed
        if (listDestinations.getSelectedValue() != null) {
            dlm.sortByHumidity();
            listDestinations.setSelectedValue(null, false);
            this.updateDataDisplay(listDestinations.getSelectedValue());
        }
    }//GEN-LAST:event_miSortByHumActionPerformed

    private void miRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveActionPerformed
        if (listDestinations.getSelectedValue() != null) {
            int userAction = JOptionPane.showConfirmDialog(this, "Sind Sie sicher "
                    + "diesen Ort zu entfernen");
            if (userAction == JOptionPane.YES_OPTION) {
                dlm.remove(listDestinations.getSelectedIndices());
                this.updateDataDisplay(listDestinations.getSelectedValue());
            }
        }
    }//GEN-LAST:event_miRemoveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            this.saveDestinations();
        } catch (JDOMException ex) {
            Logger.getLogger(OpenWeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btDay0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay0ActionPerformed
        this.selectedDay = 0;
        this.updateDayChooserEnable();
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_btDay0ActionPerformed

    private void btDay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay1ActionPerformed
        this.selectedDay = 1;
        this.updateDayChooserEnable();
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_btDay1ActionPerformed

    private void btDay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay2ActionPerformed
        this.selectedDay = 2;
        this.updateDayChooserEnable();
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_btDay2ActionPerformed

    private void btDay3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay3ActionPerformed
        this.selectedDay = 3;
        this.updateDayChooserEnable();
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_btDay3ActionPerformed

    private void btDay4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay4ActionPerformed
        this.selectedDay = 4;
        this.updateDayChooserEnable();
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_btDay4ActionPerformed

    private void btDay5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay5ActionPerformed
        this.selectedDay = 5;
        this.updateDayChooserEnable();
        this.updateDataDisplay(listDestinations.getSelectedValue());
    }//GEN-LAST:event_btDay5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDay0;
    private javax.swing.JButton btDay1;
    private javax.swing.JButton btDay2;
    private javax.swing.JButton btDay3;
    private javax.swing.JButton btDay4;
    private javax.swing.JButton btDay5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDateTime;
    private javax.swing.JLabel lbHumidity;
    private javax.swing.JLabel lbPressure;
    private javax.swing.JLabel lbTemp;
    private javax.swing.JLabel lbTempMax;
    private javax.swing.JLabel lbTempMin;
    private javax.swing.JList<Destination> listDestinations;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuDestinations;
    private javax.swing.JMenuItem miAddDestination;
    private javax.swing.JMenuItem miRemove;
    private javax.swing.JMenu miSortBy;
    private javax.swing.JMenuItem miSortByHum;
    private javax.swing.JMenuItem miSortByPres;
    private javax.swing.JMenuItem miSortByTemp;
    private javax.swing.JPanel panelCurrentWeather;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelDayChooser;
    private javax.swing.JPanel panelDestinations;
    private javax.swing.JPanel panelSelectedWeather;
    private javax.swing.JPanel panelTimeline;
    private javax.swing.JPanel panelWeather;
    private javax.swing.JTable tableTimeline;
    private javax.swing.JTextField tfDateTime;
    private javax.swing.JTextField tfHumidity;
    private javax.swing.JTextField tfPressure;
    private javax.swing.JTextField tfTemp;
    private javax.swing.JTextField tfTempMax;
    private javax.swing.JTextField tfTempMin;
    // End of variables declaration//GEN-END:variables
}
