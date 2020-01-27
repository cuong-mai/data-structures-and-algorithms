package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArrayShuffler {

    public static <T> T[] getShuffledArray(T[] source, long seed) {
        List<T> temp = Arrays.asList(source);
        Collections.shuffle(temp, new Random(seed));
        return (T[]) temp.toArray();
    }

    public static <T> T[] getShuffledArray(T[] source) {
        List<T> temp = Arrays.asList(source);
        Collections.shuffle(temp);
        return (T[]) temp.toArray();
    }
}
