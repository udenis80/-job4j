package ru.job4j.array;

/**
 * Package for Turn task.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}