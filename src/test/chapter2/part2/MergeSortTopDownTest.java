package chapter2.part2;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTopDownTest {

    @Test
    public void test() {
        Integer[] a = {1, 5, 23, 11, 4, 6, 3,    11, 3, 64, 334, 10, 43, 2, 52};
        MergeSortTopDown.sort(a);
        Assert.assertTrue(MergeSortTopDown.isSorted(a));
    }
}
