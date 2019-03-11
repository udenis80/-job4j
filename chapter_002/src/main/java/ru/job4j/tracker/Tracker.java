package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Realisation of method Tracker
 *
 * @version $Id$
 * @since 0.1
 */

public class Tracker {

    private final Item[] items = new Item[100];  //Массив для хранение заявок.
    private int position;
    private static final Random RN = new Random();


    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализаущий вывод всех заявок
     */

    public Item[] findAll() {
        return Arrays.copyOf(items, this.position);
    }

    /**
     * Метод ищет заявку, совпадающую с Id.
     *
     * @return Item.
     */

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод заменяет заявку на другую.
     */

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                item.setId(id);
                items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку
     *
     * @return Массив заявок без той, что соответствует Id.
     */

    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (items[index].getId().equals(id)) {
                if (index < this.position) {
                    System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                    position--;
                    result = true;
                    break;
                }
                if (index == this.position) {
                    System.arraycopy(items, index + 1, items, index, 1);
                    position--;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод ищет заявку, совпадающую с именем.
     *
     * @return Массив заявок с одним именем.
     */

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                result[count++] = items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }
}