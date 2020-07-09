package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    @Override
    public String toString() {
        return " " + id + "\t\t" + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}