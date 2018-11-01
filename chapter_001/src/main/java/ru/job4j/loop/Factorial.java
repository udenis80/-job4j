package ru.job4j.loop;

/**
 * Вычисляем факториал
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @return result
 */

public class Factorial {

    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}