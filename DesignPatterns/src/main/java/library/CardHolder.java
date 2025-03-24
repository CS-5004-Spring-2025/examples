package library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardHolder {

    private String id;
    private String name;
    private int age;
    private List<LibraryItem> checkedOutItems;

    public CardHolder(String name, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.checkedOutItems = new ArrayList<>();
    }

    public void addCheckedOutItem(LibraryItem item) {
        checkedOutItems.add(item);
    }

    public void removeCheckedOutItem(LibraryItem item) {
        checkedOutItems.remove(item);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {

        return "CardHolder{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", checkedOutItems=" + checkedOutItems.size() +
                '}';
    }
}
