package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "\"=Id=\t=Name=\"");
        Item[] item = tracker.findAll();
        if (item.length != 0) {
            for (Item cell : item) {
                System.out.println(cell);
            }
        } else {
            System.out.println(System.lineSeparator() + "Nothing found");
        }
        return true;
    }
}
