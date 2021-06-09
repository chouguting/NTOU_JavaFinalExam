package ntou.cs.java2021.t1.gordon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class CrapsSimulation {
    File usingFile;
    FileWriter fileWriter;
    Formatter formatter;

    int losingCounter = 0;
    int lengthCounter = 0;
    long allRollCount = 0L;

    public CrapsSimulation() {
    }

    public void openFile() {
        usingFile = new File("");
        try {
            fileWriter = new FileWriter("records.txt", false);
            formatter = new Formatter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        losingCounter = 0;
        lengthCounter = 0;
        allRollCount = 0L;

        for (int i = 1; i <= 1000; i++) {
            Craps craps = new Craps();
            craps.play();
            int rollCount = craps.getPlayCount();
            Status gameResult = craps.getGameStatus();
            allRollCount += rollCount;
            if (gameResult == Status.WON) {
                formatter.format(String.format("%d WON %d\n", i, rollCount));
            } else {
                losingCounter += 1;
                formatter.format(String.format("%d LOST %d\n", i, rollCount));
            }
            lengthCounter += 1;
        }
    }

    public void closeFile() {
        formatter.close();
    }

    public void showResults() {
        System.out.println(String.format("The chances of losing are %d / %d = %.2f%%", losingCounter, lengthCounter, ((double) losingCounter / lengthCounter) * 100));
        System.out.println(String.format("The average game length is %.2f rolls", (double) allRollCount / lengthCounter));

    }
}

