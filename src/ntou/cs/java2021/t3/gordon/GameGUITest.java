package ntou.cs.java2021.t3.gordon;

import javax.swing.*;

public class GameGUITest {
    public static void main(String[] args) {
        GameGUI gui = new GameGUI("鋼鐵人", "美國隊長");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 300); // set frame size
        gui.setVisible(true); // display frame
    }
}
