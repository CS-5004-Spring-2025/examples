import jsondemo.data.Book;

public class PairDriver {

    public static void main(String[] args) {

        Pair<String, String> pair1 = new Pair("a", "b");
//        Pair pair2 = new Pair(1, 2);
        Pair<Book, String> pair3 = new Pair(
                new Book("Author", "Title", 345),
                "b");

        String upperCase = pair1.getThing1().toUpperCase();
        String author = pair3.getThing1().getAuthor();

    }
}
