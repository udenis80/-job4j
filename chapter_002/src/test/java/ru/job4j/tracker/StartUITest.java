package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
       Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenGetAllThenTrackerGiveAllItems() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "name", "desc", "n", "0", "name1", "desc1", "n", "0", "name2", "desc2", "n", "1", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(1).getName(), is("name1"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "n", "0", "test delete", "desc", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test delete"));
    }

    @Test
    public void whenFindByNameThenTrackerHasFoundItems() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test", "desc2")),
                tracker.add(new Item("test", "desc3")),
                tracker.add(new Item("test", "desc4")),
        };
        Input input = new StubInput(new String[]{"5", "test", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test"), is(items));
    }

    @Test
    public void whenFindByIdThenTrackerHasFoundItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим поиск заявки по ид)
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    String menu() {
        return new StringJoiner(System.lineSeparator(), "", "")
                .add("Menu")
                .add("0, Add new item")
                .add("1, Show all items")
                .add("2, Edit item")
                .add("3, Delete item")
                .add("4, Find item by Id")
                .add("5, Find item by Name")
                .add("6. Exit Program")
                .toString();
    }

    // поле содержит дефолтный вывод в консоль.
    PrintStream stdout = System.out;
    // буфер для результата.
    ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenAddItemTrackerThenFindAllItems() {
        loadOutput();
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(menu())
                                .add("Find All items: ")
                                .add("Item № 1")
                                .add("Name: name")
                                .add("Desc: desc")
                                .add("Create: " + item.getCreate())
                                .add("Id: " + item.getId())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByNameThenItem() {
        loadOutput();
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", "name", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(menu())
                                .add("------------ Find item by name : ")
                                .add("Have found the item with name: name")
                                .add("id: " + item.getId())
                                .add("desc: " + item.getDesc())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByIdThenItem() {
        loadOutput();
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(menu())
                                .add("------------ Find item by id : ")
                                .add("have found the item with id: " + item.getId())
                                .add("name: name")
                                .add("description: desc")
                                .toString()
                )
        );
    }
}