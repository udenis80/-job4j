package ru.job4j.array;
/**
 * Package for Matrix task.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            table[i][j] = (i + 1) * (j + 1);
        }
        return table;
    }
}