package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                break;
            }
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        return result;
    }
}