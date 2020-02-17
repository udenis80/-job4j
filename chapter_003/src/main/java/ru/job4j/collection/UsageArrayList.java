package ru.job4j.collection;

import java.util.ArrayList;

public class UsageAlrrayList {
    public static void main(String[] args) {

        Arraylist names = new ArrayList();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (Object value : names) {
            System.out.print(value);
        }
    }
}

