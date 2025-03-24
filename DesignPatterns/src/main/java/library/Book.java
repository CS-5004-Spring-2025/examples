package library;

/**
 * Concrete class that represents a Book.
 *
 * Book inherits all functionality from {@link Publication Publication} and from {@link LibraryItem LibraryItem}
 *
 */
public class Book extends Publication {

    private String author;

    /**
     * Construct a Book object.
     * @param author
     * @param title
     * @param pageCount
     */
    public Book(String author, String title, int pageCount) {

        // FIRST! invoke the superclass constructor
        super(title, pageCount);
        this.author = author;
    }

    /**
     * Return the author
     * @return
     */
    public String getAuthor() {
        return author;
    }

//    @Override
//    public String toString() {
//
//        // this
//        // super
//
//        String partial = super.toString();
//        return "Author: " + author + ", "
//                + partial;
//        // title and pagecount from Publication
//    }

    public void read() {
        // TODO: implement this
    }

    /**
     * Some local testing.
     * @param args
     */
    public static void main(String[] args) {
        LibraryItem b = new Book("Author", "Title", 500);
    }
}
