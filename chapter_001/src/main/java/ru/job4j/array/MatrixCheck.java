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
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[data.length - i - 1][i] != data[i][data.length - i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}