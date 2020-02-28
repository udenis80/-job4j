package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Realisation of method Tracker
 *
 * @version $Id$
 * @since 0.1
 */

public class Tracker {

    private final List<Item> items = new ArrayList<>();  // хранение заявок.
    private static final Random RN = new Random();


    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод реализаущий вывод всех заявок
     */

    public List<Item> findAll() {

        return this.items;
    }

    /**
     * Метод ищет заявку, совпадающую с Id.
     *
     * @return Item.
     */

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
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
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                item.setId(id);
                items.set(index, item);
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
        for (int index = 0; index < items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
       //         index--;
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     * Метод ищет заявку, совпадающую с именем.
     *
     * @return Массив заявок с одним именем.
     */

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }
}