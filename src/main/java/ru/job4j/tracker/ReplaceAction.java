package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("\nEnter Id to edit: ");
        int id = input.askInt("Enter new Name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            System.out.println("\nEdit successful");
        } else {
            System.out.println("\nError edit");
        }
        return true;
    }
}

