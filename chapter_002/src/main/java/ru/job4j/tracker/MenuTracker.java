package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        System.out.println("Menu");
        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemByName(5, "Find item by Name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соответсвующие действия
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item ------------");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Find All items: ");
            int numberItem = 1;
            for (Item item : tracker.findAll()) {
                System.out.println("Item № " + numberItem++);
                System.out.println("Name: " + item.getName());
                System.out.println("Desc: " + item.getDesc());
                System.out.println("Create: " + item.getCreate());
                System.out.println("Id: " + item.getId());
            }
        }
    }

    private class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Replace item ------------");
            String id = input.ask("Please, provide item id: ");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item desc: ");
            Item item = new Item(id, name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Заявка после редактирования : ");
                System.out.println("ID: " + item.getId() + " name: " + item.getName() + " desc: " + item.getDesc());
            } else {
                System.out.println("Item not found");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item ------------");
            String id = input.ask("Please, provide item id: ");
            if (tracker.delete(id)) {
                System.out.println("Have done");
            } else {
                System.out.println("Item not found");
            }
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by id : ");
            String id = input.ask("Please, provide item id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("have found the item with id: " + item.getId());
                System.out.println("name: " + item.getName());
                System.out.println("description: " + item.getDesc());
            } else {
                System.out.println("Item not found");
            }
        }
    }

    private class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by name : ");
            String name = input.ask("Please, provide item name: ");
            for (Item item : tracker.findByName(name)) {
                if (item != null) {
                    System.out.println("Have found the item with name: " + item.getName());
                    System.out.println("id: " + item.getId());
                    System.out.println("desc: " + item.getDesc());
                }
                else {
                    System.out.println("Item not found.");
                }
            }
        }
    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Good bay ------------");
        }
    }
}

