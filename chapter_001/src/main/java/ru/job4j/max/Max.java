package ru.job4j.max;

/**
 * Вычисляем максимум из двух чисел
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @return max
 */

public class Max {

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /** Вычисление максимума из трех чисел
     *
     * @param first
     * @param second
     * @param third
     * @return temp
     */
    public int max(int first, int second, int third) {
        return max(first, second) > third ? max(first, second) : third;
    }
}