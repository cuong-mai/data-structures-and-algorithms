package chapter2.part2;

public class MergeSortTopDown {

    private static Comparable[] temp;

    public static void sort(Comparable[] a) {
        int n = a.length;
        temp = new Comparable[n];
        sort(a, 0, n -1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo == hi)
            return;
        int mid = (hi - lo) / 2 + lo;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        temp = new Comparable[a.length];
        // Merge a[lo..mid] with a[mid+1..hi].
        int leftIndex = lo, rightIndex = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            temp[k] = a[k];

        for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi].
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







//            if (i > mid) {
//                a[k] = aux[j];
//                j++;
//
//            } else if (j > hi) {
//                a[k] = aux[i];
//                i++;
//
//            } else if (less(aux[j], aux[i])) {
//                a[k] = aux[j];
//                j++;
//
//            } else {
//                a[k] = aux[i];
//                i++;
//            }
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
