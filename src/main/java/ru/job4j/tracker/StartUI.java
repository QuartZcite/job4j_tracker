package ru.job4j.tracker;


public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("\n=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
//        item.setName(name);
        tracker.add(item);
    }

    public static void showAll(Input input, Tracker tracker) {
        System.out.println("\n=== Show all items ====");
        System.out.println("=Id=\t=Name=");
        Item[] out = tracker.findAll();
        for (Item cell : out) {
            System.out.println(cell);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("\n=== Edit item ====");
        int id = input.askInt("Enter Id to edit: ");
        String name = input.askStr("Enter new Name: ");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            System.out.println("Edit successful");
        } else {
            System.out.println("Error edit");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("\n=== Delete item ====");
        int id = input.askInt("Enter Id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("\n=== Find item by Id ====");
        int id = input.askInt("Enter Id: ");
        Item out = tracker.findById(id);
        if (out != null) {
            System.out.println("Found record:\n=Id=\t=Name=\n" + out);
        } else {
            System.out.println("Error, id not found");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("\n=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] out = tracker.findByName(name);
        if (out.length != 0) {
            String plural = out.length > 1 ? "s" : "";
            System.out.println("Found record" + plural + ":\n=Id=\t=Name=");
            for (Item cell : out) {
                System.out.println(cell);
            }
        } else {
            System.out.println("Nothing found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }


    private void showMenu() {
        System.out.println("\nMenu.");
        System.out.println("0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
