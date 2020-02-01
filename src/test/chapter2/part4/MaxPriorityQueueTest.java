package chapter2.part4;

import org.junit.Test;
import utils.ArrayShuffler;

public class MaxPriorityQueueTest {

    @Test
    public void testInsert() {
        int randSeed = 0;
        Integer[] a = {21, 5, 23, 19, 4, 6, 3, 11, 37, 64, 334, 10, 100, 21, 21, 5, 43, 26, 14, 63, 34, 64, 42, 89, 52};
        a = ArrayShuffler.getShuffledArray(a, randSeed);

        int n = a.length;
        MaxPriorityQueue<Integer> q = new MaxPriorityQueue<>(n);

        for (int i = 0; i < n; i++) {
            q.insert(a[i]);
        }

        q.print();
        System.out.println("-----------------------------------------------");

        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n - 1; i++) {
            sorted[i] = q.removeMax();
            q.print();
            System.out.println("-----------------------------------------------");
        }

        for (int i = 0; i < n; i++) {
            System.out.print("  " + sorted[i] + "  ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
    }

}
