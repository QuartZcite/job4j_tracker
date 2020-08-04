package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("\nEnter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length != 0) {
            String plural = item.length > 1 ? "s" : "";
            System.out.println("\nFound record" + plural + ":\n=Id=\t=Name=");
            for (Item cell : item) {
                System.out.println(cell);
            }
        } else {
            System.out.println("\nNothing found");
        }
        return true;
    }
}

