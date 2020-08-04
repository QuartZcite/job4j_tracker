package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return  "Delete item";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("\nEnter Id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
