package ntou.cs.java2021.t2.gordon;

public class BubbleSorter extends Sorter {
    @Override
    public void sort(int[] input) {
        // Bubble Sort
        System.out.println("Sorting...");
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
    }
}
