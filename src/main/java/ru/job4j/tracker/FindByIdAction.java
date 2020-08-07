package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(System.lineSeparator() + "Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(System.lineSeparator() + "Found record:"
                    + System.lineSeparator()
                    + "=Id=\t=Name="
                    + System.lineSeparator()
                    + item);
        } else {
            System.out.println(System.lineSeparator() + "Error, id not found");
        }
        return true;
    }
}