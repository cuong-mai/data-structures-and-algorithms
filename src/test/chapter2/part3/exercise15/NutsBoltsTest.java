package chapter2.part3.exercise15;

import chapter2.part3.QuickSort;
import org.junit.Assert;
import org.junit.Test;
import utils.ArrayShuffler;

/*

2.3.15 Nuts and bolts. (G. J. E. Rawlins) You have a mixed pile of N nuts and N bolts
and need to quickly find the corresponding pairs of nuts and bolts. Each nut matches
exactly one bolt, and each bolt matches exactly one nut. By fitting a nut and bolt together,
you can see which is bigger, but it is not possible to directly compare two nuts or
two bolts. Give an efficient method for solving the problem.

 */

public class NutsBoltsTest {

    @Test
    public void test() {
        for (int randSeed = 0; randSeed < 1000; randSeed++) {
            System.out.println(randSeed);

            Integer[] a = {21, 5, 23, 19, 4, 6, 3, 11, 37, 64, 334, 10, 43, 2, 52};
            Integer[] nuts = ArrayShuffler.getShuffledArray(a, randSeed);
            Integer[] bolts = ArrayShuffler.getShuffledArray(a, randSeed);

            QuickSort.sort(nuts, bolts);

            Assert.assertTrue(QuickSort.isSorted(nuts));
            Assert.assertTrue(QuickSort.isSorted(bolts));
        }
    }
}
