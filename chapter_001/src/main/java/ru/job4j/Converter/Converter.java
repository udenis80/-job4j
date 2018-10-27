package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
final int kursUS = 60;
final int kursEU = 70;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / this.kursEU;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / this.kursUS;
    }

    /**
     * Конвертируем  евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * this.kursEU;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return value * this.kursUS;
    }
}