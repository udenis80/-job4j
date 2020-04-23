package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = x -> x.getName().contains(key);
        Predicate<Person> surName = x -> x.getSurname().contains(key);
        Predicate<Person> phone = x -> x.getPhone().contains(key);
        Predicate<Person> adress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = name.or(surName).or(phone).or(adress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}