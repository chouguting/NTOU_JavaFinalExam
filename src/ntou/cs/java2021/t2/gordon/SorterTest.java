package ntou.cs.java2021.t2.gordon;

public class SorterTest {

    public static void main(String[] args) {
        int[] input = {100, 92, 43, 87, 23, 7, 68};

        Sorter s1 = new SelectionSorter();
        SortableData data = new SortableData(s1, input);
        data.sort();
        data.show();

        System.out.println();

        Sorter s2 = new BubbleSorter();
        data.setData(input);
        data.setSorter(s2);
        data.sort();
        data.show();
    }
}
