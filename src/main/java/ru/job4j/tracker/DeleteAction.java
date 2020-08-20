package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return  "Delete item";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(System.lineSeparator() + "Enter Id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
