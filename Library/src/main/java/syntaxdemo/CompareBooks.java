package syntaxdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CompareBooks {

    public static void main(String[] args) {

//        BookDemo book1 = new BookDemo("Charlotte's Web", new Name("EB", "White"), BookDemo.BookType.HARD_COVER, 240);
//        BookDemo book2 = new BookDemo("Kindred", new Name("Octavia", "Butler"), BookDemo.BookType.PAPERBACK, 352);
//
//        if (book1.compareTo(book2) < 0) {
//            System.out.println("Book 1 comes before Book 2");
//        } else if (book1.compareTo(book2) == 0) {
//            System.out.println("Book 1 and Book 2 are the same");
//        } else {
//            System.out.println("Book 1 comes after Book 2");
//        }


        List<BookDemo> books = new ArrayList<>();
        books.add(new BookDemo("Charlotte's Web", new Name("EB", "White"), BookDemo.BookType.HARD_COVER, 240));
        books.add(new BookDemo("Kindred", new Name("Octavia", "Butler"), BookDemo.BookType.PAPERBACK, 352));
        books.add(new BookDemo("Parable of the Sower", new Name("Octavia", "Butler"), BookDemo.BookType.HARD_COVER, 210));
        books.add(new BookDemo("A Song of Fire and Ice", new Name("George", "RR Martin"), BookDemo.BookType.KINDLE, 129));
        books.add(new BookDemo("the CATCHER in the RYE", new Name("JD", "Salinger"), BookDemo.BookType.PAPERBACK, 90));

        Collections.sort(books);
        for (BookDemo bookDemo : books) {
            System.out.println(bookDemo);
        }



//        List<BookDemo> result =
//                books.stream()
//                        .filter(b -> b.getAuthor().last().equals("Butler"))
//                        .filter(b -> b.getBookType() == BookDemo.BookType.PAPERBACK)
//                        .toList();
//
//        System.out.println(result);

        //
//        System.out.println(books);


    }
}
