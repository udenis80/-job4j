package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            result = left.compareTo(right);
            if (result != 0) {
                result = Integer.compare(left.length(), right.length());
                break;
            }
        }
        return result;
    }
}