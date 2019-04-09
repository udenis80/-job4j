package ru.job4j.tracker;

public class TrackerSingleInsert {
    private TrackerSingleInsert() {
    }

    public static TrackerSingleInsert getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }

    private static final class Holder {
        private static final TrackerSingleInsert INSTANCE = new TrackerSingleInsert();
    }

    public static void main(String[] args) {
        TrackerSingleInsert tracker = TrackerSingleInsert.getInstance();
    }
}
