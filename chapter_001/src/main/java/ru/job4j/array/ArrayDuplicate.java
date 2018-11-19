package ru.job4j.array;

import java.util.Arrays;

/**
 * Package for ArrayDuplicate task.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int duplic = array.length;
        for (int i = 0; i < duplic; i++) {
            for (int j = i + 1; j < duplic; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[duplic - 1];
                    duplic--;
                    j--;
                }

            }
        }
        return Arrays.copyOf(array, duplic);
    }
}