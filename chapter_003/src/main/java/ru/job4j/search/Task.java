package ru.job4j.search;

public class Task {
    private String desc;
    private String number;
    private int priority;


    public Task(String number, String desc) {
        this.desc = desc;
        this.number = number;
    }

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    public String getNumber() {
        return number;
    }
}
