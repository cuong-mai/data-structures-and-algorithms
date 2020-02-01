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

    public T removeMax() {
        T max = a[1];
        swap(1, n);
        a[n--] = null;
        sink(1);
        return max;
    }

    private void swim(int i) {
        while (i > 1 && less(i/2, i)) {
            swap(i, i/2);
            i = i/2;
        }
    }

    private void sink(int i) {
        while (2*i <= n) {
            int k = 2*i;
            if (k < n && less(k, k + 1))
                k++;
            if (less(i, k)) {
                swap(i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    private boolean less(int i, int j) {
        return a[i].compareTo(a[j]) < 0;
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
