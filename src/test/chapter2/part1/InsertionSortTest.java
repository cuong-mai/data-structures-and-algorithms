package chapter2.part1;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void test() {
        Integer[] a = {1, 5, 23, 11, 4, 6, 3, 11, 3, 64, 334, 10};
        InsertionSort.sort(a);
        Assert.assertTrue(InsertionSort.isSorted(a));
    }
}
