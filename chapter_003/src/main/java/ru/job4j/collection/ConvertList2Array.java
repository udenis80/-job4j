package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int rows) {
        int x = list.size();
        while (x % rows != 0) {
            x++;
        }
        int cells = x / rows;
        int [][] array = new int[rows][cells];
        int y = 0;
        for (int i[] : array) {
            int index = 0;
            for (int j : i) {
                if (y < list.size()) {
                    i[index++] = list.get(y++);
                }
            }
        }
        return array;
    }
}