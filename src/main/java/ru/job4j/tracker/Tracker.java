package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] itemNoNull = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (items[i] != null) {
                itemNoNull[size] = items[i];
                size++;
            }
        }
        itemNoNull = Arrays.copyOf(itemNoNull, size);
        return itemNoNull;
    }

    public Item findByName(String key) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                rsl = items[index];

                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}