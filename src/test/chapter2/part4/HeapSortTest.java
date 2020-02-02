package chapter2.part4;

import org.junit.Assert;
import org.junit.Test;
import utils.ArrayShuffler;

public class HeapSortTest {

    @Test
    public void testInsert() {
        Integer[] a = {21, 5, 23, 19, 4, 6, 3, 11, 37, 64, 334, 10, 100, 21, 21, 5, 43, 26, 14, 63, 34, 64, 42, 89, 52};
        for (int randSeed = 0; randSeed < 1000; randSeed++) {
            a = ArrayShuffler.getShuffledArray(a, randSeed);
            HeapSort.sort(a);
            Assert.assertTrue(HeapSort.isSorted(a));
        }
    }
}
