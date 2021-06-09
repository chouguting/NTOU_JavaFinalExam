package ntou.cs.java2021.t4.gordon;

import javax.swing.*;
import java.io.IOException;

public class WeatherViewerTest {

    public static void main(String args[]) {
        WeatherViewer weatherViewer;
        try {
            weatherViewer = new WeatherViewer();
            weatherViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            weatherViewer.setSize(400, 300); // set frame size
            weatherViewer.setVisible(true); // display frame
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end main
}
