package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("\nEnter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("\nFound record:\n=Id=\t=Name=\n" + item);
        } else {
            System.out.println("\nError, id not found");
        }
        return true;
    }
}