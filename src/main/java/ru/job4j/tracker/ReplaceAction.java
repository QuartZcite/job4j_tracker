package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id to edit: ");
        String name = input.askStr("Enter new Name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            out.println(System.lineSeparator() + "Edit successful");
        } else {
            out.println(System.lineSeparator() + "Error edit");
        }
        return true;
    }
}

