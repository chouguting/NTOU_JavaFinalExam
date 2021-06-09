package ntou.cs.java2021.t2.gordon;

public class SelectionSorter extends Sorter {
    @Override
    public void sort(int[] input) {
        // Selection Sort
        System.out.println("Sorting...");
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
