package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenGetAllThenTrackerGiveAllItems() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "0", "Test name 1", "desc1", "0", "test name2", "desc2", "1", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[2].getName(), is("test name2"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "0", "test delete", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input).init();
        assertThat(tracker.findAll()[0].getName(), is("test delete"));
    }

    @Test
    public void whenFindByNameThenTrackerHasFoundItems() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test", "desc2")),
                tracker.add(new Item("test", "desc3")),
                tracker.add(new Item("test", "desc4")),
        };
        Input input = new StubInput(new String[]{"5", "test", "6"});
        new StartUI(input).init();
        assertThat(tracker.findByName("test"), is(items));
    }

    @Test
    public void whenFindByIdThenTrackerHasFoundItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим поиск заявки по ид)
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    String menu() {
        return new StringJoiner(System.lineSeparator(), "", "")
                .add("Меню.")
                .add("0. Добавить новую заявку.")
                .add("1. Вывести все заявки.")
                .add("2. Редактировать заявку.")
                .add("3. Удалить заявку.")
                .add("4. Найти заявку по Id.")
                .add("5. Найти заявку по имени.")
                .add("6. Выход.")
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
        Input input = new StubInput(new String[]{"1", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(menu())
                                .add("-----Список всех заявок-----")
                                .add("Id: " + item.getId())
                                .add("имя: " + item.getName())
                                .add("описание: " + item.getDesc())
                                .add("----------------------------")
                                .add(menu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByNameThenItem() {
        loadOutput();
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", "name", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(menu())
                                .add("------------ Поиск заявки по имени: ")
                                .add("------------ Найденная заявка : ---------")
                                .add("Имя: name ИД " + item.getId() + " ОПИСАНИЕ desc")
                                .add(menu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByIdThenItem() {
        loadOutput();
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(menu())
                                .add("------------ Поиск заявки по Id: ")
                                .add("------------ Найденная заявка : " + item.getId() + "---------")
                                .add("------------ имя : " + item.getName() + "---------")
                                .add("------------ Описание : " + item.getDesc() + "---------")
                                .add(menu())
                                .toString()
                )
        );
    }
}