package ru.job4j.loop;

/**
 * Вычисляем сумму четныx чисел в диапазоне от start до finish
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @return summ
 */

public class Counter {


    public int add(int start, int finish) {
        int summ = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summ = summ + i;
            }
        }
        return summ;
    }
}