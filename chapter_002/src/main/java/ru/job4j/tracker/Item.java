package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long create;

    public Item() {
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, Long create) {
        this.name = name;
        this.desc = desc;
        this.create = create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    public String getDesc() {
        return this.desc;
    }

    public long getCreate() {
        return this.create;
    }
}