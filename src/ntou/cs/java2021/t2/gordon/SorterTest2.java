package ntou.cs.java2021.t2.gordon;

public class SorterTest2 {

    public static void main(String[] args) {
        int[] input = {100, 92, 43, 87, 23, 7, 68};

        Sorter s3 = new QuickSorter();
        SortableData data = new SortableData(s3, input);
        data.sort();
        data.show();
    }
}
