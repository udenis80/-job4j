package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     *
     * @param args
     */

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}