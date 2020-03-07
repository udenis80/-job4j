package ru.job4j.tracker;

import java.util.Comparator;

public class Item  {
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

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", create=" + create +
                '}';
    }

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    class CompareItem implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return Integer.valueOf(o1.getName()) - Integer.valueOf(o2.getName());
        }

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