package ru.job4j.tracker;

import java.util.*;

/**
 * Realisation of method Tracker
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final Item[] items = new Item[100];  //Массив для хранение заявок.
    private int position;

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

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getID().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item it : this.items) {
            if (it.getId().equals(id)) {
                it = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                if (index < items.length) {
                    System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                    position--;
                    result = true;
                    break;
                }
                if (index == items.length) {
                    System.arraycopy(items, index + 1, items, index, 1);
                    position--;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        int i;
        Item[] result = new Item[position];
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                System.arraycopy(items, index, result, i, 1);
                i++;
            }
        }
        return result;
    }
}