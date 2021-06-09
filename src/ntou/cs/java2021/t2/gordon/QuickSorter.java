package ntou.cs.java2021.t2.gordon;

public class QuickSorter extends Sorter {
    QuickSort quickSort = new QuickSort();

    @Override
    public void sort(int[] d) {
        System.out.println("Sorting...");
        quickSort.quickSort(d, 0, d.length - 1);
        System.out.println("Quick Sort is done!");
    }
}
