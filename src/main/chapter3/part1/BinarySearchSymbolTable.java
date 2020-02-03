package chapter3.part1;

public class BinarySearchSymbolTable<K extends Comparable<K>, V> {

    K[] keys;
    V[] values;
    int n;

    public BinarySearchSymbolTable(int cap) {
        keys = (K[]) new Comparable[cap];
        values = (V[]) new Comparable[cap];
        n = 0;
    }

    public V get(K key) {
        int i = rank(key, 0, n-1);
        if (i < n && key.compareTo(keys[i]) == 0)
            return values[i];
        return null;
    }

    public void put(K key, V value) {
        int i = rank(key, 0, n-1);
        if (i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
        } else {
            n++;
            for (int j = i + 1; j < n; j++) {
                keys[j] = keys[j-1];
                values[j] = values[j-1];
            }
            keys[i] = key;
            values[i] = value;
        }

    }

    private int rank(K key, int lo, int hi) {
        if (lo > hi)
            return lo;
        int mid = lo + (hi - lo) / 2;
        if (key.compareTo(keys[mid]) < 0)
            return rank(key, lo, mid-1);
        else if (key.compareTo(keys[mid]) > 0)
            return rank(key, mid+1, hi);
        else
            return mid;
    }
}
