package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1String = o1.split("/");
        String[] o2String = o2.split("/");
        int comp = o2String[0].compareTo(o1String[0]);
        if (comp == 0) {
            comp = o1.compareTo(o2);
        }
        return comp;
    }
}
