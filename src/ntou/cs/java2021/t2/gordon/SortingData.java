package ntou.cs.java2021.t2.gordon;

import java.util.Arrays;

public class SortingData {

    private int[] input;

    public SortingData(int[] data) {
        input = data;
    }

    public void sort(int type) {
        System.out.println("Sorting...");
        if (type == 1) {
            // Bubble Sort
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input.length - 1; j++) {
                    if (input[j] > input[j + 1]) {
                        int temp = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = temp;
                    }
                }
            }
            System.out.println("Bubble Sort is done!");

        } else if (type == 2) {
            // Selection Sort
            for (int i = 0; i < input.length; i++) {
                int smallIndex = i;
                for (int j = i + 1; j < input.length; j++) {
                    if (input[j] < input[smallIndex])
                        smallIndex = j;
                }
                int temp = input[i];
                input[i] = input[smallIndex];
                input[smallIndex] = temp;
            }
            System.out.println("Selection Sort is done!");
        }
    }

    public void reset(int[] data) {
        this.input = data;
    }

    public void show() {
        System.out.println("The array: " + Arrays.toString(input));
        System.out.println("The last number is: " + input[input.length - 1]);
    }

}
