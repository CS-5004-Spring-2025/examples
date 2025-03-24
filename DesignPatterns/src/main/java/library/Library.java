package library;

import java.util.*;
import java.util.function.Predicate;

/**
 * A class to store our full library.
 */
public class Library {

    private List<LibraryItem> items;
    private List<CardHolder> users;

    /**
     * Construct a new, empty Library.
     */
    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    /**
     * Add an item to the library.
     *
     * @param item the new item
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Check out the publication with the given title.
     *
     * @param title title of the publication
     * @return true if successful
     */
    public boolean checkoutPublication(String title, CardHolder holder) {

        LibraryItem found = null;
        for (LibraryItem item : items) {
            if (item instanceof Publication p && p.getTitle().equals(title)) {
                found = item;
                break;
            }
        }

        if (found == null || found.isCheckedOut()) {
            return false;
        }
        holder.addCheckedOutItem(found);
        return found.checkoutItem(holder);
    }

    /**
     * Return the number of items available for checkout.
     *
     * @return
     */
    public int countAvailableItems() {
        int count = 0;
        for (LibraryItem item : items) {
            if (!item.isCheckedOut()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return the number of Books that are available for checkout.
     *
     * @return
     */
    public int countAvailableBooks() {

        int count = 0;
        for (LibraryItem item : items) {
            if (!item.isCheckedOut() &&
                    item instanceof Book b) {
                count++;
            }
        }
        return count;
    }


    /**
     * Return a list of all books that are available for checkout
     *
     * @return list of LibraryItem
     */
    public List<LibraryItem> getAvailableBooks() {
        List<LibraryItem> books = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Book b
                    && !b.isCheckedOut()) {
                books.add(b);
            }
        }
        return books;
    }

    /**
     * Return a list of all Magazines that are checked out.
     *
     * @return list of LibraryItem
     */
    public List<LibraryItem> getCheckedOutMagazines() {
        List<LibraryItem> magazines = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Magazine m
                    && m.isCheckedOut()) {
                magazines.add(m);
            }
        }
        return magazines;
    }

//    public List<LibraryItem> filter(Predicate<LibraryItem> filter) {
//        List<LibraryItem> result = new ArrayList<>();
//        for (LibraryItem item : items) {
//            if (filter.test(item)) {
//                result.add(item);
//            }
//        }
//        return result;
//    }

    public List<LibraryItem> filter(Predicate<LibraryItem> predicate) {

        List<LibraryItem> result =
                items.stream()
                        .filter(predicate)
                        .toList();
        return result;
    }

//    public int returnAllItems() {
////        // Option 1
////        items.stream().map(i -> i.returnItem()).toList()
//
//        // Option 2
//
//        int result =
//                items.stream() // gives me stream of 7 LibraryItem
//                .map(LibraryItem::returnItem) // gives me stream of 7 booleans
//                .filter(i -> i) // gives me stream of 2 booleans
//                .toList() // list of 2 booleans
//                        .size(); // size of the list
//        return result;
//
//    }
//
    /*
    mydict = {}
    mydict[a] = [1, 2, 3] // map.put(a, b)
    mydict[a].append(4)
    mydict[a] // map.get(a)
     */


    /*

Map<String, List<Book>> result =
        items.stream()
                .filter(Book.class::isInstance)
                .map(Book.class::cast)
                .collect(Collectors.groupingBy(Book::getAuthor));
return result;
     */

    public Map<String, List<Book>> booksByAuthor() {

        Map<String, List<Book>> result = new HashMap<>();
        for (LibraryItem item : items) {
            if(item instanceof Book b) {
                result.computeIfAbsent(b.getAuthor(), k -> new ArrayList<>())
                        .add(b);
//                String author = b.getAuthor();
//                List<Book> bookList = result.get(author);
//                if (bookList == null) {
//                    bookList = new ArrayList<>();
//                    bookList.add(b);
//                    result.put(author, bookList);
//                } else {
//                    bookList.add(b);
////                    result.put(author, bookList); // not necessary!
//                }

            }
        }
        return result;
    }

    public void addUser(String name, int age) {
        CardHolder holder = new CardHolder(name, age);
        users.add(holder);
    }

    public CardHolder getUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst().orElse(null);
    }

    public boolean returnPublication(String title, CardHolder holder) {
        LibraryItem found =  items.stream()
                .filter(i -> i instanceof  Publication p && p.getTitle().equals(title))
                .findFirst().orElse(null);
        if (found != null && found.isCheckedOut()) {
            return found.returnItem(holder);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Object item : items) {
            result.append(item);
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }

}
