package ntou.cs.java2021.t2.gordon;

public abstract class Sorter {
    public abstract void sort(int[] d);

    protected void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}