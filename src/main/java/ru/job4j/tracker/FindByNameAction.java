package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr(System.lineSeparator() + "Enter name: ");
        List<Item> item = tracker.findByName(name);
        if (item.size() != 0) {
            String plural = item.size() > 1 ? "s" : "";
            out.println(System.lineSeparator()
                    + "Found record" + plural + ":"
                    + System.lineSeparator()
                    + "=Id=\t=Name=");
            for (Item cell : item) {
                out.println(cell);
            }
        } else {
            out.println(System.lineSeparator() + "Nothing found");
        }
        return true;
    }
}

