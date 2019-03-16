package ru.job4j.tracker;

/**
 * Denis Ukhanov
 * @version $$
 * @since 0.1
 */
public class StartUI {

    private static final String ADD = "0";          // Константа меню для добавления новой заявки.

    private static final String SHOW = "1";         // Константа меню для вывода всех заявок.

    private static final String EDIT = "2";         // Константа меню для редактирования заявки.

    private static final String DELETE = "3";       // Константа меню для удаления заявки.

    private static final String FINDBYID = "4";     // Константа меню для поиска заявки по заданному Id.

    private static final String FINDBYNAME = "5";   // Константа меню для поиска заявки по заданному Name.

    private static final String EXIT = "6";         //Константа для выхода из цикла.

    private final Input input;                      // Получение данных от пользователя.

    private final Tracker tracker;                  // Хранилище заявок.

    /**
     * Конструтор инициализирующий поля.
     *  @param input   ввод данных.
     * @param tracker хранилище заявок.*/
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.findAll();
            } else if (EDIT.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка Id : " + item.getId());
        System.out.println("имя: " + item.getName());
        System.out.println("описание: " + item.getDesc());
    }

    private void findAll() {
        System.out.println("-----Список всех заявок-----");
        for (Item item : tracker.findAll()) {
            System.out.println("Id: " + item.getId());
            System.out.println("имя: " + item.getName());
            System.out.println("описание: " + item.getDesc());
            System.out.println("----------------------------");
        }
    }

    private void replaceItem() {
        System.out.println("------------ Редактирование заявки");
        String id = this.input.ask("Введите id : ");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("------------ Заявка : " + item.getId() + " успешно отредактирована---------");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки");
        String id = this.input.ask("Введите id : ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Нет такой заявки");
        }
    }

    private void findByName() {
        System.out.println("------------ Поиск заявки по имени: ");
        String name = this.input.ask("Введите имя: ");
        for (Item item : tracker.findByName(name)) {
            if (item != null) {
                System.out.println("------------ Найденная заявка : ---------");
                System.out.println("Имя: " + item.getName() + " ИД " + item.getId() + " ОПИСАНИЕ " + item.getDesc());
            }
        }
    }

    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по Id: ");
        String id = this.input.ask("Введите Id : ");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println("------------ Найденная заявка : " + result.getId() + "---------");
            System.out.println("------------ имя : " + result.getName() + "---------");
            System.out.println("------------ Описание : " + result.getDesc() + "---------");
        } else {
            System.out.println("Заявка с таким ИД не найдена");
        }
    }


    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку.");
        System.out.println("1. Вывести все заявки.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по Id.");
        System.out.println("5. Найти заявку по имени.");
        System.out.println("6. Выход.");
    }

    /**
     * Запуск программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
