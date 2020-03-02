package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        HashSet<String> orig = new HashSet<>();
        for (String i : origin) {
            check.add(i);
            for (String j : text) {
                orig.add(j);
            }
        if (check.containsAll(orig)) {
                rsl = true;
            }
        }
        return rsl;
    }
}
