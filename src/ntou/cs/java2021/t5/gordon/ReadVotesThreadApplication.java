package ntou.cs.java2021.t5.gordon;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadVotesThreadApplication {

    public static void main(String args[]) {
        VoteArray sharedArray = new VoteArray(56);
        int votes4Trump = 0;
        int votes4Biden = 0;

        ReadVotesThread readThread1 = new ReadVotesThread("vote-1.txt", sharedArray);
        ReadVotesThread readThread2 = new ReadVotesThread("vote-2.txt", sharedArray);
        ReadVotesThread readThread3 = new ReadVotesThread("vote-3.txt", sharedArray);

        // execute the tasks with an ExecutorService
        ExecutorService executor = Executors.newCachedThreadPool();
        // TODO
        executor.execute(readThread1);
        executor.execute(readThread2);
        executor.execute(readThread3);

        executor.shutdown();

        try {
            // wait 1 minute for both writers to finish executing
            boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
            FileWriter fileWriter = new FileWriter("my-t5-result.txt", false);
            if (tasksEnded) {
                Vote[] votes = sharedArray.getArray();
                for (Vote vote : votes) {

                    if (vote.getWinner().equals("Biden")) {
                        votes4Biden += vote.getVotes();
                        fileWriter.write(String.format("%s: %s votes for Biden and 0 votes for Trump\n", vote.getSource(), vote.getVotes()));
                    } else {
                        votes4Trump += vote.getVotes();
                        fileWriter.write(String.format("%s: 0 votes for Biden and %d votes for Trump\n", vote.getSource(), vote.getVotes()));
                    }
                }
            } else {
                System.out.println("Timed out while waiting for tasks to finish.");
            }
            fileWriter.write("\nElection counting is finished!\n");
            fileWriter.write(String.format("Final: %d vote(s) for Biden and %d vote(s) for Trump\n", votes4Biden, votes4Trump));
            fileWriter.close();
        } // end try
        catch (InterruptedException | IOException ex) {
            System.out.println("Interrupted while wait for tasks to finish.");
        } // end catch
    } // end main
} // end class ReadTextFileTest