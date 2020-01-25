package chapter2.part3;

public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int pa = partitioning(a, lo, hi);
        sort(a, lo, pa - 1);
        sort(a, pa + 1, hi);
    }

    public static int partitioning(Comparable[] a, int lo, int hi) {
        int left = lo;
        int right = hi+1;
        Comparable p = a[lo];
        while (true) {
            while (less(a[++left], p))
                if (left == hi)
                    break;

            while (less(p, a[--right]))
                if (right == lo)
                    break;

            if (left >= right)
                break;

            swap(a, left, right);
        }

        swap(a, lo, right);

        return right;
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
