package chapter3.part1;

import chapter2.part3.QuickSort;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchSymbolTableTest {

    @Test
    public void test() {

        BinarySearchSymbolTable<String, Integer> st = new BinarySearchSymbolTable<>(10);

        st.put("the", 11);
        st.put("cat", 2);
        st.put("in", 7);
        st.put("cat", 24);
        st.put("knows", 1);
        st.put("the", 85);
        st.put("zoo", 7);

        Assert.assertEquals(85, st.get("the").intValue());
        Assert.assertEquals(24, st.get("cat").intValue());
        Assert.assertEquals(7, st.get("in").intValue());
        Assert.assertEquals(1, st.get("knows").intValue());
        Assert.assertNull(st.get("hat"));
        Assert.assertNull(st.get("THE"));

    }
}
