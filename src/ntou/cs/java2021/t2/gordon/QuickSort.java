package ntou.cs.java2021.t2.gordon;

import java.util.Arrays;

class QuickSort {

    public static void main(String args[]) {
        int[] data = {33, 45, 25, 12, 37};
        QuickSort sorter = new QuickSort();
        sorter.quickSort(data, 0, 4);
        System.out.println(Arrays.toString(data));
    }

    public void quickSort(int[] number, int left, int right) {
        if (left < right) {
            int q = partition(number, left, right);
            quickSort(number, left, q - 1);
            quickSort(number, q + 1, right);
        }
    }

    private int partition(int number[], int left, int right) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (number[j] <= number[right]) {
                i++;
                swap(number, i, j);
            }
        }
        swap(number, i + 1, right);
        return i + 1;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}