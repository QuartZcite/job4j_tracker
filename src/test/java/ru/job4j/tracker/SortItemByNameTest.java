package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemByNameTest {
    @Test
    public void sortUp() {
        Item item1 = new Item("One");
        Item item2 = new Item("Two");
        Item item3 = new Item("Three");
        Item item4 = new Item("Four");
        item1.setId(1);
        item2.setId(2);
        item3.setId(3);
        item4.setId(5);
        List<Item> items = new ArrayList<>();
        items.add(item4);
        items.add(item2);
        items.add(item1);
        items.add(item3);
        List<Item> result = new ArrayList<>();
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);
        Collections.sort(items);
        assertThat(items, is(result));
    }

    @Test
    public void sortDown() {
        Item item1 = new Item("One");
        Item item2 = new Item("Two");
        Item item3 = new Item("Three");
        Item item4 = new Item("Four");
        item1.setId(1);
        item2.setId(2);
        item3.setId(3);
        item4.setId(5);
        List<Item> items = new ArrayList<>();
        items.add(item4);
        items.add(item2);
        items.add(item1);
        items.add(item3);
        List<Item> result = new ArrayList<>();
        result.add(item4);
        result.add(item3);
        result.add(item2);
        result.add(item1);
        Collections.sort(items, new SortItemReverse());
        assertThat(items, is(result));
    }

    @Test
    public void sortByName() {
        Item item1 = new Item("11");
        Item item2 = new Item("22");
        Item item3 = new Item("33");
        Item item4 = new Item("44");
        item1.setId(1);
        item2.setId(2);
        item3.setId(3);
        item4.setId(5);
        List<Item> items = new ArrayList<>();
        items.add(item4);
        items.add(item2);
        items.add(item1);
        items.add(item3);
        List<Item> result = new ArrayList<>();
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);
        Collections.sort(items, new SortItemByName());
        assertThat(items, is(result));
    }
}