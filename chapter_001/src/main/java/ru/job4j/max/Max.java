package ru.job4j.max;

/**
 * Вычисляем максимум из двух чисел
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @return Максимум
 */

public class Max {

    public int max(int first, int second) {
        int max = first > second ? first : second;
        return max;
    }
}