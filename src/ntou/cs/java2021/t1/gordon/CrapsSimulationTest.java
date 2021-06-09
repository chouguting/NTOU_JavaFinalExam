package ntou.cs.java2021.t1.gordon;

public class CrapsSimulationTest {
    public static void main(String args[]) {
        CrapsSimulation game = new CrapsSimulation();
        game.openFile();
        game.simulate(); // play 1000 games of craps
        game.closeFile();
        game.showResults(); // show results of games
    } // end main
} // end class CrapsTest
