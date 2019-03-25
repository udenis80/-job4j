package ru.job4j.tracker;

public class StartUI {
    private final Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        Integer[] range = new Integer[menu.getActionsLength()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
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