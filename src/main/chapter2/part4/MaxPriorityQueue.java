package chapter2.part4;

public class MaxPriorityQueue<T extends Comparable<T>> {

    int n;
    T[] a;

    public MaxPriorityQueue(int maxCapacity) {
       a = (T[]) new Comparable[maxCapacity + 1];
       n = 0;
    }

    public void insert(T item) {
        a[++n] = item;
        swim(n);
    }

    public void removeMax() {
        swap(1, n);
        a[n--] = null;
        sink(1);
    }

    private void swim(int i) {
        int k = i;
        while (k > 1 && less(a[k/2], a[k])) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int i) {
        int k = i;
        while (k <= n/2) {
            int maxChild = k*2 + 1 <= n ? max(k*2, k*2 + 1) : k*2;
            if (less(a[k], a[maxChild])) {
                swap(k, maxChild);
            }
            k++;
        }
    }

    private boolean less(T x, T y) {
        return x.compareTo(y) < 0;
    }

    private int max(int i, int j) {
        return less(a[i], a[j]) ? j : i;
    }

    private void swap(int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print() {
        int depth = getDepth();
        int breadth = getBreadth();
        T[] xs = (T[]) new Comparable[breadth + 1];
        T[][] matrix = (T[][]) new Comparable[depth + 1][breadth + 1];

        for (int i = 1; i <= n; i++) {
            int y = getY(i);
            int x = getX(i);
            matrix[y][x] = a[i];
        }

        print(matrix);
    }

    private double log2(double d) {
        return Math.log(d)/Math.log(2.0);
    }

    private int pow(double a, double b) {
        return (int) Math.pow(a, b);
    }


    private int getDepth() {
        return (int) log2(n) + 1;
    }

    private int getBreadth() {
        int depth = getDepth();
        return pow(2, depth) - 1;
    }

    private int getY(int i) {
        return (int) log2(i) + 1;
    }

    private int getX(int i) {
        int y = getY(i);
        int depth = getDepth();
        return pow(2, depth - y) + (i % pow(2, y - 1)) * pow(2, depth - y + 1);
    }

    private void print(T[][] a) {
        int h = a.length - 1;
        int w = a[0].length - 1;
        for (int y = 1; y <= h; y++) {
            for (int x = 1; x <= w; x++) {
                String value = a[y][x] == null ? "" : String.valueOf(a[y][x].toString());
                System.out.printf("%4s", value);
            }
            System.out.println();
        }

    }

}
