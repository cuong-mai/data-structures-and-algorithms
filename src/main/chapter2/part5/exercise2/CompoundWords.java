package chapter2.part5.exercise2;

/*
2.5.2
Write a program that reads a list of words from standard input
and prints all two-word compound words in the list.
For example, if after, thought, and afterthought
are in the list, then afterthoughtis a compound word.
*/

import chapter2.part3.QuickSort;

import java.util.Arrays;

public class CompoundWords {

    public static String[] getCompoundWords(String[] words) {
        int n = words.length;
        String[] temp = new String[n];
        int count = 0;
        QuickSort.sort(words);
        for (int i = 1; i < words.length; i++) {
            if (words[i].startsWith(words[i-1])) {
                String postfix = words[i].substring(words[i - 1].length());
                int found = Arrays.binarySearch(words, postfix);
                if (found >= 0) {
                    count++;
                    temp[i] = words[i];
                }
            }
        }
        if (count > 0) {
            String[] compounds = new String[count];
            int i = 0;
            for (int j = 0; j < n; j++)
                if (temp[j] != null)
                    compounds[i++] = temp[j];
            return compounds;
        }
        return null;
    }

}
