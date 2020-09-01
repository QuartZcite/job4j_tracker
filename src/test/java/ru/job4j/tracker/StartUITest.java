package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    // direct tests

    @Test
    public void whenCreateItem() {

        String Name = "Item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", Name, "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name"));
        String replacedName = "new name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    //out tests

    @Test
    public void whenExit() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[] {"0"}
    );
    Tracker tracker = new Tracker();
    UserAction[] actions = {
            new ExitAction(out)
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(System.lineSeparator()
            + "Menu." + System.lineSeparator() +
                    "0. Exit program" + System.lineSeparator()
    ));
    }

    @Test
    public void whenFIndAll() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[] {"0","1"}
    );
    Tracker tracker = new Tracker();
    Item item = new Item("_first_");
    tracker.add(item);
    UserAction[] actions = {
            new FindAllAction(out),
            new ExitAction(out)
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Show all items" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator() + System.lineSeparator()
            + "=Id=\t=Name=" + System.lineSeparator()
            + " 1\t\t_first_" + System.lineSeparator()
            + System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Show all items" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator()
    ));
    }

    @Test
    public void whenFIndAllNothing() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[] {"0","1"}
    );
    Tracker tracker = new Tracker();
//    Item item = new Item("_first_");
//    tracker.add(item);
    UserAction[] actions = {
            new FindAllAction(out),
            new ExitAction(out)
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Show all items" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator() + System.lineSeparator()
            + "=Id=\t=Name=" + System.lineSeparator()
            + "Nothing found" + System.lineSeparator()
            + System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Show all items" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator()
    ));
    }

    @Test
    public void whenFindBySingleName() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[] {"0", "_first_", "1"}
    );
    Tracker tracker = new Tracker();
    Item item = new Item("_first_");
    tracker.add(item);
    UserAction[] actions = {
            new FindByNameAction(out),
            new ExitAction(out)
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Find items by name" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator() + System.lineSeparator()
            + "Found record:" + System.lineSeparator()
            + "=Id=\t=Name=" + System.lineSeparator()
            + " 1\t\t_first_" + System.lineSeparator()
            + System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Find items by name" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator()
    ));
    }

    @Test
    public void whenFindByMultNames() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[] {"0", "_first_", "1"}
    );
    Tracker tracker = new Tracker();
    Item item1 = new Item("_first_");
    tracker.add(item1);
    Item item2 = new Item("_first_");
    tracker.add(item2);
    UserAction[] actions = {
            new FindByNameAction(out),
            new ExitAction(out)
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Find items by name" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator() + System.lineSeparator()
            + "Found records:" + System.lineSeparator()
            + "=Id=\t=Name=" + System.lineSeparator()
            + " 1\t\t_first_" + System.lineSeparator()
            + " 2\t\t_first_" + System.lineSeparator()
            + System.lineSeparator()
            + "Menu." + System.lineSeparator()
            + "0. Find items by name" + System.lineSeparator()
            + "1. Exit program" + System.lineSeparator()
    ));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator() + System.lineSeparator()
                + "Found record:" + System.lineSeparator()
                + "=Id=\t=Name=" + System.lineSeparator()
                + " 1\t\ttest" + System.lineSeparator()
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
        ));
    }


    @Test
    public void whenInvalidInputMenu() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit program" + System.lineSeparator()
                + "Wrong input, you can select: 0 .. 0" + System.lineSeparator()
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit program" + System.lineSeparator()
        ));
    }

}


