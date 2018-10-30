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
        int max = first > second ? first : second;
        return max;
    }

    /** Вычисление максимума из трех чисел
     *
     * @param first
     * @param second
     * @param third
     * @return temp
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        temp = Math.max(temp, third);
        return temp;
    }
}