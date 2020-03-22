package ru.job4j.coffee;

/**
 * @author Denis Uhanov (udenis80@mail.ru)
 * @version 1
 * @since 2019
 */

public class CoffeeMachine {
    public int[] changes(int value, int price) {
        int change = (value > price ? value - price : 0);
        int count = 0;
        int[] result = new int[change];
        int[] values = {10, 5, 2, 1};
        for (int i = 0; i < values.length; i++) {
            while (change >= values[i]) {
                change -= values[i];
                result[count++] = values[i];
            }
        }
        int[] coin = new int[count];
        System.arraycopy(result, 0, coin, 0, count);
        return coin;
    }
}