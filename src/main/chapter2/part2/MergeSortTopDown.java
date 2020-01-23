package chapter2.part2;

public class MergeSortTopDown {

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] temp = new Comparable[n];
        sort(a, temp, 0, n -1);
    }

    private static void sort(Comparable[] a, Comparable[] temp, int lo, int hi) {
        if (lo == hi)
            return;
        int mid = (hi - lo) / 2 + lo;
        sort(a, temp, lo, mid);
        sort(a, temp, mid + 1, hi);
        merge(a, temp, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] temp, int lo, int mid, int hi) {
        int leftIndex = lo, rightIndex = mid + 1;

        for (int k = lo; k <= hi; k++)
            temp[k] = a[k];

        for (int k = lo; k <= hi; k++) {
            if (leftIndex > mid) {
                a[k] = temp[rightIndex];
                rightIndex++;

            } else if (rightIndex > hi) {
                a[k] = temp[leftIndex];
                leftIndex++;

            } else if (less(temp[leftIndex], temp[rightIndex])) {
                a[k] = temp[leftIndex];
                leftIndex++;

            } else {
                a[k] = temp[rightIndex];
                rightIndex++;
            }
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
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
