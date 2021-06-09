package ntou.cs.java2021.t4.gordon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Map;

public class WeatherViewer extends JFrame {
    boolean first = true;
    JComboBox<String> locationChooser;
    JComboBox<String> timeChooser;
    private JLabel cityLabel;
    private JLabel dateLabel;
    private JComboBox<String> cityJComboBox;
    private JComboBox<String> dateJComboBox;
    private String dates[];
    private JPanel menu;
    private DisplayPanel display;
    private String currentInfo = "";
    private String currentTemperature = "";
    private Map<String, TemperatureBundle> temperatureMap;


    public WeatherViewer() throws IndexOutOfBoundsException, IOException {
        super("Weather Viewer");

        TemperatureFetcher fetcher = new TemperatureFetcher();
        temperatureMap = fetcher.getTemperatureMap();
        this.setLayout(new BorderLayout());
        menu = new JPanel();
        menu.setLayout(new GridLayout(1, 4));
        locationChooser = new JComboBox<>(fetcher.getAllCities());

        // 取得單一城市的Bundle
        TemperatureBundle bundle = (TemperatureBundle) temperatureMap.get(locationChooser.getSelectedItem().toString());
        // 取得一周的"日期"字串
        String[] weekdays = bundle.getWeekdays();
        timeChooser = new JComboBox<>(weekdays);
        menu.add(new JLabel(" 請選擇城市:"));
        menu.add(locationChooser);
        menu.add(new JLabel(" 請選擇日期:"));
        menu.add(timeChooser);

        display = new DisplayPanel();
        MyItemListener itemListener = new MyItemListener();

        locationChooser.addItemListener(itemListener);
        timeChooser.addItemListener(itemListener);

        this.add(menu, BorderLayout.NORTH);
        this.add(display, BorderLayout.CENTER);
    }

    private class DisplayPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (first) {
                return;
            }
            TemperatureBundle bundle = (TemperatureBundle) temperatureMap.get(locationChooser.getSelectedItem().toString());
            // 取得一天的氣象資訊，包含日期、天氣描述、氣溫
            OneDayTemperature[] oneDayTemperatures = bundle.getOneDayTemperatures();
            String description = oneDayTemperatures[timeChooser.getSelectedIndex()].getDescription();
            String temperature = oneDayTemperatures[timeChooser.getSelectedIndex()].getTemperature();

            Font font;
            font = new Font("新細明體", Font.BOLD, 50);
            // TODO - color: Blue, coordiate: 40, 100
            g.setFont(font);
            g.setColor(Color.blue);
            g.drawString(temperature, 40, 40);
            font = new Font("新細明體", Font.BOLD, 30);
            // TODO - color: darkGray, coordiate: 40, 160
            g.setFont(font);
            g.setColor(Color.darkGray);
            g.drawString(description, 40, 160);

        }
    }

    private class MyItemListener implements ItemListener // inner class
    {
        // handle JComboBox event
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                first = false;
                display.repaint();
            }
            if (event.getSource() == locationChooser) {

            }
        } // end method itemStateChanged
    } // end anonymous inner class
}
