package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("imagination", 20),
                new Attachment("great", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment a, Attachment b) {
                return a.getName().compareTo(b.getName());
            }
        };
        Arrays.sort(atts, comparator);
        for (Attachment c: atts
             ) {
            System.out.println(c);
        }
        Comparator<Attachment> comparator1 = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment a, Attachment b) {
                return b.getName().length() - a.getName().length();
            }
        };
        Arrays.sort(atts,comparator1);
        for (Attachment a : atts
             ) {
            System.out.println(a);
        }
    }
}

