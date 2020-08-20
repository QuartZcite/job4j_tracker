package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(System.lineSeparator() + "Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(System.lineSeparator() + "Found record:"
                    + System.lineSeparator()
                    + "=Id=\t=Name="
                    + System.lineSeparator()
                    + item);
        } else {
            out.println(System.lineSeparator() + "Error, id not found");
        }
        return true;
    }
}