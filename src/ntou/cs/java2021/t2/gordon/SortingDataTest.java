package ntou.cs.java2021.t2.gordon;

public class SortingDataTest {

    public static void main(String[] args) {
        int[] input = {100, 92, 43, 87, 23, 7, 68};

        SortingData data = new SortingData(input);
        data.sort(1);
        data.show();

        System.out.println();
        data.reset(input);
        data.sort(2);
        data.show();
    }
}
