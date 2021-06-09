package ntou.cs.java2021.t2.gordon;

import java.util.Arrays;

public class SortableData {

    Sorter sorter;
    private int[] input;

    public SortableData(Sorter sorter, int[] input) {
        this.input = input;
        this.sorter = sorter;
    }

    public void setData(int[] data) {
        this.input = data;
    }

    public void sort() {
        sorter.sort(input);
    }

    public void show() {
        System.out.println("The array: " + Arrays.toString(input));
        System.out.println("The last number is: " + input[input.length - 1]);
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
}
