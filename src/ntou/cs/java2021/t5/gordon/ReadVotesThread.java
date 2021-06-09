package ntou.cs.java2021.t5.gordon;

public class ReadVotesThread implements Runnable {

    String filename;
    VoteArray sharedArray;

    public ReadVotesThread(String filename, VoteArray sharedArray) {
        this.filename = filename;
        this.sharedArray = sharedArray;
    }

    @Override
    public void run() {
        ReadVotes readVotes = new ReadVotes(filename, sharedArray);
        readVotes.openFile();
        readVotes.readRecords();
        readVotes.closeFile();
    }
}
