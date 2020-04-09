package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String right, String left) {
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int minLength = Math.min(leftChar.length, rightChar.length);
        for (int i = 0; i < minLength; i++) {
            if (leftChar[i] != rightChar[i]) {
                return Character.compare(leftChar[i], rightChar[i]);
            }
        }
        return rightChar.length - leftChar.length;
    }
}
