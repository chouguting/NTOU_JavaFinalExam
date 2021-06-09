package ntou.cs.java2021.t5.gordon;

import java.security.SecureRandom;

public class VoteArray {
    private final static SecureRandom generator = new SecureRandom();
    private final Vote array[]; // the shared Vote array
    private int writeIndex = 0; // index of next element to be written

    // construct a VoteArray of a given size
    public VoteArray(int size) {
        array = new Vote[size];
    } // end constructor

    // add an object to the shared array
    public synchronized void add(Vote vote) {
        int position = writeIndex; // store the write index

        try {
            // put thread to sleep for 0-299 milliseconds
            Thread.sleep(generator.nextInt(300));
        } // end try
        catch (InterruptedException ex) {
            ex.printStackTrace();
        } // end catch

        // put the object in the appropriate element
        array[position] = vote;

        ++writeIndex; // increment index of element to be written next
    } // end method add

    public Vote[] getArray() {
        return array;
    }

    // used for outputting the contents of the shared array
    public String toString() {

        String arrayString = "";

        for (int i = 0; i < array.length; i++) {
            if (null != array[i]) {
                arrayString += array[i];
            }
        }
        return arrayString;
    } // end method toString
} // end class VoteArray
