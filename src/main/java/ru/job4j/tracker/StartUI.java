package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item data = new Item();
        data.setName("test item 1");
        tracker.add(data);
        Item data2 = new Item();
        data2.setName("test item 2");
        tracker.add(data2);
        Item  test = tracker.findById(2);
        System.out.println("Запись с индексом " + test.getId() + " найдена:" + test.getName());
        test = tracker.findByName("test item 2");
        System.out.println("Найдена запись id: " + test.getId() + " name: " + test.getName());
        Item[] test1 = tracker.findAll();
        for (int index = 0; index < test1.length; index++) {
            System.out.println("Перечисление всех ненулевых записей" + test1[index].getName());
        }
    }
}
