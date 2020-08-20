package ru.job4j.tracker;

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
        Item[] item = tracker.findByName(name);
        if (item.length != 0) {
            String plural = item.length > 1 ? "s" : "";
            System.out.println(System.lineSeparator()
                    + "Found record" + plural + ":"
                    + System.lineSeparator()
                    + "=Id=\t=Name=");
            for (Item cell : item) {
                System.out.println(cell);
            }
        } else {
            System.out.println(System.lineSeparator() + "Nothing found");
        }
        return true;
    }
}

