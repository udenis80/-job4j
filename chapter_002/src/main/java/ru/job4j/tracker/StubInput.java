package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        boolean exist = false;
        int key = Integer.valueOf(this.ask(question));
        for (int i : range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("out of menu range");
        }
        return key;
    }
}