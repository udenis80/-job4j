package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        int result = 0;
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        for (int i = 0; i < minLength; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (leftChar[i] != rightChar[i]) {
                break;
            }
        }
        return result != 0 ? result : Integer.compare(left.length(), right.length());
    }
}
