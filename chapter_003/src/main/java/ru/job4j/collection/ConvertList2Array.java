package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int row) {
        int num = list.size();
            while (num % row != 0) {
                num++;
            }
            int cell = num / row;
            int[][] array = new int[row][cell];
            int index = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < cell; j++) {
                    if (index >= list.size()) {
                        break;
                    }
                    array[i][j] = list.get(index++);
                }
            }
            return array;
    }
}