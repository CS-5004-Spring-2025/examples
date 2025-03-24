package library;

/**
 * A class to build a new {@link Library Library}
 */
public class LibraryFactory {

    /**
     * Build a "tester" library object.
     *
     * @return the Library object constructed
     */
    public static Library buildLibrary() {
        Library library = new Library();
        library.addItem(new Book("Octavia Butler", "Kindred", 320));
        library.addItem(new Book("JD Salinger", "the CATCHER in the RYE", 241));
        library.addItem(new Magazine("Wired", 56, 10));
        library.addItem(new Book("EB White", "Charlott's Web", 124));
        library.addItem(new Magazine("bon appetit", 75, 19));
        library.addItem(new Book("Octavia Butler", "Parable of the Sower", 298));
        library.addItem(new Book("Octavia Butler", "Dawn", 284));
        library.addUser("Hiromi Berket", 23);
        library.addUser("Hiram Lopez", 78);
        return library;
    }

    /**
     * Build a library object from a CSV file.
     *
     * @return the Library object constructed
     */
    public static Library buildLibraryFromCsv(String filePath) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
