package chapter2.part1;

public class SelectionSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[indexOfMin])) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                exchange(a, i, indexOfMin);
            }
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
