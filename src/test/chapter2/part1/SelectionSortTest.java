package chapter2.part1;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void test() {
        Integer[] a = {1, 5, 23, 11, 4, 6, 3, 11, 3, 64, 334, 10};
        SelectionSort.sort(a);
        Assert.assertTrue(SelectionSort.isSorted(a));
    }
}
