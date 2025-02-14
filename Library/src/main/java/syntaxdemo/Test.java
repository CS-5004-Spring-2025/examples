package syntaxdemo;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // Test the Name record
        Name name1 = new Name("Sami", "Rollins");
        Name name2 = new Name("Sami", "Rollins");
        System.out.println(name1.first());

//        List<BookDemo> books = new ArrayList<>();
//        books.add(new BookDemo("Kindred", new Name("Octavia", "Butler"), BookDemo.BookType.HARD_COVER));
//        books.add(new BookDemo("Parable of the Sower", new Name("Octavia", "Butler"), BookDemo.BookType.HARD_COVER));
//        books.add(new BookDemo("Beloved", new Name("Toni", "Morrison"), BookDemo.BookType.KINDLE));
//        books.add(new BookDemo("I Know Why the Caged Bird Sings", new Name("Maya", "Angelou"), BookDemo.BookType.KINDLE));

    }

}
