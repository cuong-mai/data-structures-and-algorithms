package chapter2.part3;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void test() {
        Integer[] a = {21, 5, 23, 11, 4, 6, 3, 11, 3, 64, 334, 10, 43,  2, 52};
        QuickSort.sort(a);
        Assert.assertTrue(QuickSort.isSorted(a));
    }
}
