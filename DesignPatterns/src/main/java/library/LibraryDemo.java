package library;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to demonstrate inheritance concepts.
 */
public class LibraryDemo {

    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();
        // no problem adding a Book to a list of LibraryItem
        items.add(new Book("Author", "Title", 500));
        // no problem adding a Magazine to a list of LibraryItem
        items.add(new Magazine("title", 50, 25));

//        // show all items that are available to be checked out
        for (LibraryItem item : items) {
            if (!item.isCheckedOut()) {
                System.out.println(item);
            }
        }

        // show author of all Books
        for (LibraryItem item : items) {
            // changing to (item instanceof Book b) would eliminate need for explicit cast below
            if (item instanceof Book) {
                // downcasting must be explicit
                // https://www.geeksforgeeks.org/upcasting-vs-downcasting-in-java/
                Book b = (Book) item;
                String author = b.getAuthor();
                System.out.println(author);
            }
        }


        Publication b = new Book("Author", "Title", 500);
        // calls Book toString!
        System.out.println(b.toString());

        // p = new Magazine(...)
        // upcasting so it is implicit
        // https://www.geeksforgeeks.org/upcasting-vs-downcasting-in-java/
        Publication p = b;


//        System.out.println(b.getAuthor());
//        System.out.println(b.getPageCount());
//        System.out.println(b.isCheckedOut());

        LibraryItem b2 = new Book("Author", "Title", 500);
//        System.out.println(b2.getAuthor());
//        System.out.println(b2.getPageCount());
        System.out.println(b2.isCheckedOut());

        Publication b3 = new Book("Author", "Title", 500);
//        System.out.println(b3.getAuthor());
        System.out.println(b3.getPageCount());
        System.out.println(b3.isCheckedOut());


    }
}