package chapter2.part4;

public class HeapSort {

    public static void sort(Comparable[] a) {
        doHeap(a);
        doSort(a);
    }

    private static void doHeap(Comparable[] a) {
        int n = a.length;
        for (int k = n/2; k >= 1; k--)
            sink(a, k, n);
    }

    private static void doSort(Comparable[] a) {
        int n = a.length;
        while (n > 1) {
            swap(a, 1, n);
            sink(a, 1, --n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2*k <= n) {
            int p = 2*k;
            if (p < n && less(a, p, p+1)) p++;
            if (less(a, k, p)) {
                swap(a, k, p);
                k = p;
            } else {
                break;
            }
        }
    }

    private static boolean less(Comparable[] a, int k, int p) {
        return a[k-1].compareTo(a[p-1]) < 0;
    }

    private static void swap(Comparable[] a, int k, int p) {
        Comparable temp = a[k-1];
        a[k-1] = a[p-1];
        a[p-1] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int k = 2; k <= a.length; k++) {
            if (less(a, k, k-1)) {
                return false;
            }
        }
        return true;
    }

}
