package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println(System.lineSeparator() + "=Id=\t=Name=");
        List<Item> item = tracker.findAll();
        if (item.size() != 0) {
            for (Item cell : item) {
                out.println(cell);
            }
        } else {
            out.println("Nothing found");
        }
        return true;
    }
}
