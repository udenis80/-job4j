package ru.job4j.array;

import java.util.Arrays;

/**
 * Package for Addition two sorted arrays task.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class SumOfArrays {
    public static int[] best(int[] a, int[] b) {

        int[] summ = new int[a.length + b.length]; // создаем новый массив
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            summ[k++] = a[i] < b[j] ? a[i++] : b[j++]; // тернарный оператор

        while (i < a.length)
            summ[k++] = a[i++];


        while (j < b.length)
            summ[k++] = b[j++];

        return summ;
    }
}