package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                System.out.println("=Id=\t=Name=");
                Item[] out = tracker.findAll();
                for (Item cell : out) {
                    System.out.println(cell);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter Id to edit: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Edit successful");
                } else {
                    System.out.println("Error edit");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter Id to delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Delete successful");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter Id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item out = tracker.findById(id);
                if (out != null) {
                    System.out.println("Found record:\n=Id=\t=Name=\n" + out);
                } else {
                    System.out.println("Error, id not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
            } else if (select == 6) {
                run = false;
            }
        }
    }


    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n\n");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
