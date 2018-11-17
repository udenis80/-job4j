package ru.job4j.array;

/**
 * Package for MatrixCheck task.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] == data[i + 1][j + 1]) {
                     result = true;
                }
   //             if (data[i][j] == data[data.length - i][j]) {
     //               result = true;
   //             }
            }
        }
        return result;
    }
}