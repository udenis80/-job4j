package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int firstLeftPoint = left.indexOf('.');
        int firstRightPoint = right.indexOf('.');
        String[] numbersLeft = left.substring(0, firstLeftPoint).split(" ");
        String[] numbersRight = right.substring(0, firstRightPoint).split(" ");
        int minLen = Math.min(numbersLeft.length, numbersRight.length);
        int result = 0;
        for (int i = 0; i < minLen; i++) {
            int numL = Integer.parseInt(numbersLeft[i]);
            int numR = Integer.parseInt(numbersRight[i]);
            if (numL != numR) {
                result = Integer.compare(numL, numR);
                break;
            }
        }
        return result;
    }
}
