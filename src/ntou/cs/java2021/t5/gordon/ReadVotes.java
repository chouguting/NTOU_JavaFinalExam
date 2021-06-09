package ntou.cs.java2021.t5.gordon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadVotes {

    public static int votes4Trump = 0;
    public static int votes4Biden = 0;
    File fileToOpen;
    private VoteArray sharedArray;
    private String filename;
    private Scanner input;

    public ReadVotes(String filename, VoteArray sharedArray) {
        this.sharedArray = sharedArray;
        this.filename = filename;
    }

    // enable user to open file
    public void openFile() {
        fileToOpen = new File(filename);
        try {
            input = new Scanner(fileToOpen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } // end method openFile

    // read record from file
    public void readRecords() {
        try
        // read records from file using Scanner object
        {
            while (input.hasNext()) {
                String state = input.next();
                String votes = input.next();
                String winner = input.next();
                Vote vote = new Vote(state, Integer.parseInt(votes), winner, filename);
                if (vote.winner.equals("Biden")) {
                    votes4Biden++;
                } else {
                    votes4Trump++;
                }
                sharedArray.add(vote);
            }
        } // end try
        catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } // end catch
        catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        } // end catch
    } // end method readRecords

    // close file and terminate application
    public void closeFile() {
        if (input != null)
            input.close(); // close file
    } // end method closeFile
} // end class ReadTextFile
