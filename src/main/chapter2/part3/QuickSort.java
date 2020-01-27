package chapter2.part3;

public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int pa = partition(a, lo, hi);
        sort(a, lo, pa - 1);
        sort(a, pa + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
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

    public static void sort(Comparable[] a, Comparable[] b) {
        int n = a.length;
        sort(a, b, 0, n -1);
    }

    private static void sort(Comparable[] a, Comparable[] b, int lo, int hi) {
        if (lo >= hi)
            return;
        int pi = partition(b, a[lo], lo, hi);
        partition(a, b[pi], lo, hi);
        sort(a, b, lo, pi - 1);
        sort(a, b, pi + 1, hi);
    }

    public static int partition(Comparable[] x, Comparable p, int lo, int hi) {
        int left = lo - 1;
        int right = hi + 1;
        int leftFound = -1;
        int rightFound = -1;
        while (true) {
            while (less(x[++left], p))
                if (left == hi)
                    break;
            while (less(p, x[--right]))
                if (right == lo)
                    break;
            if (left >= right)
                break;

            if (equal(x[left], p)) {
                leftFound = left;
                right++;
            } else if (equal(x[right], p)) {
                rightFound = right;
                left--;
            } else {
                swap(x, left, right);
            }
        }
        if (leftFound > -1) {
            swap(x, leftFound, right);
            return right;
        } else if (rightFound > -1) {
            swap(x, rightFound, left);
            return left;
        } else {
            return left;
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static boolean equal(Comparable x, Comparable y) {
        return x.compareTo(y) == 0;
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
