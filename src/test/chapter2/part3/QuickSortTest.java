package chapter2.part3;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void test() {
        Integer[] a = {21, 5, 23, 11, 4, 6, 3, 11, 3, 64, 334, 10, 43,  2, 52};
//      Integer[] a = {21, 5,  2, 11, 4, 6, 3, 11, 3, 64, 334, 10, 43, 23, 52};
//      Integer[] a = {21, 5,  2, 11, 4, 6, 3, 11, 3, 10, 334, 64, 43, 23, 52};
//      Integer[] a = {10, 5,  2, 11, 4, 6, 3, 11, 3, 21, 334, 64, 43, 23, 52};
//      Integer[] a = {6, 5,  2, 3, 4, 10, 11, 11};
        QuickSort.sort(a);
        Assert.assertTrue(QuickSort.isSorted(a));
    }
}
