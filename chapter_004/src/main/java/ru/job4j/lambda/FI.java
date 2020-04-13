package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image", 20),
                new Attachment("great", 120),
                new Attachment("image 2", 23)
        };
         Comparator<Attachment> comparator = (a, b) -> {
            System.out.println("Сравним " + b.getName().length() + " с " + a.getName().length());
            return b.getName().length() - a.getName().length();
        };
        Arrays.sort(atts, comparator);
        for (Attachment a : atts
        ) {
            System.out.println(a);
        }
    }
}

